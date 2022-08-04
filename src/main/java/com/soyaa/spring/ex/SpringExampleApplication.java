package com.soyaa.spring.ex;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@SpringBootApplication
//// 데이터 베이스 설정을 나중으로 미룰게
//// 데이터 베이스를 설정하지 않았기 때문에 이걸로 일단 대신
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

// 데이터 베이스 설정할 거니까 미룬다고 했던 거 지우고

// 내 패키지 이름 + 모든 거에 접근할 거니까 *
//@MapperScan(basePackages="com.soyaa.spring.ex.*")
public class SpringExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringExampleApplication.class, args);
	}
	
	// 정해진 메소드
	// 어떤 드라이버로 어떤 url 어떤 userId, password 로 어떤 패키지(?)를 이용할 건지?
//	@Bean
//	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
//		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//		sessionFactory.setDataSource(dataSource);
//		
//		// org.springframework.core.io.support.  import 해주기
//		Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*Mapper.xml");
//		sessionFactory.setMapperLocations(res);
//		
//		return sessionFactory.getObject();
//	}

}
