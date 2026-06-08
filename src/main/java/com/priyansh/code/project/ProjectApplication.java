package com.priyansh.code.project;

import ch.qos.logback.core.subst.NodeToStringTransformer;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class ProjectApplication implements CommandLineRunner {


	final NotificationService notificationService;

	public ProjectApplication(NotificationService notificationService){
		this.notificationService = notificationService;
	}

//	What if i want to send notification to all the beans of notification service.
	@Autowired
	Map<String,NotificationService> map = new HashMap<>();


	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ProjectApplication.class, args);
		context.close();
	}


	@Override
	public void run(String... args) throws Exception{
		notificationService.send();
		System.out.println("send....");

		for(var ele:map.entrySet()){
			String b_name = ele.getKey();
			NotificationService val = ele.getValue();
			System.out.println(b_name);
			val.send();

		}

	}

}
