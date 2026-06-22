package com.springEco.Spring.Ecosystem;

import com.springEco.Spring.Ecosystem.Bean.Cat;
import com.springEco.Spring.Ecosystem.Bean.Parrot;
import com.springEco.Spring.Ecosystem.Config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Primary;

import java.util.function.Supplier;

@SpringBootApplication
public class SpringEcosystemApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringEcosystemApplication.class, args);

		var contex= new AnnotationConfigApplicationContext(Config.class);
		var parrot=contex.getBean(Parrot.class);
		var cat=contex.getBean(Cat.class);
		System.out.println(parrot.getName());
		System.out.println(cat.getName());



		Parrot parrot_green1=new Parrot();
		parrot_green1.setName("parrot-green-1");

		Supplier<Parrot>parrotSupplier= ()-> parrot_green1;

		contex.registerBean("parrot_green1",Parrot.class,parrotSupplier);

		var parrotGreen=contex.getBean("parrot_green1",Parrot.class);
		System.out.println(parrotGreen.getName());



	}




}
