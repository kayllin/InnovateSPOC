package com.base.Po;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class employment {

	@Id
	private int id;//就业表id
	private int sid;//学生sid
	private String company;//所在公司
	private int salary;//年薪
	private String workin;//从事工作
	private int graduation_year;//毕业年份
	private int excellence;//是否优秀
	
	public employment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public employment(int id, int sid, String company, int salary,
			String workin, int graduation_year, int excellence) {
		super();
		this.id = id;
		this.sid = sid;
		this.company = company;
		this.salary = salary;
		this.workin = workin;
		this.graduation_year = graduation_year;
		this.excellence = excellence;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getWorkin() {
		return workin;
	}
	public void setWorkin(String workin) {
		this.workin = workin;
	}
	public int getGraduation_year() {
		return graduation_year;
	}
	public void setGraduation_year(int graduation_year) {
		this.graduation_year = graduation_year;
	}
	public int getExcellence() {
		return excellence;
	}
	public void setExcellence(int excellence) {
		this.excellence = excellence;
	}
	
	
}
