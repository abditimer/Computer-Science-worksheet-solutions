package predictive;

import org.junit.Test;


/**
 * Following tests the Tree data structure that I implemented. 
 * Only one test is needed as you can insert multiple signatures. 
 * 
 * You can notice how the one program returns a more limited amount of words compared to the first test.
 * 
 * @author Abdikhaliq Timer
 *
 */
public class Sigs2WordTreeTest {

	@Test
	public void sig2wordTreeTest1() {
		Sigs2WordsTree.main(new String[] {"9"});
		System.out.println();
		Sigs2WordsTree.main(new String[] {"99"});
		
	}
}
