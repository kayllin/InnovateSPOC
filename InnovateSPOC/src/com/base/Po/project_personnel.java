package com.base.Po;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class project_personnel {

	@Id
	private int id;//��Ŀ��Ա��id
	private int sid;//学生id
	private int pid;//��Ŀ��Ʒid
	private String participants;//������Ա
	private int header;//�Ƿ�����
	
	public project_personnel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public project_personnel(int id, int sid, int pid, String participants,
			int header) {
		super();
		this.id = id;
		this.sid = sid;
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

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
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
