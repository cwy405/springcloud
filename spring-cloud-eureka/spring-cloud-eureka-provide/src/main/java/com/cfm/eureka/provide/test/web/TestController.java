package com.cfm.eureka.provide.test.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cfm.eureka.provide.test.vo.ResultVo;

/**
 * 
* @Title:  TestController.java   
* @Package： com.cfm.eureka.provide.test.web   
* @Description: TODO(testController)   
*
* @version: v1.0.0
* @author: Chen WeiYu
* @date: 2019年12月4日 下午8:35:34
 */
@Controller
@RequestMapping("/test")
public class TestController {
	
	
	@RequestMapping("/getCode")
	@ResponseBody
	public ResultVo getCode() {
		System.out.println("spring-cloud-eureka-provide:getCode--------->");
		Map<String,Object> map = new HashMap<>();
		map.put("id", "id");
		
		return ResultVo.ok(map);
	}
	@RequestMapping("/getCode/{id}")
	@ResponseBody
	public ResultVo getCode(@RequestParam("id") String id) {
		
		Map<String,Object> map = new HashMap<>();
		map.put("id", id);
		
		return ResultVo.ok(map);
	}
	
	@RequestMapping("/getTest")
	@ResponseBody
	public ResultVo test() {
		
		Map<String,Object> map = new HashMap<>();
		map.put("test", "test");
		
		return ResultVo.ok(map);
	}
}
