package com.eatia.controller;

import com.eatia.Model.Exam;
import com.eatia.Model.ExamTemplateConfiguration;
import com.eatia.Model.Question;
import com.eatia.Model.QuestionCategory;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Title: ExcelExamCreator.java
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
public class ExcelExamCreator {

	public static Map<Integer, Exam> examsMap = new HashMap<>();

	public List<Exam> doRead(File file, ExamTemplateConfiguration templateConfiguration) throws IOException, InvalidFormatException {

		Workbook workbook = WorkbookFactory.create(file);

		Iterator<Sheet> sheetIterator = workbook.sheetIterator();

		//This needs to be predefined size
		List<QuestionCategory> categories = new ArrayList<>();

		DataFormatter dataFormatter = new DataFormatter();
		int index = 0;

		workbook.forEach(sheet -> {
			List<Question> questions = new ArrayList<>();

			sheet.forEach(row -> {
				questions.add(new Question(dataFormatter.formatCellValue(row.getCell(0))));
			});
			QuestionCategory category = new QuestionCategory();
			category.setQuestions(questions);
			categories.add(category);
		});
		workbook.close();

		return createExams(templateConfiguration, categories);
	}

	private List<Exam> createExams(ExamTemplateConfiguration templateConfiguration, List<QuestionCategory> categories) {
		List<Exam> exams = new ArrayList<>();
		int examId = 0;
		for (int i = templateConfiguration.getExamsNumber(); i > 0; i--) {
			Exam exam = new Exam();
			examId++;
			exam.setId(examId);

			categories.forEach(questionCategory -> {
				QuestionCategory examCategory = new QuestionCategory();
				examCategory.setQuestions(questionCategory.pickNRandom(5));
				exam.getCategories().add(examCategory);
			});
			exams.add(exam);
			ExcelExamCreator.examsMap.put(examId, exam);
		}

		return exams;
	}

	public File convert(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		convFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}

}
