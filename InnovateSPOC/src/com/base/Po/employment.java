package com.base.Po;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class employment {

	@Id
	private int id;//��ҵ��id
	private String sid;//ѧ��
	private String company;//���ڹ�˾
	private String salary;//��н
	private String workin;//���¹���
	private String graduation_year;//��ҵ���
	private String excellence;//�Ƿ�����
	
	public employment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public employment(int id, String sid, String company, String salary,
			String workin, String graduation_year, String excellence) {
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
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getWorkin() {
		return workin;
	}
	public void setWorkin(String workin) {
		this.workin = workin;
	}
	public String getGraduation_year() {
		return graduation_year;
	}
	public void setGraduation_year(String graduation_year) {
		this.graduation_year = graduation_year;
	}
	public String getExcellence() {
		return excellence;
	}
	public void setExcellence(String excellence) {
		this.excellence = excellence;
	}
	
	
}
