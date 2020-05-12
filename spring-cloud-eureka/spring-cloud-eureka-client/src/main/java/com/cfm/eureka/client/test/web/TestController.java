/**
 * 
 */
package com.cfm.eureka.client.test.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.cfm.eureka.client.test.service.SaleFeignService;
import com.cfm.eureka.client.test.service.TestFeignService;
import com.cfm.eureka.client.test.vo.ResultVo;

/**
 * 
* @Title:  TestController.java   
* @Package： com.cfm.eureka.client.test.web   
* @Description: TODO(用一句话描述该文件做什么)   
*
* @version: v1.0.0
* @author: Chen WeiYu
* @date: 2020年3月9日 上午11:39:15
 */
@Controller
@RequestMapping("/test")
public class TestController {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	RestTemplate tpl;
	
	@Autowired
	TestFeignService feignService;
	
	@Autowired
	SaleFeignService saleFeignService;
	
	@RequestMapping(value="/router/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String router(@PathVariable("id") String id) {
		logger.info("开始调用------------------------"+tpl);
		
		String json = tpl.getForObject("http://spring-cloud-eureka-provide/test/getCode/"+id, String.class);
		logger.info("调用结果-----------------------"+json);

		return json;
	}
	@RequestMapping(value="/feignTest/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String feignTest(@PathVariable("id") String id) {
		logger.info("开始调用feignTest------------------------id");
		
		String json = feignService.getCode(id);
		logger.info("调用结果-----------------------id"+json);
		
		return json;
	}
	@RequestMapping("/feignTest")
	@ResponseBody
	public String feignTest() {
		logger.info("开始调用feignTest------------------------");
		
		String json = feignService.getCode();
		logger.info("调用结果-----------------------"+json);
		
		return json;
	}
	@RequestMapping("/spike")
	@ResponseBody
	public String spike() {
		logger.info("开始调用spike------------------------");
		
		String json = saleFeignService.spike();
		logger.info("调用结果-----------------------"+json);
		
		return json;
	}
}
