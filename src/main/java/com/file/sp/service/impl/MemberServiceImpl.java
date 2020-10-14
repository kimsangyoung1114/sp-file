package com.file.sp.service.impl;

import java.io.File;
import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.file.sp.dao.MemberDAO;
import com.file.sp.service.MemberService;
import com.file.sp.vo.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;
	private String savePath = "C:\\java_study\\workspace\\sp-file\\src\\main\\webapp\\resources\\";
		
	@Override
	@Transactional
	public int insertMember(MemberVO member) {
		MultipartFile mf = member.getFile1();
		File f = null;
		if(mf!=null) {
			String extName = mf.getOriginalFilename();
			extName = extName.substring(extName.lastIndexOf("."));
			String fileName = savePath + System.nanoTime()+extName;
			try {
				f = new File(fileName);
				mf.transferTo(f);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		int result = memberDAO.insertMember(member);
		memberDAO.insertMember(member);
		if(result!=1 && f!=null) {
			f.delete();
		}
		return result;
	}

	@Override
	public String test() {
		// TODO Auto-generated method stub
		return "나 서비스 어노테이션 안썼음";
	}

}
