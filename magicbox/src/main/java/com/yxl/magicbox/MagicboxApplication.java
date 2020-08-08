package com.yxl.magicbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//去除数据源配置
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class MagicboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(MagicboxApplication.class, args);
	}

}
