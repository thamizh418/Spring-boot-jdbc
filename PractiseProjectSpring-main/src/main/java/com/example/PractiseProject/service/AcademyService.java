package com.example.PractiseProject.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PractiseProject.dao.AcademyDao;
import com.example.PractiseProject.model.AcademyModel;
import com.google.gson.Gson;

@Service
public class AcademyService {
	
	@Autowired
	Gson gson;

	@Autowired
	AcademyDao academyDao;
	
	static Logger logger = LoggerFactory.getLogger(AcademyService.class);
	
	public String getAcademyDetailsService(AcademyModel academyModel) {
		
		String jsonResponse = "";

		logger.info(" getAcademyDetailsService Request - " + gson.toJson(academyModel) + "\n");

		AcademyModel academyDetails = academyDao.getAcademyDetails(academyModel);

		if (academyDetails != null) {

			jsonResponse = "{\"status\":" + gson.toJson("Success") + ",\"message\":" + gson.toJson("Records available")+ ",\"Data\":" + gson.toJson(academyDetails) + "}";
		} else {

			jsonResponse = "{\"status\":" + gson.toJson("Failure") + ",\"message\":" + gson.toJson("No Records available") + "}";
		}

		return jsonResponse;
		
	}

}
