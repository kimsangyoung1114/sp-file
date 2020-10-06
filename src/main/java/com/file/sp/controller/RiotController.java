package com.file.sp.controller;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.file.sp.service.RiotService;

@RestController
public class RiotController {
	@Autowired
	RiotService rs ;

	@GetMapping("/riot/{name}")
	public Map<String,Object> getLevel(@PathVariable("name")String name){
		return rs.getLevelInfo(name);
	}
}
