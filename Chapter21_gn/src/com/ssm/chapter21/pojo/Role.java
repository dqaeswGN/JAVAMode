package com.ssm.chapter21.pojo;

import java.io.Serializable;

public class Role implements Serializable{
	
	private static final long serialVersionUID = 5827347228856707172L;
	
	private Long id;
	private String roleName;
	public Long getId() {
		
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	

}
