package predictive;
/**
 * This class will pair numeric signatures with words.
 * This method will be used to pair words with their signatures. 
 * @author Abdikhaliq Timer
 *
 */
public class WordSig implements Comparable<WordSig>{
	//Two field variables are needed, the ones we will be comparing.
	public String words;
	public String signature;
	
	
	/**
	 * This method now creates an object from a given word and its signature.
	 * @param word
	 * @param signature
	 */
	public WordSig(String words, String signature) {
		this.words = words;
		this.signature = signature;
	}	
	
	//I must implemenet the inherited methods from the comparable interface
	//This method compares 2 strings
	
	/**
	 * This method below compares this string to another object.
	 * 
	 * @param ws the object to be compared
	 * @return -1 : if current object is less than, 0 if they are equal, 
	 * or 1 if the object is greater than the argument object. 
	 */
	public int compareTo(WordSig ws) {
		//if they are the same, return o
	/*	if (this.signature.length() > ws.signature.length()) {
			return 1;
		} else if (this.signature.length() < ws.signature.length())
			return -1;
		else
			return 0;*/
		return this.signature.compareTo(ws.signature);
	}
	
	/**
	 * There is no need for a <b>equals</b> method for this exercise.
	 * however normally you need to define an equals method.
	 */
	
	public static void main(String[] args) {
		WordSig test = new WordSig("hello", "123");
		System.out.println(test.toString());
	}
}
