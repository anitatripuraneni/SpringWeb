package com.spring.web.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
@Component("updateEmployeeDao")
public class UpdateEmployeeDao {
	
	private NamedParameterJdbcTemplate jdbc;


	
	@Autowired
	public void setDataSource(DataSource jdbc) throws SQLException {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
		System.out.println(jdbc.getConnection());
	}
	
	public boolean update(Employee emp){
		/*MapSqlParameterSource params= new MapSqlParameterSource();
		params.addValue("id", id);
		return jdbc.update("update employee set name='Akshit'where id= :id",params)==1;*/
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(emp);
		return jdbc.update("update employee set name=:name,text=:text,email=:email where id =:id", params)==1;
		
	}
	
	public boolean create(Employee emp){
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(emp);
		
		
		return jdbc.update("insert into employee(name,email,text)values(:name,:email,:text)", params)==1;
	}

	
	public int[] batchUpdate(List<Employee> emp){
		
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(emp.toArray());
		return jdbc.batchUpdate("insert into employee(name,email,text)values(:name,:email,:text)", params);
	}
}
