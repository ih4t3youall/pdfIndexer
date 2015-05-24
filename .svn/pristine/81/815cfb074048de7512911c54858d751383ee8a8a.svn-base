package ar.com.indexer.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ar.com.indexer.configuracion.Configuracion;
import ar.com.indexer.dominio.FileUploadForm;
import ar.com.indexer.upload.FileValidator;
import ar.com.indexer.upload.UploadedFile;

@Controller
public class FileUploadController {

	@Autowired
	public FileValidator fileValidator;
	
	
	
	
	public Configuracion conf ;
	
	
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String displayForm() {
		return "file_upload_form";
	}

	@RequestMapping(value = "/save.htm", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("uploadForm") FileUploadForm uploadForm,
			Model map) {

		List<MultipartFile> files = uploadForm.getFiles();

		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		List<String> fileNames = new ArrayList<String>();

		if (null != files && files.size() > 0) {
			for (MultipartFile multipartFile : files) {

				String fileName = multipartFile.getOriginalFilename();
				fileNames.add(fileName);
				

				try {
					inputStream = multipartFile.getInputStream();

					File newFile = new File(conf.getPATH_BASE() + fileName);
					if (!newFile.exists()) {
						newFile.createNewFile();
					}
					outputStream = new FileOutputStream(newFile);
					int read = 0;
					byte[] bytes = new byte[1024];

					while ((read = inputStream.read(bytes)) != -1) {
						outputStream.write(bytes, 0, read);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}

		ModelAndView mav = new ModelAndView("/upload/file_upload_success");
		mav.addObject("files", fileNames);
		
		return mav;
	}
	
	
	
	@RequestMapping("/natzi.htm")
	public ModelAndView printWelcome(ModelMap model) {

		ModelAndView mav = new ModelAndView("/test/resultado");
		mav.addObject("resultado","natzi");

		return mav;

	}
	

	@RequestMapping("/fileUploadForm.htm")
	public ModelAndView getUploadForm(
			@ModelAttribute("uploadedFile") UploadedFile uploadedFile,
			BindingResult result) {
		return new ModelAndView("uploadForm");
	}

	@RequestMapping("/fileUpload")
	public ModelAndView fileUploaded(
			@ModelAttribute("uploadedFile") UploadedFile uploadedFile,
			BindingResult result) {
		InputStream inputStream = null;
		OutputStream outputStream = null;

		MultipartFile file = uploadedFile.getFile();
		fileValidator.validate(uploadedFile, result);

		String fileName = file.getOriginalFilename();

		if (result.hasErrors()) {
			return new ModelAndView("uploadForm");
		}

		try {
			inputStream = file.getInputStream();

			File newFile = new File(conf.getPATH_BASE() + fileName);
			if (!newFile.exists()) {
				newFile.createNewFile();
			}
			outputStream = new FileOutputStream(newFile);
			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new ModelAndView("/test/showFile", "message", fileName);
	}

	public Configuracion getConf() {
		return conf;
	}

	public void setConf(Configuracion conf) {
		this.conf = conf;
	}
	
	
	
	
}
