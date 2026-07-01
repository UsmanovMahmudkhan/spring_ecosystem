package com.WebScopes.SpringWebScope;

import com.WebScopes.SpringWebScope.RequestScope.Config;
import com.WebScopes.SpringWebScope.RequestScope.SearchRequestData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringWebScopeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebScopeApplication.class, args);

	}

}
