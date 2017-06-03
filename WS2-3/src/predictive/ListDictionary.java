package predictive;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
/**
 * <b>Storing and searching a dictionary (20%)</b>
 * In this section of the worksheet, the following method will implemenet
 * a number of dictionary classes that will be more efficient than the previous attempt.
 * <p>
 * In this case, the method signature2Word will find possible words within the dictionary, 
 * and return possible words, but also return the words with their own signature to a set.
 * <p>
 * This class will read and store a dictionary in memory, but it will store the information as
 * a list of pairs. 
 * 
 * @author Abdikhaliq Timer
 *
 */
public class ListDictionary {
	//The pair of words will be stored within an ArrayList.
	ArrayList<WordSig> newDictionary; 
	
	
	/**
	 * This constructor creates a new Dictionary object, that is the read and stored version
	 * of the dictionary text file.
	 * it gathers all the words and it inserts them all into an ArrayList.
	 * It makes sure to not include: words that are invalid, and it sorts the list.
	 * Its important to note that the list may contain <b>DUPLICATES</b> as its an ArrayList.
	 * 
	 * @param fileName This will be the name of the file
	 */
	public ListDictionary(String fileName) {
		newDictionary = new ArrayList<WordSig>();
		
		//Auto-closing buffer reader from JDK7 (try-without-resources)
		try (BufferedReader inputFile = new BufferedReader(new FileReader(fileName))) {
			String singleWord;
			//take individual words from the dictionary
			while ((singleWord = inputFile.readLine()) != null) {
				//Make sure the word is lowercase
				singleWord = singleWord.toLowerCase();
				//make sure the word is valid
				if (isValidWord(singleWord)) {
					//wordsig auto finds the associated  sig using word2sig.
					WordSig word = new WordSig(singleWord, wordToSignature(singleWord));
					newDictionary.add(word);
				}
				
			}
		//before having the dictionary, we need to sort it
		Collections.sort(newDictionary);
		inputFile.close();
		} catch (IOException e){
			System.out.println("There was an error with the dictionary.");
		}
			
	}
	
	/**
	 * This method will take any word, and return a signature associated with the word.
	 * This is done by using the following keypad:
	 * 	
	 *  *=====*=====*=====*
	 *  |  1  *  2  *  3  |
	 *  |     * abc * def |
	 *  *=====*=====*=====*
	 *  |  4  *  5  *  6  |
	 *  | ghi * jkl * mno |
	 *  *=====*=====*=====*
	 *  |  7  *  8  *  9  |
	 *  | pqrs* tuv * wxyz|
	 *  *=====*=====*=====*
	 *  |  *  *space*  #  |
	 *  |     *     *     |
	 *  *=====*=====*=====*
	 *  
	 *  The above numbers all correspond to a char/character. Hence,
	 *  when we pass a word through our method, it will return a sequence of numbers
	 *  associated with the word. This simple methods requirements include:<ul>
	 *  <li>That you only get a number returned if the characters of the words are in the alphabet</li>
	 *  <li> If its not one of the 26 letters in the alphabet, a space will be returned.</li>
	 *  </ul>
	 *  
	 * @param word A string containing a single word.
	 * @return A string of the signature belonging to the word.
	 */
	public static String wordToSignature(String word){
		//The reason for a bufferWord is so that we can mutate it and add to it as we 
		// iterate through the word passed into the method.
	    StringBuffer sb= new StringBuffer();
	    // We now want to iterate through the word, one character at a time
	    for (Character i: word.toCharArray()) { //enhanced for loop
	        if (i.equals('a') || i.equals('b') || i.equals('c')) {
	            sb.append("2");
	        } else if (i.equals('d') || i.equals('e') || i.equals('f')) {
	            sb.append("3");
	        } else if (i.equals('g') || i.equals('h') || i.equals('i')) {
	            sb.append("4");
	        } else if (i.equals('j') || i.equals('k') || i.equals('l')) {
	            sb.append("5");
	        } else if (i.equals('m') || i.equals('n') || i.equals('o')) {
	            sb.append("6");
	        } else if (i.equals('p') || i.equals('q') || i.equals('r') || i.equals('s')) {
	            sb.append("7");
	        } else if (i.equals("t") || i.equals("u") || i.equals("v")) {
	            sb.append("8");
	        } else if (i.equals('w') || i.equals('x') || i.equals('y') || i.equals('z')) {
	            sb.append("9");
	        } else sb.append(" ");
	    }
	    //Last step is to return the bufferWord containing the signature.
	    return sb.toString();
	}
	
	/**
	 * This method is a helper method that checks if a given word is valid. 
	 * It returns true if the word is a string that contains only alphabetical characters.
	 * @param word A single word for which we will check to see if its characters are between a and z
	 * @return boolean that will check if the characters of the word are between a and z
	 */
	public static boolean isValidWord(String word) {
		// this method needs to check whether a given word is valid
		// hence does it contain letters and shit
		//need to make sure all words are lowercase and between a and z.
		word = word.toLowerCase();
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) < 97 || word.charAt(i) > 122) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * This method will search the dictionary using a binary search method,
	 * and it will find a given signatures words.
	 * Binary search returns an index position where the signature can be found,
	 * the method will then check above and below this index, making sure
	 * all possible matches are found.
	 * @param signature a string of the signature 
	 * @return A list of string type words with matching signatures.
	 */

	public Set<String> signatureToWords(String signature){
		
		Set<String> words= new TreeSet<String>();
		WordSig currentSignature= new WordSig("", signature);
		
		int i = Collections.binarySearch(this.newDictionary, currentSignature);
		int indexForward = i;
		int indexBackward = i;

		words.add(this.newDictionary.get(i).words);
		while (this.newDictionary.get(indexForward+1).signature.equals(signature)){
			words.add(this.newDictionary.get(indexForward+1).words);
			indexForward++;
		}
		while (this.newDictionary.get(indexBackward-1).signature.equals(signature)){
			words.add(this.newDictionary.get(indexBackward-1).words);
			indexBackward--;
		}
		return words;
	}

}
