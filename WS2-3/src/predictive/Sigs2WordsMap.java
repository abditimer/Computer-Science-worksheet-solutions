package predictive;

public class Sigs2WordsMap {

	public static void main(String[] args) {
		mapDictionary test = new mapDictionary("words.txt");
		for (String i : args) {
			System.out.println(test.signatureToWords(i));
		}
	}

}
