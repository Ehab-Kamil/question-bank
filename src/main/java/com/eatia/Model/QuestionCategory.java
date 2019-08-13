package com.eatia.Model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * Title: QuestionCategory.java
 * </p>
 *
 * <p>
 * Description:
 * </p>
 *
 * <p>
 * Copyright: Copyright(c) Ehab Kamil, 2019
 * </p>
 *
 * @author <a href="mailto:ehab.atia@ITWorx">Ehab Attia</a>
 * @version 1.0
 * @date 12/08/2019
 */
public class QuestionCategory {

	private int countToBechoosen;

	private List<Question> questions;

	public List<Question> pickNRandom(int n) {
		List<Question> copy = new LinkedList<Question>(questions);
		Collections.shuffle(copy);
		return copy.subList(0, n);
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public int getCountToBechoosen() {
		return countToBechoosen;
	}

	public void setCountToBechoosen(int countToBechoosen) {
		this.countToBechoosen = countToBechoosen;
	}
}
