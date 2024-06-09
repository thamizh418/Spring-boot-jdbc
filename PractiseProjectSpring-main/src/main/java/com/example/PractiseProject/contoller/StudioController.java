package com.example.PractiseProject.contoller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.PractiseProject.model.StudioModel;
import com.example.PractiseProject.service.StudioService;
import com.google.gson.Gson;

@RestController //@controller + @ResponseBody
@RequestMapping("/myStudio") // Mapping Req
public class StudioController {

	@Autowired // Creating bean
	Gson gson;

	@Autowired
	StudioService studioService;

	static Logger logger = LoggerFactory.getLogger(StudioController.class);

	@PostMapping("/getStudioDetails") // @RequestMapping(value = "/getStudioDetails", method = RequestMethod.POST)
	public ResponseEntity<String> getStudioDetails(@RequestBody StudioModel studioModel) {

		logger.info(" getStudioDetails Request - " + gson.toJson(studioModel) + "\n");
//		logger.warn("this is a warn message");
//		logger.error("this is a error message");

		String Response = studioService.getStudioDetailsService(studioModel);

		return new ResponseEntity<String>(Response, HttpStatus.OK);

	}

}
