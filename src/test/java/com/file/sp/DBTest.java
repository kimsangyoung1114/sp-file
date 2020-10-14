package com.file.sp;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.file.sp.service.MemberService;
import com.file.sp.vo.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml")
public class DBTest {
	private static final Logger log = LoggerFactory.getLogger(DBTest.class);
	@Autowired
	private MemberService ms;
	
	@Test
	public void test() throws SQLException {
		MemberVO member = new MemberVO();
		int result = ms.insertMember(member);
		assertEquals(result, 1);
	}

}




