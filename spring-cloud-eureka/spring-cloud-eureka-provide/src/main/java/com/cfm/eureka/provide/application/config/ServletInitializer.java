package com.cfm.eureka.provide.application.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.cfm.eureka.provide.application.ProvideClientApplication;


/**
 * 
* @Title:  ServletInitializer.java   
* @Package： com.cfm.application.config   
* @Description: TODO(将工程加入到tomcat中运行时的初始化类)   
*
* @version: v1.0.0
* @author: Chen WeiYu
* @date: 2019年12月4日 下午8:34:14
 */
@ComponentScan(basePackages="com.cfm.application.config")
@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class})
@EnableEurekaClient
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        //指向使用内嵌tomcat的启动类的main方法执行的Application启动类
        return builder.sources(ProvideClientApplication.class);
    }
}