package com.base.Po;

import java.util.List;


public class teacherList {

	private List<teachers> data;
    private int recordsTotal;
	public teacherList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public teacherList(List<teachers> data, int recordsTotal) {
		super();
		this.data = data;
		this.recordsTotal = recordsTotal;
	}
	public List<teachers> getData() {
		return data;
	}
	public void setData(List<teachers> data) {
		this.data = data;
	}
	public int getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
    
    
}
