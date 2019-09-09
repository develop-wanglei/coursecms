package com.newtechcollege.web.api;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement //事务注解
public class CourseWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseWebApplication.class, args);
    }
  
    /**
    * 文件上传配置
    * @return
    */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
       MultipartConfigFactory factory = new MultipartConfigFactory();
       //单个文件最大
       factory.setMaxFileSize("200MB"); //KB,MB
       /// 设置总上传数据总大小
       factory.setMaxRequestSize("200MB");
       return factory.createMultipartConfig();
    }

}
