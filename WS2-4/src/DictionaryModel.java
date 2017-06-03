import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * This class will be given the keys typed on the keypad via the addCharacter
 * method. it will use the dictionary predict the possible words (or prefix of
 * words) which the user is trying to enter, and then store them internally
 * here.
 * 
 * @author Abdikhaliq Timer
 *
 */
public class DictionaryModel extends java.util.Observable implements DictionaryModelInterface {
	private String currentWord = "";
	private SampleDictionary dict;
	List<String> previousWords = new ArrayList<String>();
	ArrayList<String> screenWords;
	ArrayList<String> a = new ArrayList<>();
	private int numberOfWords;
	private int wordCounter = 0;
	/**
	 * Takes the paths name of the dictionary file and puts it in the internal
	 * data structures
	 * 
	 * @param dictionaryFile
	 *            Path to dictionary file
	 * @throws java.io.IOException
	 */
	public DictionaryModel(String dictionaryFile) throws java.io.IOException {
		this.dict = new SampleDictionary(dictionaryFile);
	}
	/**
	 * uses a default dictionary file
	 * 
	 * @throws java.io.IOException
	 */
	public DictionaryModel() throws java.io.IOException {
		this.dict = new SampleDictionary("words.txt");
	}

	/**
	 * 
	 * @return a list of words typed in so far, including the last word/prefix
	 *         which has not yet been accepted
	 * 
	 *         This method is a way for the View to update the word
	 */
	public List<String> getMessage() {
		return screenWords;
	}

	/**
	 * adds a numeric key that has been typed in by the user. extends the
	 * current word/prefix with other possible matches for the new key -> 2 +
	 * all children
	 * 
	 * @param key
	 */
	public void addCharacter(char key) {
		// the keyed in word into a string word
		String oldWord = this.currentWord;
		this.currentWord = this.currentWord + Character.toString(key);
		this.screenWords = new ArrayList<String>();
		this.screenWords.addAll(this.previousWords);

		if (dict.signatureToWords(this.currentWord).isEmpty() == false) {
			this.screenWords.add(new ArrayList<String>(dict.signatureToWords(this.currentWord)).get(0));
		} else if (dict.signatureToWords(this.currentWord).isEmpty() == true) {
			this.screenWords.add(new ArrayList<String>(dict.signatureToWords(oldWord)).get(0));
		}
		setChanged();
		notifyObservers();
	}

	/**
	 * removes the last character typed in. this should remove the last
	 * character from the current match but it will general enlarge the possible
	 * matches for the current word
	 */
	public void removeLastCharacter() {

		String str = this.currentWord;

		if (str != null && str.length() > 0) {
			str = str.substring(0, str.length() - 1);
		}
		this.currentWord = str;

		this.screenWords = new ArrayList<String>();
		this.screenWords.addAll(this.previousWords);
		this.screenWords.add(new ArrayList<String>(dict.signatureToWords(str)).get(0));

		setChanged();
		notifyObservers();
	}

	/**
	 * This method will allow cycling through the matches to select the next
	 * matching word or prefix among the possible matches.
	 */
	public void nextMatch() {

		while (!(this.currentWord.isEmpty())) {
			// the number of words there are in the list
			this.numberOfWords = dict.signatureToWords(this.currentWord).size();
			// has to get the first word from the list

			if (this.wordCounter > this.numberOfWords) {
				this.wordCounter = 0;
			}

			this.screenWords = new ArrayList<String>();
			this.screenWords.addAll(this.previousWords);

			this.screenWords.add(new ArrayList<String>(dict.signatureToWords(this.currentWord)).get(wordCounter));
			this.wordCounter++;
			setChanged();
			notifyObservers();

		}
	}

	/**
	 * method allows the current matched word to be accepted and added to the
	 * composed message
	 */
	public void acceptWord() {
		this.previousWords = new ArrayList<String>();
		this.previousWords.addAll(this.screenWords);

		setChanged();
		notifyObservers();
		this.screenWords = new ArrayList<String>();
		this.currentWord = "";
		this.screenWords.add(" ");

	}

}
