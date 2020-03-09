/**
 * 
 */
package com.cfm.eureka.client.test.service;

import org.springframework.stereotype.Component;

/**
 * 
* @Title:  SaleFeignFallBack.java   
* @Package： com.cfm.eureka.client.test.service   
* @Description: TODO(服务降级)   
*
* @version: v1.0.0
* @author: Chen WeiYu
* @date: 2020年1月8日 下午7:32:53
 */
@Component
public class SaleFeignFallBack implements SaleFeignService{

	/**
	 * @return
	 * @history 方法创建;Mender:chenweiyu; Date:2019年8月23日；
	 */
	@Override
	public String spike() {
		return "wait a minute";
	}




}
