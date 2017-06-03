package predictive;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class PredictivePrototype {
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
	    StringBuffer sb = new StringBuffer();
	    word = word.toLowerCase();
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
	        } else if (i.equals('t') || i.equals('u') || i.equals('v')) {
	            sb.append("8");
	        } else if (i.equals('w') || i.equals('x') || i.equals('y') || i.equals('z')) {
	            sb.append("9");
	        } else 
	        	sb.append(" ");
	    }
	    //Last step is to return the bufferWord containing the signature.
	    return sb.toString();
	}
	
	/**
	 * This method, takes in a signature, and returns all the associated words which can be found
	 * within the dictionary file provided. 
	 * @param signature the signature of a word as a String
	 * @return The possible words relating to the signature.
	 */
	public static Set<String> signatureToWords(String signature) {
		
		String currentLine = null;
		Set<String> listOfWords = new TreeSet<>();
		
		final String fileName = "words.txt";
		
		

		// we need to try
		// try to read the dictionary
		// read each line of the dictionary
		// compare our signature to each line
		// add it to some kind of set
		// make sure you dont get duplicates
		// make sure its lowercase

		try (BufferedReader inputFile = new BufferedReader(new FileReader(fileName))){
			// create a link to the file - inputstream test
			while ((currentLine = inputFile.readLine()) != null) {
				// If signature length == dictionary word length
				if (isValidWord(currentLine)) {
					//compare if the word is the same && ignore non-alphabetic characters
					if (signature.equals(wordToSignature(currentLine))) {
							// as hashSets dont allow duplicates
						currentLine = currentLine.toLowerCase();
						if (!(listOfWords.contains(currentLine)))
							listOfWords.add(currentLine);
					}
				}
			}
		} catch (IOException e) {
			System.out.println("There was an error, no file found.");
		} 
		return listOfWords;
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
	
	public static void main(String[] args) {
		//final String fileName = "E:\\words.txt";
		//System.out.println("words.txt");
		System.out.println(signatureToWords("2"));
		System.out.println(signatureToWords("4663"));
		System.out.println(signatureToWords("9"));
		
		
		/* Making sure the file works
		 * 
		 * try (BufferedReader inputFile = new BufferedReader(new FileReader("words.txt"))){
			String line;
			while ((line = inputFile.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}
}

	