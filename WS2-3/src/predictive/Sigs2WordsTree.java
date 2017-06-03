package predictive;

public class Sigs2WordsTree {

	public static void main(String[] args) {
		
		TreeDictionary test = new TreeDictionary("words.txt", new TreeDictionary[8]);
			for (String i : args) {
				System.out.println("(Q4) " + i + " as a word is: " + test.signatureToWords(i));
		}

	}

}
