package com.base.Po;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class skills {

	@Id
	private int kid;//技能id
	private String skill_name;//技能名称
	private String skill_address;//技能图片地址
	
	public skills() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public skills(int kid, String skill_name, String skill_address) {
		super();
		this.kid = kid;
		this.skill_name = skill_name;
		this.skill_address = skill_address;
	}
	public int getKid() {
		return kid;
	}
	public void setKid(int kid) {
		this.kid = kid;
	}
	public String getSkill_name() {
		return skill_name;
	}
	public void setSkill_name(String skill_name) {
		this.skill_name = skill_name;
	}
	public String getSkill_address() {
		return skill_address;
	}
	public void setSkill_address(String skill_address) {
		this.skill_address = skill_address;
	}
	
	
}
