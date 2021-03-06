package com.base.Po;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class project_work {

	@Id
	private int pid;//项目作品表id
	private int gid;//所属组别id
	private String project_name;//项目名
	private String project_introduce;//项目作品介绍
	private String project_address;//项目地址
	private String photo_address;//项目截图（地址）
	private String wid;//作品类别
	private int expression;//表达方式（是否是视频或者是静帧图）
	private int best_work;//是否是优秀作品
	
	public project_work() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public project_work(int pid, int gid, String project_name,
			String project_introduce, String project_address,
			String photo_address, String wid, int expression, int best_work) {
		super();
		this.pid = pid;
		this.gid = gid;
		this.project_name = project_name;
		this.project_introduce = project_introduce;
		this.project_address = project_address;
		this.photo_address = photo_address;
		this.wid = wid;
		this.expression = expression;
		this.best_work = best_work;
	}
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getProject_introduce() {
		return project_introduce;
	}
	public void setProject_introduce(String project_introduce) {
		this.project_introduce = project_introduce;
	}
	public String getProject_address() {
		return project_address;
	}
	public void setProject_address(String project_address) {
		this.project_address = project_address;
	}
	public String getPhoto_address() {
		return photo_address;
	}
	public void setPhoto_address(String photo_address) {
		this.photo_address = photo_address;
	}
	public String getWid() {
		return wid;
	}
	public void setWid(String wid) {
		this.wid = wid;
	}
	public int getExpression() {
		return expression;
	}
	public void setExpression(int expression) {
		this.expression = expression;
	}
	public int getBest_work() {
		return best_work;
	}
	public void setBest_work(int best_work) {
		this.best_work = best_work;
	}
	
	
}
