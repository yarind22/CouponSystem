package com.jb.CouponSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CouponSystemApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(CouponSystemApplication.class, args);
		System.out.println("the container was loded");
		System.out.println("--------------------------------");
	}

}
