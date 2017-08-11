package com.base.Po;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class student_group {

	@Id
	private int id;//ѧ��������
	private String sid;//ѧ��id
	private int gid;//���gid
	private String sname;
	private String gname;
	public student_group() {
		super();
		// TODO Auto-generated constructor stub
	}
	public student_group( String sid, int gid,String sname,String gname) {
		super();
		this.sid = sid;
		this.gid = gid;
		this.sname=sname;
		this.gname=gname;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getSname(){
		return sname;
	}
	public void setSname(String sname){
		this.sname=sname;
	}
	public String getGname(){
		return gname;
	}
	public void setGname(String gname){
		this.gname=gname;
	}
	
}
