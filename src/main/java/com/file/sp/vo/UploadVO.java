package com.file.sp.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UploadVO {
	private String writer;
	private MultipartFile file1;
}
