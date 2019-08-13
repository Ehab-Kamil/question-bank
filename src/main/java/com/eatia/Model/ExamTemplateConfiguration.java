package com.eatia.Model;

/**
 * <p>
 * Title: ExamTemplateConfiguration.java
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
public class ExamTemplateConfiguration {

	private Integer ExamsNumber;
	private Integer multiChoice;
	private Integer trueFalse;
	private Integer articles;

	public Integer getExamsNumber() {
		return ExamsNumber;
	}

	public void setExamsNumber(Integer examsNumber) {
		ExamsNumber = examsNumber;
	}

	public Integer getMultiChoice() {
		return multiChoice;
	}

	public void setMultiChoice(Integer multiChoice) {
		this.multiChoice = multiChoice;
	}

	public Integer getTrueFalse() {
		return trueFalse;
	}

	public void setTrueFalse(Integer trueFalse) {
		this.trueFalse = trueFalse;
	}

	public Integer getArticles() {
		return articles;
	}

	public void setArticles(Integer articles) {
		this.articles = articles;
	}
}
