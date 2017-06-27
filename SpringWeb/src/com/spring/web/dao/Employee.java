package com.spring.web.dao;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Employee {

	private int id;
	@Size(min = 5, max = 100, message = "Name must be between 5 and 100 characters")
	private String name;
	@NotNull(message="email cannot be null")
	private String email;
	@Size(min = 30, max = 100, message = "text must be between 35 and 100 characters")
	private String text;

	public Employee() {

	}

	public Employee(String name, String email, String text) {
		super();
		this.name = name;
		this.email = email;
		this.text = text;
	}

	public Employee(int id, String name, String email, String text) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", text=" + text + "]";
	}

}
