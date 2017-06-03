package predictive;

/**
 * Following tests the list that I implemented. 
 * 
 * @author Abdikhaliq Timer
 *
 */
public class Sigs2WordsList {
	
	public static void main(String[] args) {
		ListDictionary l = new ListDictionary("words.txt");
		
		
		
		for (String i : args) {

			long startTime = System.nanoTime();
			System.out.println(PredictivePrototype.signatureToWords(i));
			long elapsedTime = System.nanoTime() - startTime;
	
			System.out.println(elapsedTime + " (Mili-seconds) : for predictive proto");
			
			long startTime2 = System.nanoTime();
			System.out.println(l.signatureToWords(i));
			long elapsedTime2 = System.nanoTime() - startTime2;
			System.out.println(elapsedTime2 + " (Mili-seconds) : for dictionary List");
			
			long percentageDifference = (elapsedTime - elapsedTime2);
			long a = Math.floorDiv(elapsedTime, 100000);
			System.out.println("The predictive prototype is " + a + " Miliseconds slower.");
			System.out.println("------------------------------------------------------");
		}

		
	}
}
