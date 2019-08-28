package com.newtechcollege.coursecms.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
/**
 * 
 * 德鲁伊配置 
  * @return : null
 * @author wanglei
 * @date 2019/8/23 16:34
 */
@Configuration
public class Druid {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource getDataSource() {
        return new DruidDataSource();
    }
}
