package com.learn.ssm.chapter3.mapper;

import java.util.List;

import com.learn.ssm.chapter3.pojo.Role;

public interface Rolemapper {
	public int insertRole(Role role);
	public int deleteRole(Role role);
	public int updateRole(Role role);
	public Role getRole(Long id);
	public List<Role> findRoles(String name);

}
