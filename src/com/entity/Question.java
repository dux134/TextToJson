package com.entity;

public class Question implements Comparable<Question> {
	private int queNo;
	private String ques;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private String answer;
	private String isSolved;

	public Question() {
		super();
	}

	public Question(int queNo,String ques, String optionA, String optionB, String optionC, String optionD) {
		super();
		this.queNo= queNo;
		this.ques = ques;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
	}

	public int getQueNo() {
		return queNo;
	}

	public void setQueNo(int queNo) {
		this.queNo = queNo;
	}

	public String getQues() {
		return ques;
	}

	public void setQues(String ques) {
		this.ques = ques;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public boolean isNull() {
		if(getQues()==null || getOptionA()==null || getOptionB()==null || getOptionC()==null ||getOptionD()==null || getAnswer()==null)
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "Question [ques=" + ques + ", optionA=" + optionA + ", optionB=" + optionB + ", optionC=" + optionC
				+ ", optionD=" + optionD + ", answer=" + answer + "]\n";
	}

	@Override
	public int compareTo(Question arg0) {
		return this.getQueNo() > arg0.getQueNo() ? 1 : -1;
	}

}
