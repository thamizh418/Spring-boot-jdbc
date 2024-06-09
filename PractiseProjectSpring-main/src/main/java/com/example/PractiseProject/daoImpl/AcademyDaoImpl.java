package com.example.PractiseProject.daoImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.PractiseProject.dao.AcademyDao;
import com.example.PractiseProject.model.AcademyModel;
import com.example.PractiseProject.model.StudioModel;
import com.example.PractiseProject.service.StudioService;
import com.google.gson.Gson;

@Repository
public class AcademyDaoImpl implements AcademyDao{
	
	@Autowired
	Gson gson;

	@Autowired
	JdbcTemplate jdbcTemplate;

	static Logger logger = LoggerFactory.getLogger(AcademyDaoImpl.class);

	@Override
	public AcademyModel getAcademyDetails(AcademyModel academyModel) {
		
			String select = " SELECT * "
			              + " FROM academy_user "
					      + " WHERE academy_id = ? AND user_type = 'O' LIMIT 0,1";

			logger.info(" getAcademyDetailsImpl Request - " + gson.toJson(academyModel) + "\n" + select);

			try {

				RowMapper<AcademyModel> rowMapper = new BeanPropertyRowMapper<AcademyModel>(AcademyModel.class);

				AcademyModel sqlObj = jdbcTemplate.queryForObject(select, rowMapper, academyModel.getAcademy_id());

				if (sqlObj != null) {

					logger.info("getAcademyDetailsImpl response - " + gson.toJson(sqlObj) + "\n");

					return sqlObj;

				}

			} catch (Exception e) {

				logger.info("getAcademyDetailsImpl Exception - " + e.toString() + "\n");
			}

			logger.info("getStudioDetailsImpl response - " + gson.toJson(null) + "\n");

			return null;

	}

}
