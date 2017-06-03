/**
 * This is a program for Exercise 4 on Worksheet 4.
 * <p>
 * This ExamQuestion class creates objects of questions, that have the question
 * in text form, and a maximum mark which can be scored.
 * 
 * @author Abdikhaliq Timer
 * @version 14/11/16
 *
 */
public class ExamQuestion {
	/**
	 * The following field variables are the question which the object will be
	 * based on, and a maximal mark which you could attain from the question.
	 */
	private String questionText;
	private int maximalMark;

	/**
	 * The following is a constructor for ExamQuestion, that creates exam
	 * question objects that contain the two field variables; questionText and
	 * maximalMark.
	 * 
	 * @param questionText
	 *            This is the question which the object will contain, such as
	 *            "what is 3 + 3 = ?"
	 * 
	 * @param maximalMark
	 *            This is the maximum marks possible which someone could attain
	 *            by answering the question correctly
	 */
	public ExamQuestion(String questionText, int maximalMark) {
		this.questionText = questionText;
		this.maximalMark = maximalMark;
	}

	/**
	 * This is a getter for the question of the object. It will get the question
	 * that is set within the object, and return it in the form of a String.
	 * 
	 * @return The question that has been set within this object.
	 */
	public String getQuestionText() {
		return questionText;
	}

	/**
	 * The question of the exam question will be set with this setter.
	 * 
	 * @param questionText
	 *            The question which you want to set the objects question as, is
	 *            the parameter of this method.
	 */
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	/**
	 * This method gets the maximum marks that the question has been set to
	 * through the constructor.
	 * 
	 * @return Maximum marks that you can attain by answering the question will
	 *         be returned
	 */
	public int getMaximalMark() {
		return maximalMark;
	}

	/**
	 * This is a setter for setting the maximum mark of the exam question.
	 * Hence, this will change the maximum marks of the exam question.
	 * 
	 * @param maximalMark
	 *            this is the maximum marks which someone can attain, which you
	 *            would like to set for the exam question object.
	 */
	public void setMaximalMark(int maximalMark) {
		this.maximalMark = maximalMark;
	}

	/**
	 * The toString method here will be used to represent the object as a
	 * string.
	 */
	@Override
	public String toString() {
		return "Question (maximal mark: " + getMaximalMark() + "): " + getQuestionText();
	}

}
