package com.file.sp.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import com.file.sp.dao.MemberDAO;
import com.file.sp.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SqlSessionFactory sessionFactory;
	
	@Override
	public int insertMember(MemberVO member) {
		try(SqlSession ss = sessionFactory.openSession()){
			return ss.insert("Member.insertMember",member);
		}
	}
}
