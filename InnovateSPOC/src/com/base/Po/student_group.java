package com.base.Po;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class student_group {

	@Id
	private int id;//学生组别表编号
	private int sid;//学生id
	private int gid;//组别gid
	public student_group() {
		super();
		// TODO Auto-generated constructor stub
	}
	public student_group(int id, int sid, int gid) {
		super();
		this.id = id;
		this.sid = sid;
		this.gid = gid;
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
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	
	
}
