package com.example.PractiseProject.contoller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PractiseProject.model.AcademyModel;
import com.example.PractiseProject.service.AcademyService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/payil")
public class AcademyController {
	
	@Autowired
	Gson gson;
	
	@Autowired
	AcademyService academyService;
	
	static Logger logger = LoggerFactory.getLogger(AcademyController.class);
	
	@PostMapping("/getAcademyDetails")
	ResponseEntity<String> getAcademyDetails(@RequestBody AcademyModel academyModel){
		
		logger.info(" getAcademyDetails Request - " + gson.toJson(academyModel) + "\n");

		String Response = academyService.getAcademyDetailsService(academyModel);

		return new ResponseEntity<String>(Response, HttpStatus.OK);
		
	}
	

}
