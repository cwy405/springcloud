package com.cfm.eureka.server.application.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.cfm.eureka.server.application.ServerStartApplication;


/**
 * 
 * <p>
 * 标题： 将工程加入到tomcat中运行时的初始化类
 * </p>
 * <p>
 * 描述： 将工程加入到tomcat中运行时的初始化类
 * </p>
 * <p>
 * CreateDate:2019年11月26日
 * </p>
 * @author cwy
 * @history 创建文档；Mender:cwy；Date:2019年11月26日；
 */
@ComponentScan(basePackages="com.cfm.application.config")
@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class})
@EnableEurekaServer
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        //指向使用内嵌tomcat的启动类的main方法执行的Application启动类
        return builder.sources(ServerStartApplication.class);
    }
}