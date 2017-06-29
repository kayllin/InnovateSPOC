package com.base.Po;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class students {

	@Id
	private int sid;//学生id
	private String sname;//学生姓名
	private String student_introduce;//自我介绍
	private String sex;//性别
	private String headshot;//头像（地址）
	private String chinese_address;//中文居住地址
	private String english_address;//英文居住地址
	private int phone;//联系电话
	private int qq;//qq号
	private int school_year;//入学年份
	private String major;//专业
	private int graduation;//是否毕业
	private int employed;//是否应聘
	
	public students() {
		super();
		// TODO Auto-generated constructor stub
	}

	public students(int sid, String sname, String student_introduce,
			String sex, String headshot, String chinese_address,
			String english_address, int phone, int qq, int school_year,
			String major, int graduation, int employed) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.student_introduce = student_introduce;
		this.sex = sex;
		this.headshot = headshot;
		this.chinese_address = chinese_address;
		this.english_address = english_address;
		this.phone = phone;
		this.qq = qq;
		this.school_year = school_year;
		this.major = major;
		this.graduation = graduation;
		this.employed = employed;
	}
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getStudent_introduce() {
		return student_introduce;
	}
	public void setStudent_introduce(String student_introduce) {
		this.student_introduce = student_introduce;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getHeadshot() {
		return headshot;
	}
	public void setHeadshot(String headshot) {
		this.headshot = headshot;
	}
	public String getChinese_address() {
		return chinese_address;
	}
	public void setChinese_address(String chinese_address) {
		this.chinese_address = chinese_address;
	}
	public String getEnglish_address() {
		return english_address;
	}
	public void setEnglish_address(String english_address) {
		this.english_address = english_address;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getQq() {
		return qq;
	}
	public void setQq(int qq) {
		this.qq = qq;
	}
	public int getSchool_year() {
		return school_year;
	}
	public void setSchool_year(int school_year) {
		this.school_year = school_year;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getGraduation() {
		return graduation;
	}
	public void setGraduation(int graduation) {
		this.graduation = graduation;
	}
	public int getEmployed() {
		return employed;
	}
	public void setEmployed(int employed) {
		this.employed = employed;
	}
	
	
	
}
