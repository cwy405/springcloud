/**
 * 
 */
package com.cfm.eureka.client.test.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 
* @Title:  TestFeignService.java   
* @Package： com.cfm.eureka.client.test.service   
* @Description: TODO(feign用来调用eureka的注册服务，value的值为服务名称)   
*
* @version: v1.0.0
* @author: Chen WeiYu
* @date: 2020年1月8日 下午7:34:01
 */
@FeignClient(value="spring-cloud-eureka-provide",path="/test")
public interface TestFeignService {

	@RequestMapping("/getCode/{id}")
	String getCode(@RequestParam("id") String id);
	
	
	@RequestMapping("/getCode")
	String getCode();
	
	
	/**
	 * @param id
	 * @return
	 * @history 方法创建;Mender:chenweiyu; Date:2019年7月31日；
	 */
	/*@RequestMapping(value="/getCode/{id}",method=RequestMethod.GET)
	String getCode(@PathVariable("id") String id );*/

	
}
