package com.base.Po;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class work_category {

	@Id
	private int wid;//作品类别id
	private String work_name;//类别名
	
	public work_category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public work_category(int wid, String work_name) {
		super();
		this.wid = wid;
		this.work_name = work_name;
	}
	
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public String getWork_name() {
		return work_name;
	}
	public void setWork_name(String work_name) {
		this.work_name = work_name;
	}
	
	
}
