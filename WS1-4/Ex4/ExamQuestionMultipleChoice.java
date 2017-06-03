import java.util.ArrayList;

/**
 * This is a program for Exercise 4 on Worksheet 4.
 * <p>
 * This is a subclass of the Exam Question. This is a program that marks an
 * answer to a question.
 * 
 * @author Abdikhaliq Timer
 * @version 14/11/16
 *
 */
public class ExamQuestionMultipleChoice extends ExamQuestion {
	/**
	 * There are two variables needed, including possible answers and correct
	 * answers, but this inherits other variables from the superclass exam
	 * question.
	 */
	public int finalMark;
	public ArrayList<String> possibleAnswers;
	public ArrayList<Integer> correctAnswers;

	/**
	 * The constructor ExamQuestionMultipleChoice creates objects that are
	 * essentially exam questions, which it inherits from the superclass, but
	 * with an additional two arrayLists. This allows us to create objects that
	 * are multiple choice questions, that include the question, the marks you
	 * can get in that question, the possible answers you can choose from and
	 * also the correct answers.
	 * 
	 * @param questionText
	 *            This is the question which the object will have.
	 * @param maximalMark
	 *            This is the maximum marks a question can ahve
	 * @param possibleAnswers
	 *            This is the possible answers that can be chosen for this
	 *            particular question
	 * @param correctAnswers
	 *            This will include the actual correct answers.
	 */
	public ExamQuestionMultipleChoice(String questionText, int maximalMark, ArrayList<String> possibleAnswers,
			ArrayList<Integer> correctAnswers) {
		super(questionText, maximalMark);
		this.possibleAnswers = possibleAnswers;
		this.correctAnswers = correctAnswers;
	}

	/**
	 * mark is the method which can mark a question. It will allow us to check
	 * if a value which we selected is correct or not, which has already been
	 * set in the exam question multiple choice object.
	 * 
	 * @param answersProvided
	 *            This is the answer to the question which you want to be
	 *            checked against.
	 * @return This returns the points that will be awarded for the answers
	 *         given. As this is a multiple choice question, this means there
	 *         normally is more than one correct answer.
	 */
	public int mark(ArrayList<Integer> answersProvided) {

		int overallCorrectAnswers = 0;
		int overallWrongAnswers = 0;

		for (int i = 0; i < answersProvided.size(); i++) { // we will compare
															// each of the
															// provided answers,
															// to our correct
															// answers.
			int CorrectAnswers = 0;
			for (int j = 0; j < correctAnswers.size(); j++) {
				if (answersProvided.get(i) == correctAnswers.get(j)) {
					CorrectAnswers += 1;
				}
			}
			if (CorrectAnswers == 0) { // if the provided answer is not correct,
										// then we make a note that there has
										// been a wrong answer given.
				overallWrongAnswers += 1;
			} else
				overallCorrectAnswers += 1;
		}
		if (overallCorrectAnswers > overallWrongAnswers) { // If there are more
															// wrong answers
															// than right ones,
															// that gives an
															// automatic 0 mark.
			int Scaler = overallCorrectAnswers - overallWrongAnswers;
			double ratio = Scaler / (double) correctAnswers.size();
			finalMark = (int) (ratio * getMaximalMark());
			return finalMark;
		} else
			return finalMark = 0;
	}

	@Override
	public String toString() {
		return super.toString() + "\n" + "You scored: " + finalMark;
	}
}
