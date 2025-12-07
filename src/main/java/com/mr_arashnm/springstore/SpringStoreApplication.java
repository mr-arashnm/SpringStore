package com.mr_arashnm.springstore;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringStoreApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringStoreApplication.class, args);
        var userService = context.getBean(UserService.class);
        userService.registerUser(new User(1, "mosh.1@gmail.com", "sdASD","dasd"));
    }
}
