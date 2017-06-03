/**
 * This is a program for Exercise 4 on Worksheet 4.
 * <p>
 * This is a subclass of the Exam Question. This is a program that marks a
 * numerical answer of a question. The question that is created with this object
 * will be a numerical question.
 * 
 * @author Abdikhaliq Timer
 * @version 14/11/16
 *
 */
public class ExamQuestionNumeric extends ExamQuestion {
	/**
	 * There will only be one variable needed for this class, as the others will
	 * be inherited from the superclass.
	 */
	private int value;
	public int correctMarks;

	/**
	 * The constructor creates a numerical question, that will have a question,
	 * the number of marks that can be awarded and the actual right answer.
	 * 
	 * @param questionText
	 *            This is the question which you want to create, such as "what
	 *            is 5 + 5 ?"
	 * @param maximalMark
	 *            This is the maximal marks available to the question.
	 * @param value
	 *            This is the right answer to the question.
	 */
	public ExamQuestionNumeric(String questionText, int maximalMark, int value) {
		super(questionText, maximalMark); // these are the variables inherited
											// from the superclass.
		this.value = value;
	}

	/**
	 * The method mark will check an answer to a question. It will compare an
	 * answer to the correct answer which was specified when creating the
	 * question object.
	 * 
	 * @param value
	 *            This will be the numerical value which you want to check
	 *            whether or not it actually is right.
	 * @return This will return either the maximum mark if you got the question
	 *         right, and 0 if you got it wrong. Its a mathematical question
	 *         with only one correct answer.
	 */

	public int mark(int value) {

		if (this.value == value) { // this compares the answer given to the
									// correct answer which is already known
									// within the questions object.
			correctMarks = this.getMaximalMark();
			return correctMarks;
		} else {
			return correctMarks = 0;
		}
	}

	@Override
	public String toString() {
		return super.toString() + "\n" + "You scored: " + correctMarks;
	}
}
