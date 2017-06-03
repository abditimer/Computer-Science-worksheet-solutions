package predictive;

import org.junit.Test;

/**
 * The following is a test file for the sigs2Words prototype
 * 
 * @author Abdikhaliq Timer
 *
 */
public class Sigs2WordProtoTest {

	@Test
	public void ex3test1() {
		Words2SigProto.main(new String[] {"Hello", "World!", "this", "is", "the", "input"});
        System.out.println();
	}
	
	@Test
    public void ex3test2() {
		Sigs2WordsProto.main(new String[]{"4663", "937"});
        System.out.println();
    }

}
