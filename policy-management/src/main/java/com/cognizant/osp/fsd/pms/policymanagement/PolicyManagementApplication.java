package com.cognizant.osp.fsd.pms.policymanagement;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages="com.cognizant.osp.fsd.pms.policymanagement.entity")
@ComponentScan(basePackages="com.cognizant.osp.fsd.pms.policymanagement")

public class PolicyManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolicyManagementApplication.class, args);
	}
	
	@Bean

    ServletRegistrationBean h2servletRegistration(){

        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());

        registrationBean.addUrlMappings("/console/*");

        return registrationBean;

    }
}
