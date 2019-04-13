package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

//@EnableScheduling // 启用定时任务
@SpringBootApplication
@MapperScan("com.example.mapper")
@ComponentScan(value="com.thread")
@EnableCaching
public class SpringBootSampleHelloworldApplication {
	
	protected static Logger logger=LoggerFactory.getLogger(SpringBootSampleHelloworldApplication.class);
//直接在application.properties文件里添加 mybatis.mapperLocations=classpath:mapper/*.xml 改变等号后面的路径就能指定xml位置的
//	
//	@Bean
//    @ConfigurationProperties(prefix="spring.datasource")
//    public DataSource dataSource() {
//        return new org.apache.tomcat.jdbc.pool.DataSource();
//    }
//
//	@Bean
//    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
// 
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSource());
// 
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
// 
//        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));
// 
//        return sqlSessionFactoryBean.getObject();
//    }
//
//	@Bean
//    public PlatformTransactionManager transactionManager() {
//        return new DataSourceTransactionManager(dataSource());
//    }

	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSampleHelloworldApplication.class, args);
		logger.info("SpringBoot Start Success");

	}
}
