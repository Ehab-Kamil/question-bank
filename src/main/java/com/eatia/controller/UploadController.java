package com.eatia.controller;

import com.eatia.Model.Exam;
import com.eatia.Model.ExamTemplateConfiguration;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.List;

@Controller
public class UploadController {

	//Save the uploaded file to this folder
	private static String UPLOADED_FOLDER = "F://temp//";

	@GetMapping("/")
	public String index(Model model) {
		ExamTemplateConfiguration configuration = new ExamTemplateConfiguration();
		model.addAttribute("examConfiguration", configuration);
		return "index";
	}

	@PostMapping("/upload")
	public String singleFileUpload(@RequestParam("file") MultipartFile file,
			@ModelAttribute("templateConfiguration") ExamTemplateConfiguration templateConfiguration, Model model) {

		if (file.isEmpty()) {
			model.addAttribute("message", "Please select a file to upload");
			return "uploadStatus";
		}

		ExcelExamCreator examCreator = new ExcelExamCreator();
		try {

			List<Exam> examTemplates = examCreator.doRead(examCreator.convert(file), templateConfiguration);
			model.addAttribute("exams", examTemplates);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}

		//		try {
		//
		//			// Get the file and save it somewhere
		//			byte[] bytes = file.getBytes();
		//			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
		//			Files.write(path, bytes);
		//
		//			redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");
		//
		//		} catch (IOException e) {
		//			e.printStackTrace();
		//		}

		return "uploadStatus";
	}

	@GetMapping("/examTemplate")
	public String getTemplate(@PathParam("examId") Integer examId, Model model) {

		model.addAttribute("exam", ExcelExamCreator.examsMap.get(examId));

		return "examTemplate";
	}

	@GetMapping("/uploadStatus")
	public String uploadStatus() {
		return "uploadStatus";
	}

}
