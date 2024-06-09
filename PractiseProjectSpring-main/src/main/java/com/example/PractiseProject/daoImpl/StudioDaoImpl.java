package com.example.PractiseProject.daoImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.PractiseProject.dao.StudioDao;
import com.example.PractiseProject.model.StudioModel;
import com.example.PractiseProject.service.StudioService;
import com.google.gson.Gson;

@Repository
public class StudioDaoImpl implements StudioDao {

	@Autowired
	Gson gson;

	@Autowired
	JdbcTemplate jdbcTemplate;

	static Logger logger = LoggerFactory.getLogger(StudioService.class);

	@Override
	public StudioModel getStudioDetails(StudioModel studioModel) {

		String select = " SELECT * "
		              + " FROM company "
				      + " WHERE company_id = ? ";

		logger.info(" getStudioDetailsImpl Request - " + gson.toJson(studioModel) + "\n" + select);

		try {

			RowMapper<StudioModel> rowMapper = new BeanPropertyRowMapper<StudioModel>(StudioModel.class);

			StudioModel sqlObj = jdbcTemplate.queryForObject(select, rowMapper, studioModel.getCompany_id());

			if (sqlObj != null) {

				logger.info("getStudioDetailsImpl response - " + gson.toJson(sqlObj) + "\n");

				return sqlObj;

			}

		} catch (Exception e) {

			logger.info("getStudioDetailsImpl Exception - " + e.toString() + "\n");
		}

		logger.info("getStudioDetailsImpl response - " + gson.toJson(null) + "\n");

		return null;

	}

}
