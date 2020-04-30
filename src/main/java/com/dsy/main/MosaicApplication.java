package com.dsy.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@SpringBootApplication
@EnableAutoConfiguration
@MapperScan(basePackages = {"com.dsy.main.dao"})
@ServletComponentScan(basePackages = "com.dsy.main.filter")//所扫描的包路径必须包含该Filter
public class MosaicApplication {

	public static void main(String[] args) {
		SpringApplication.run(MosaicApplication.class, args);
	}

}
