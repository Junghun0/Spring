package kr.ac.hansung.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Classes;

@Repository
public class ClassDAO {
	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from class";
		return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class);
	}

	public List<Classes> getOffersInCourse() {
		String sqlStatement = "select * from class ";
		return jdbcTemplateObject.query(sqlStatement, new ClassMapper());
	}

	public List<Classes> getOffersInVirtualCourse() {
		String sqlStatement = "select * from virtual_course ";
		return jdbcTemplateObject.query(sqlStatement, new ClassMapper());
	}

	public List<Classes> getOffersInCourse(int year, String semester) {
		String sqlStatement = "select * from class where year=? and semester=?";
		return jdbcTemplateObject.query(sqlStatement, new Object[] { year, semester }, new ClassMapper());

	}

	public boolean insert(Classes classes) {

		int year = classes.getYear();
		String name = classes.getName();
		String semester = classes.getSemester();
		String code = classes.getCode();
		String section = classes.getSection();
		char credit = (char) classes.getCredit();

		String sqlStatement = "insert into virtual_course (year,semester,code,name,section,credit) values (?,?,?,?,?,?)";
		return (jdbcTemplateObject.update(sqlStatement,
				new Object[] { year, semester, code, name, section, credit }) == 1);

	}

	public boolean delete(int code) {

		String sqlStatement = "delete from class where code=?";
		return (jdbcTemplateObject.update(sqlStatement, new Object[] { code }) == 1);
	}

	public int getMinYear() {
		String sqlStatement = "select min(year) from class ";
		return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class);
	}

	public int getMaxYear() {
		String sqlStatement = "select max(year) from class ";
		return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class);
	}

	public int sumValues() {
		String sqlStatement = "select sum(credit) from class";
		return jdbcTemplateObject.queryForObject(sqlStatement, char.class);
	}

	public int sumValues(String credit) {
		String sqlStatement = "select sum(credit) from class where credit=?";
		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { credit }, Integer.class);
	}

}
