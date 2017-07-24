package com.base.Po;

import java.util.List;

public class studentList {

	private List<students> data;
    private int recordsTotal;
	public studentList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public studentList(List<students> data, int recordsTotal) {
		super();
		this.data = data;
		this.recordsTotal = recordsTotal;
	}
	public List<students> getData() {
		return data;
	}
	public void setData(List<students> data) {
		this.data = data;
	}
	public int getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	
    
    
}
