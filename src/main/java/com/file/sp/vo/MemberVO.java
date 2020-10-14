package com.file.sp.vo;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
@Alias("member")
public class MemberVO {
	private Integer custno;
	private String custname;
	private String phone;
	private String address;
	private String joindate;
	private String filename;
	private String grade;
	private String city;
	private MultipartFile file1;
}
