package predictive;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This program is a solution to <b>Prefix-matching (25%).</b>
 * This part involves creating another improved implementation of the Dictionary interface
 * using a data structure which we create.
 * It allows for words/part of words, that match partial signatures, which will evantually allow users to see
 * the word which they are typing.
 * 
 * The data structure that has been implemented consists of: <ol>
 * <li>Root node = List of all the words, using a set.</li>
 * <li>Children nodes = these are in the form of an array, which will be indicated via the signature</li>
 * <li>Prefix = easy way to identify if it has a prefix</li>
 * <li> whether its empty or not</li>
 * 
 * @author Abdikhaliq Timer
 *
 */
public class TreeDictionary implements Dictionary {

	private String dictionaryPath;
	private HashSet<String> root;
	private String prefix;
	private TreeDictionary[] childNodes = new TreeDictionary[8];

	/**
	 * This is a constructor that will construct the first implementation of the tree
	 * @param dictionary The dictionary file which you would like to store
	 * @param signatureNodes A tree containing the children.
	 */
	public TreeDictionary(String dictionaryPath, TreeDictionary[] childNode) {

		this.dictionaryPath = dictionaryPath;
		this.prefix = "";
		
		try (BufferedReader inputFile = new BufferedReader(new FileReader(dictionaryPath))) {
			String singleWords;
			while ((singleWords = inputFile.readLine()) != null) {
				if (isValidWord(singleWords)) {
					//prefix will arrange all the words into the correct child nodes
					//prefixValue == first number from the words string
					String prefix = String.valueOf(wordToSignature(singleWords).charAt(0));
					int prefixValue = Integer.parseInt(prefix) - 2;
					//if the position relating to the stringsPrefix is empty, create new tree
					if (childNode[prefixValue] == null) {
						//create new tree object
						childNode[prefixValue] = new TreeDictionary(prefix, new HashSet<String>(),new TreeDictionary[8]);
						//store the appropriate words in the set
						addWordEntry(childNode[prefixValue], singleWords.toLowerCase());

					} else {
						addWordEntry(childNode[prefixValue], singleWords.toLowerCase());
					}
				}
			}

			inputFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.childNodes = childNode;
	}

	/**
	 * This method creates the subtrees that link the main root, to all the subsequent children.
	 * @param prefix 
	 * @param words A set list of words which are at the node
	 * @param childNodes An array that will link to the children nodes.
	 */
	public TreeDictionary(String prefix, HashSet<String> words, TreeDictionary[] signNodes) {
		this.prefix = prefix;
		this.root = words;
		this.childNodes = signNodes;

	}

	/**
	 * This method allows for more words to be added
	 * @param node
	 * @param word
	 */
	public void addWordEntry(TreeDictionary node, String word) {

		if (word.length() > node.prefix.length()) {
			String charAfterPrefix = wordToSignature(word).substring(node.prefix.length(), node.prefix.length() + 1);

			if (node.childNodes[Integer.parseInt(charAfterPrefix) - 2] == null) {
				TreeDictionary[] nodesOfNodes = new TreeDictionary[8];
				node.childNodes[Integer.parseInt(charAfterPrefix) - 2] = new TreeDictionary(
						node.prefix + charAfterPrefix, new HashSet<String>(), nodesOfNodes);
				addWordEntry(node.childNodes[Integer.parseInt(charAfterPrefix) - 2], word); // node.signNodes[Integer.parseInt(charAfterPrefix)
																							// -
																							// 2].getWords().add(word);

			} else {

				addWordEntry(node.childNodes[Integer.parseInt(charAfterPrefix) - 2], word); // node.signNodes[Integer.parseInt(node.prefix)
																							// -
																							// 2].getWords().add(word);

			}

		}

		node.getWords().add(word);
	}

	
	
	//Methods below are imported from previous files
	//Simple other getters needed.
	
	
	public static boolean isValidWord(String word) {
		word = word.toLowerCase();
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) < 97 || word.charAt(i) > 122) {
				return false;
			}
		}
		return true;
	}

	/** Here are the getters for the TreeDictionary objects */

	public String getPrefix() {
		return prefix;
	}

	public HashSet<String> getWords() {
		return root;
	}

	public TreeDictionary[] getSignNodes() {
		return childNodes;
	}

	/**
	 * Note that wordToSignature() is the exact same as the wordToSignature()
	 * method in PredictivePrototype and has thus been already documented
	 */

	public static String wordToSignature(String word) {
		StringBuffer sb = new StringBuffer();
		word = word.toLowerCase();
		for (Character i : word.toCharArray()) { // enhanced for loop
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
			} else if (i.equals('t') || i.equals('u') || i.equals('v')) {
				sb.append("8");
			} else if (i.equals('w') || i.equals('x') || i.equals('y') || i.equals('z')) {
				sb.append("9");
			} else
				sb.append(" ");
		}
		// Last step is to return the bufferWord containing the signature.
		return sb.toString();
	}

	/**
	 * signatureToWords takes in a specified signature, picks a node its supposed to be in,
	 * and returns all the words associated to that signature
	 */
	@Override
	public Set<String> signatureToWords(String signature) {
		// base case
		if (this.getPrefix().equals(signature)) {
			return this.getWords();
		} else {
			TreeDictionary chosenNode;
			for (TreeDictionary i : this.getSignNodes()) {
				if (signature.startsWith(i.getPrefix())) {
					chosenNode = i;
					return chosenNode.signatureToWords(signature);
				}
			}
			return new HashSet<>();
		}

	}

	public static void main(String[] args) {

		TreeDictionary test = new TreeDictionary("words.txt", new TreeDictionary[8]);

		System.out.println(test.signatureToWords("222222"));

	}

}