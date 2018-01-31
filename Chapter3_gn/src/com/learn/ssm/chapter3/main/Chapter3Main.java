package com.learn.ssm.chapter3.main;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.learn.ssm.chapter3.mapper.Rolemapper;
import com.learn.ssm.chapter3.pojo.Role;
import com.learn.ssm.chapter3.util.SqlSessionFactoryUtils;



public class Chapter3Main {
	public static void main(String[] args) {
		testRoleMapper();		
	}
	
	
	private static void testRoleMapper() {
		Logger log = Logger.getLogger(Chapter3Main.class);
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			Rolemapper roleMapper = sqlSession.getMapper(Rolemapper.class);
			Role role = roleMapper.getRole(2L);
			log.info("----------------------------");
			log.info(role.toString());
			log.info("----------------------------");
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	//ע��SQL����
	private static void testRoleMapper2() {
		Logger log = Logger.getLogger(Chapter3Main.class);
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
//			Rolemapper2 roleMapper2 = sqlSession.getMapper(Rolemapper2.class);
//			Role role = roleMapper2.getRole(1L);
//			log.info(role.getRoleName());
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
}
