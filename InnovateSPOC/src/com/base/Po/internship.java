package com.base.Po;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class internship {

	@Id
	private int id;// ʵϰ�����id
	private String sid;// ѧ��id
	private String practice_location;// �ص�
	private String begin_time;// ��ʼʱ��
	private String end_time;// ����ʱ��
	private String practice_description;// ʵϰ����
	private String sname;

	public internship() {
		super();
		// TODO Auto-generated constructor stub
	}

	public internship(int id, String sid, String practice_location,
			String begin_time, String end_time, String practice_description,
			String sname) {
		super();
		this.id = id;
		this.sid = sid;
		this.practice_location = practice_location;
		this.begin_time = begin_time;
		this.end_time = end_time;
		this.practice_description = practice_description;
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

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}


	
}
