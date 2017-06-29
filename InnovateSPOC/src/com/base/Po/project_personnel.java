package com.base.Po;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class project_personnel {

	@Id
	private int id;//项目人员表id
	private int pid;//项目作品id
	private String participants;//参与人员
	private int header;//是否负责人
	
	public project_personnel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public project_personnel(int id, int pid, String participants, int header) {
		super();
		this.id = id;
		this.pid = pid;
		this.participants = participants;
		this.header = header;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getParticipants() {
		return participants;
	}
	public void setParticipants(String participants) {
		this.participants = participants;
	}
	public int getHeader() {
		return header;
	}
	public void setHeader(int header) {
		this.header = header;
	}
	
	
}
