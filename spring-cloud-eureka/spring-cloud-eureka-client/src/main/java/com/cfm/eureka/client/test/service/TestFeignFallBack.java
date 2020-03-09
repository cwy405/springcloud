/**
 * 
 */
package com.cfm.eureka.client.test.service;

import org.springframework.stereotype.Component;

/**
 * 
* @Title:  TestFeignFallBack.java   
* @Package： com.cfm.eureka.client.test.service   
* @Description: TODO(服务降级)   
*
* @version: v1.0.0
* @author: Chen WeiYu
* @date: 2020年1月8日 下午7:33:50
 */
@Component
public class TestFeignFallBack implements TestFeignService{


	/**
	 * @return
	 * @history 方法创建;Mender:chenweiyu; Date:2019年7月31日；
	 */
	@Override
	public String getCode(String id) {
		return "wati a minute";
	}

	/**
	 * @return
	 * @history 方法创建;Mender:chenweiyu; Date:2019年7月31日；
	 */
	@Override
	public String getCode() {
		return "wati a minute";
	}


}
