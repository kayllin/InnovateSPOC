/**
 * 
 */
package com.base.Po;

import java.util.List;


/**
 * @author 鸡毛大大
 *
 */
public class employList {
	  private int recordsTotal;
	  private List<employment> data;
	  
	  
	  
	public employList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public employList(int recordsTotal, List<employment> data) {
		super();
		this.recordsTotal = recordsTotal;
		this.data = data;
	}

	public int getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	public List<employment> getData() {
		return data;
	}
	public void setData(List<employment> data) {
		this.data = data;
	}
	  
	  
	  
	  
}
