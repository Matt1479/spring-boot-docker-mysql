package com.matt1479.springbootdockermysql;

import org.springframework.boot.SpringApplication;

public class TestSpringBootDockerMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.from(SpringBootDockerMysqlApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
