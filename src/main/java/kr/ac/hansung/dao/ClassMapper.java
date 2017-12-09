package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import kr.ac.hansung.model.Classes;

public class ClassMapper implements RowMapper<Classes>{

	@Override
	public Classes mapRow(ResultSet result, int row) throws SQLException {
		// TODO Auto-generated method stub
		Classes classes = new Classes();

		classes.setYear(result.getInt("year"));
		classes.setSemester(result.getString("semester"));
		classes.setName(result.getString("name"));
		classes.setCode(result.getString("code"));
		classes.setCredit(result.getInt("credit"));
		classes.setSection(result.getString("section"));
		
		return classes;
	}

}
