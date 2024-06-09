package com.example.PractiseProject.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PractiseProject.dao.StudioDao;
import com.example.PractiseProject.model.StudioModel;
import com.google.gson.Gson;

@Service
public class StudioService {

	@Autowired
	Gson gson;

	@Autowired
	StudioDao studioDao;

	static Logger logger = LoggerFactory.getLogger(StudioService.class);

	public String getStudioDetailsService(StudioModel studioModel) {

		String jsonResponse = "";

		logger.info(" getStudioDetailsService Request - " + gson.toJson(studioModel) + "\n");

		StudioModel studioDetails = studioDao.getStudioDetails(studioModel);

		if (studioDetails != null) {

			jsonResponse = "{\"status\":" + gson.toJson("Success") + ",\"message\":" + gson.toJson("Records available")+ ",\"Data\":" + gson.toJson(studioDetails) + "}";
		} else {

			jsonResponse = "{\"status\":" + gson.toJson("Failure") + ",\"message\":" + gson.toJson("No Records available") + "}";
		}

		return jsonResponse;

	}

}
