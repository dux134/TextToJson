package com.entity;

import org.omg.CORBA.IMP_LIMIT;

public class Answer implements Comparable<Answer> {
	String answerN;
	String ans;

	public Answer() {
		super();
	}

	public String getAnswerN() {
		return answerN;
	}

	public void setAnswerN(String answerN) {
		this.answerN = answerN;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	@Override
	public String toString() {
		return "Answer [answerN=" + answerN + ", ans=" + ans + "]\n";
	}

	@Override
	public int compareTo(Answer o) {
		return this.getAnswerN().compareTo(o.getAnswerN());
	}
}