import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

/**
 * This is a JUnit file that checks Exercise 4.
 * <p>
 * This JUnit checks my programs, hence it has numerous different tests that
 * ensure that the 4 java files I created to answer Ex4 are correct.
 * 
 * @author Abdikhaliq Timer
 * @version 14/11/16
 *
 */
public class Ws4PublicTestsEx4 {

	private ExamQuestionNumeric numericQuestion;
	private ExamQuestionSimpleChoice simpleChoiceQuestion;
	private ExamQuestionMultipleChoice multipleChoiceQuestion;

	@Before
	public void setup() {
		numericQuestion = new ExamQuestionNumeric("What is 1 add 1?", 1, 2);

		ArrayList<String> simpleChoiceAnswers = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5"));
		simpleChoiceQuestion = new ExamQuestionSimpleChoice("What is 5 minus 2?", 5, simpleChoiceAnswers, 3);

		ArrayList<String> possibleAnswers = new ArrayList<>(Arrays.asList("-2", "-1", "0", "1", "2", "3"));
		ArrayList<Integer> correctAnswers = new ArrayList<>(Arrays.asList(1, 5));
		multipleChoiceQuestion = new ExamQuestionMultipleChoice("find y if y^3 = 8'", 10, possibleAnswers,
				correctAnswers);
	}

	/**
	 * This checks the numeric exam questions
	 */
	@Test
	public void ex4PublicTest1() {

		int expected = 0;
		int actual = numericQuestion.mark(4);

		assertEquals(expected, actual);
	}

	@Test
	public void ex4PublicTest2() {

		int expected = 1;
		int actual = numericQuestion.mark(2);

		assertEquals(expected, actual);
	}

	/**
	 * This checks if the correct from the simple choice anwswers was chosen
	 */
	@Test
	public void ex4PublicTest3() {

		int expected = 5;
		int actual = simpleChoiceQuestion.mark(3);

		assertEquals(expected, actual);
	}

	@Test
	public void ex4PublicTest4() {

		int expected = 0;
		int actual = simpleChoiceQuestion.mark(2);

		assertEquals(expected, actual);
	}

	/**
	 * The following below checks if the correct multiple choice question is
	 * picked
	 */
	@Test
	public void ex4PublicTest5() {

		ArrayList<Integer> givenAnswers = new ArrayList<>(Arrays.asList(1, 5));

		int expected = 10;
		int actual = multipleChoiceQuestion.mark(givenAnswers);

		assertEquals(expected, actual);
	}

	@Test
	public void ex4PublicTest6() {

		ArrayList<Integer> givenAnswers = new ArrayList<>(Arrays.asList(1, 3));

		int expected = 0;
		int actual = multipleChoiceQuestion.mark(givenAnswers);

		assertEquals(expected, actual);
	}

	@Test
	public void ex4PublicTest7() {

		ArrayList<Integer> givenAnswers = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

		int expected = 0;
		int actual = multipleChoiceQuestion.mark(givenAnswers);

		assertEquals(expected, actual);
	}

	@Test
	public void ex4PublicTest8() {

		ArrayList<Integer> givenAnswers = new ArrayList<>(Arrays.asList(1));

		int expected = 5;
		int actual = multipleChoiceQuestion.mark(givenAnswers);

		assertEquals(expected, actual);
	}

	@Test
	public void ex4PublicTest9() {

		ArrayList<Integer> givenAnswers = new ArrayList<>(Arrays.asList(1, 2, 5));

		int expected = 5;
		int actual = multipleChoiceQuestion.mark(givenAnswers);

		assertEquals(expected, actual);
	}

	@Test
	public void ex4PublicTest10() {

		ArrayList<Integer> givenAnswers = new ArrayList<>(Arrays.asList(1, 3, 4, 5, 6, 7));

		int expected = 0;
		int actual = multipleChoiceQuestion.mark(givenAnswers);

		assertEquals(expected, actual);
	}

}
