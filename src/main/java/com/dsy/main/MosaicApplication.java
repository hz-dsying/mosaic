package com.dsy.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages = {"com.dsy.main.dao"})
public class MosaicApplication {

	public static void main(String[] args) {
		SpringApplication.run(MosaicApplication.class, args);
	}

}
