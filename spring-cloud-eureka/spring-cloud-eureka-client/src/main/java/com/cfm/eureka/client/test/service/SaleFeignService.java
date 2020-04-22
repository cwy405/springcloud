/**
 * 
 */
package com.cfm.eureka.client.test.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 
* @Title:  SaleFeignService.java   
* @Package： com.cfm.eureka.client.test.service   
* @Description: TODO(feign用来调用eureka的注册服务，value的值为服务名称)   
*
* @version: v1.0.0
* @author: Chen WeiYu
* @date: 2020年1月8日 下午7:33:26
 */
/*@FeignClient(value="spring-cloud-eureka-provide",path="/sale")*/
public interface SaleFeignService {

	@RequestMapping("/spike")
	String spike();
	
	

	
}
