package com.app.brpm;

import com.app.brpm.service.RulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RuleEngineApplication {


	public static void main(String[] args) {
		SpringApplication.run(RuleEngineApplication.class, args);
	}
}
