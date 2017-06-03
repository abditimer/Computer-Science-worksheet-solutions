package predictive;


import java.util.Set;

public class Sigs2WordsProto {
	//this method will need to check that our sign->words method is working
	public static void main(String[] args) {
		
		
		//loop over the words passed as args
		for (String word : args) {
			//one signature can have multiple words, hence a list is needed
			Set<String> list = PredictivePrototype.signatureToWords(word);
			//add each word to a list, and find the compatible words
			System.out.print(word + " -> has the following words -> ");
			//each signature will have multiple words which we will need to add
			for (String resultWords : list) {
				System.out.print(resultWords + " , ");
			}
			System.out.println();
		}
	}

}
