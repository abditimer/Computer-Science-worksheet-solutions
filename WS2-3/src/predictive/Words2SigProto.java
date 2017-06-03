package predictive;
public class Words2SigProto {
	/**
	 * This method needs to be able to call wordsToSignature methods. 
	 * @param args These are the arguments that will be called within the command line.
	 */
	public static void main(String[] args) {
		//multiple strings can be passed through as args
		//we need to loop over the words
		//need an enhanced for loop as standard for loops wont work.
		for (String word: args) {
			if (PredictivePrototype.isValidWord(word))
				System.out.println(word + " -> as a signature gives -> " + PredictivePrototype.wordToSignature(word));
		}
		
	}
}
