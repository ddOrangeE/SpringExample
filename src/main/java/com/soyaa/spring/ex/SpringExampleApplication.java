package com.soyaa.spring.ex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
// 데이터 베이스 설정을 나중으로 미룰게
// 데이터 베이스를 설정하지 않았기 때문에 이걸로 일단 대신
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class SpringExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringExampleApplication.class, args);
	}

}
