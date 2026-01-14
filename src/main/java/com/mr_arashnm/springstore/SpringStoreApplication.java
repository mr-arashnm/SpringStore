package com.mr_arashnm.springstore;

import com.mr_arashnm.springstore.entities.User;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringStoreApplication {

	public static void main(String[] args) {
//		ApplicationContext context = SpringApplication.run(SpringStoreApplication.class, args);
        var user = new User(1l, "name", "email", "password");
        user.setName("john");
        user.setEmail("Wdsc ed@gmail.com");
        user.setPassword("password");


    }
}
