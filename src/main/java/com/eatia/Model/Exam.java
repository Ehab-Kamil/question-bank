package com.eatia.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Title: Exam.java
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
public class Exam {

	private String downloadUrl;

	private int Id;

	private List<QuestionCategory> categories = new ArrayList<>();

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getDownloadUrl() {
		return "/examTemplate?examId=" + this.Id;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public List<QuestionCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<QuestionCategory> categories) {
		this.categories = categories;
	}
}
