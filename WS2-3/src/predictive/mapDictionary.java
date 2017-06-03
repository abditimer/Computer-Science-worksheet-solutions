package predictive;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
/**
 * This class will be used to further improve the ability to create a searchable dictionionary from a file.
 * @author Abdikhaliq Timer
 *
 */
public class mapDictionary implements Dictionary {
	//TreeMaps, unlike hashmaps can guarantee that elements will be sorted in ascending order, as specified
	//new Dictionary will be the treeMap that we store our values in
	TreeMap<String, TreeSet<String>> newDictionary = new TreeMap<String, TreeSet<String>>();
	
	
	public mapDictionary(String fileName) {	
		//treeMap gaurentees the order at which the key/value are stored
		try (BufferedReader inputFile = new BufferedReader(new FileReader(fileName))) {
			String singleWord;
			while ((singleWord = inputFile.readLine()) != null) {
				singleWord = singleWord.toLowerCase();
				if (isValidWord(singleWord)) {
					String a = (wordToSignature(singleWord));
					newDictionary.computeIfAbsent(a, key -> new TreeSet<String>()).add(singleWord);
					//COMPUTEIFABSENT returns a new value associated with the specified key/null if none are
				}
			}
			inputFile.close();
		} catch (IOException e){
			System.out.println("There was a problem reading the file, please try again.");
		}
		
		
	}
	
	public Set<String> signatureToWords(String signature) {
		return newDictionary.get(signature);
	}
	

	public static boolean isValidWord(String word) {
		word = word.toLowerCase();
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) < 97 || word.charAt(i) > 122) {
				return false;
			}
		}
		return true;
	}

	public static String wordToSignature(String word){
		StringBuffer sb = new StringBuffer();
	    word = word.toLowerCase();
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

}
