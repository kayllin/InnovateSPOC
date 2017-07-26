package com.base.Po;

import java.util.List;

public class internshipList {

	private List<internship> data;
    private int recordsTotal;
	public internshipList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public internshipList(List<internship> data, int recordsTotal) {
		super();
		this.data = data;
		this.recordsTotal = recordsTotal;
	}
	public List<internship> getData() {
		return data;
	}
	public void setData(List<internship> data) {
		this.data = data;
	}
	public int getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
    
    
}
