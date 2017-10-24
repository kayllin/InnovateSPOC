package com.base.Po;

import java.util.List;

public class educationList {

	private List<education_experience> data;
    private int recordsTotal;
	public educationList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public educationList(List<education_experience> data, int recordsTotal) {
		super();
		this.data = data;
		this.recordsTotal = recordsTotal;
	}
	public List<education_experience> getData() {
		return data;
	}
	public void setData(List<education_experience> data) {
		this.data = data;
	}
	public int getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
    
    
}
