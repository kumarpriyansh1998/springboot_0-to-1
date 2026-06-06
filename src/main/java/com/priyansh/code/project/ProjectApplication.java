package com.priyansh.code.project;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ProjectApplication implements CommandLineRunner {
	@Autowired
	PaymentService paymentservice2;

	@Autowired
	PaymentService paymentservice1;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ProjectApplication.class, args);
		context.close();
	}


	@Override
	public void run(String... args) throws Exception{
		System.out.println(paymentservice1.hashCode());
		System.out.println(paymentservice2.hashCode());
		paymentservice1.pay();
		System.out.println(paymentservice1.val);

	}

}
