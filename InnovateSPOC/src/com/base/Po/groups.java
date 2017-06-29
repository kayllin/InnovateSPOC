package com.base.Po;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class groups {

	@Id
	private int gid;//组别id
	private String gname;//组别名字
	
	public groups() {
		super();
		// TODO Auto-generated constructor stub
	}

	public groups(int gid, String gname) {
		super();
		this.gid = gid;
		this.gname = gname;
	}
	
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	
	
}
