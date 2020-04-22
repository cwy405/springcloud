/**
 * 
 */
package com.cfm.eureka.client.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**   
* @Title:  RestTemplateConfig.java   
* @Package： com.cfm.eureka.client.config   
* @Description: TODO(RestTemplate配置，注入RestTemplate)   
*
* @version: v1.0.0
* @author: Chen WeiYu
* @date: 2020年1月8日 下午7:54:56 
*/
@Configuration
public class RestTemplateConfig {

	@Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
}
