package com.base.Po;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class internship {

	@Id
	private int id;// 实习经历表id
	private int sid;// 学生id
	private String practice_location;// 地点
	private String begin_time;// 开始时间
	private String end_time;// 结束时间
	private String practice_description;// 实习内容

	public internship() {
		super();
		// TODO Auto-generated constructor stub
	}

	public internship(int id, int sid, String practice_location,
			String begin_time, String end_time, String practice_description) {
		super();
		this.id = id;
		this.sid = sid;
		this.practice_location = practice_location;
		this.begin_time = begin_time;
		this.end_time = end_time;
		this.practice_description = practice_description;
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

	public String getPractice_location() {
		return practice_location;
	}

	public void setPractice_location(String practice_location) {
		this.practice_location = practice_location;
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

	public String getPractice_description() {
		return practice_description;
	}

	public void setPractice_description(String practice_description) {
		this.practice_description = practice_description;
	}
	
	
}
