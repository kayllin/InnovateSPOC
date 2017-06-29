package com.base.Po;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class news {

	@Id
	private int id;//新闻表
	private String title;//新闻标题
	private String photo;//新闻图片
	private String content;//新闻内容
	private String time;//发布时间
	
	public news() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public news(int id, String title, String photo, String content, String time) {
		super();
		this.id = id;
		this.title = title;
		this.photo = photo;
		this.content = content;
		this.time = time;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
