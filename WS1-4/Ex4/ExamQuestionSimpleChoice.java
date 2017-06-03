import java.util.*;

/**
 * This is a program for Exercise 4 on Worksheet 4.
 * <p>
 * This ExamQuestionSimpleChoice class is a subclass of ExamQuestion. This means
 * that it inherits the methods and variables from it. This program creates exam
 * question objects that are in the form of simple choices. Hence, this program
 * has a mark method that checks to make sure the correct methods have been
 * chosen.
 * 
 * @author Abdikhaliq Timer
 * @version 14/11/16
 *
 */
public class ExamQuestionSimpleChoice extends ExamQuestion {
	/**
	 * This will also inherit methods and variables from the superclass
	 * ExamQuestion.
	 */
	public ArrayList<String> possibleAnswers;
	public int correctAnswer;
	public int finalMark;

	/**
	 * This is the constructor for a simple question, where your choice can
	 * either be right or wrong. This constructor creates a simple question
	 * using the parameters discussed below.
	 * 
	 * @param questionText
	 *            This is the question.
	 * @param maximalMark
	 *            This is the maximum marks you can attain from the question.
	 * @param possibleAnswers
	 *            These are the possible answers for the question.
	 * @param correctAnswer
	 *            This is the correct answer that you should get to attain full
	 *            marks.
	 */
	public ExamQuestionSimpleChoice(String questionText, int maximalMark, ArrayList<String> possibleAnswers,
			int correctAnswer) {
		super(questionText, maximalMark);
		this.possibleAnswers = possibleAnswers;
		this.correctAnswer = correctAnswer;
	}

	/**
	 * This is the method that checks if you have the right answer, giving you
	 * full marks if you do, and 0 if you do not.
	 * 
	 * @param value
	 *            The value given to the simple choice of the question, hence
	 *            this marks if the correct answer has been given.
	 * @return returns the marks this value would get. As there is a right and
	 *         wrong answer, this will either give you right or wrong.
	 */
	public int mark(int value) {
		if (correctAnswer == value) {
			finalMark = this.getMaximalMark();
			return finalMark;
		} else {
			return finalMark = 0;
		}
	}

	@Override
	public String toString() {
		return super.toString() + "\n" + "You scored: " + finalMark;
	}

}
