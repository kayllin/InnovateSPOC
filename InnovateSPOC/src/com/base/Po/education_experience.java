package com.base.Po;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class education_experience {

	@Id
	private int id;// �������id
	private String sid;// ѧ��id
	private String school;// ѧУ
	private String begin_time;// ��ʼʱ��
	private String end_time;// ����ʱ��
	private String education_description;// ��������
	private String sname;

	public education_experience() {
		super();
		// TODO Auto-generated constructor stub
	}

	public education_experience(int id, String sid, String school,
			String begin_time, String end_time, String education_description,
			String sname) {
		super();
		this.id = id;
		this.sid = sid;
		this.school = school;
		this.begin_time = begin_time;
		this.end_time = end_time;
		this.education_description = education_description;
		this.sname = sname;
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

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getBegin_time() {
		return begin_time;
	}

	public void setBegin_time(String begin_time) {
		this.begin_time = begin_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getEducation_description() {
		return education_description;
	}

	public void setEducation_description(String education_description) {
		this.education_description = education_description;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	
	

}
