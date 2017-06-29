package com.base.Po;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class education_experience {

	@Id
	private int id;// 教育经历表id
	private int sid;// 学生id
	private String school;// 学校
	private String begin_time;// 开始时间
	private String end_time;// 结束时间
	private String education_description;// 教育内容

	public education_experience() {
		super();
		// TODO Auto-generated constructor stub
	}

	public education_experience(int id, int sid, String school,
			String begin_time, String end_time, String education_description) {
		super();
		this.id = id;
		this.sid = sid;
		this.school = school;
		this.begin_time = begin_time;
		this.end_time = end_time;
		this.education_description = education_description;
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

}
