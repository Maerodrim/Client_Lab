package com.example.Client;

import com.example.Client.Service.BluerService;
import com.example.Client.rmi.Bluer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

@SpringBootApplication
public class ClientApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		/*Bluer service =*/ SpringApplication.run(ClientApplication.class, args);/*.getBean(Bluer.class);
		BluerService.setBluer(service);*/
	}
/*
	@Bean
	RmiProxyFactoryBean service() {
		RmiProxyFactoryBean rmiProxyFactory = new RmiProxyFactoryBean();
		rmiProxyFactory.setServiceUrl("rmi://localhost:1099/Blurring");
		rmiProxyFactory.setServiceInterface(Bluer.class);
		return rmiProxyFactory;
	}*/
}
