package com.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component("employeeDao")
public class EmployeeDao {

	private JdbcTemplate jdbc;

	public JdbcTemplate getDataSource() {
		return jdbc;
	}
	public  EmployeeDao() {
		System.out.println("successfully loaded employee dao");
	}

	@Autowired
	public void setDataSource(DataSource jdbc) throws SQLException {
		this.jdbc = new JdbcTemplate(jdbc);
		System.out.println(jdbc.getConnection());
	}

	public List<Employee> employeesDetails() {
		return jdbc.query("select * from employee", new RowMapper<Employee>() {

			public Employee mapRow(ResultSet rs, int rownum) throws SQLException {
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setEmail(rs.getString("email"));
				emp.setText(rs.getString("text"));

				return emp;
			}
		});

	}

}
