package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
@MapperScan("com.example.demo.mapper")
public class DemoApplication {

	@Resource
	Test test;

	public static int concurrency = 100;
	public static int repeat = 100000;
	public static boolean testUpdate = false;
	public static void main(String[] args) {
		testUpdate = "update".equalsIgnoreCase(args[0]);
		concurrency = Integer.parseInt(args[1]);
		repeat = Integer.parseInt(args[2]);
		SpringApplication.run(DemoApplication.class, args);
	}
}
