package com.springEco.Spring.Ecosystem;

import com.springEco.Spring.Ecosystem.Bean.Cat;
import com.springEco.Spring.Ecosystem.Bean.ColorFull_parrot;
import com.springEco.Spring.Ecosystem.Bean.Parrot;
import com.springEco.Spring.Ecosystem.Config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
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

		ArrayList<ColorFull_parrot> parrots = getColorFullParrots();

		for(ColorFull_parrot c: parrots){
			if(c.getColor().equals("green")){
				Supplier<ColorFull_parrot>supplier=()->c;
				contex.registerBean(c.getName(), ColorFull_parrot.class,supplier);
				System.out.println("added");
			}
		}


	}

	private static ArrayList<ColorFull_parrot> getColorFullParrots() {
		ArrayList<ColorFull_parrot>parrots=new ArrayList<>();

		ColorFull_parrot colorFull_parrot1= new ColorFull_parrot("parrotbek","green");
		ColorFull_parrot colorFull_parrot2= new ColorFull_parrot("parrotbek-2","red");
		ColorFull_parrot colorFull_parrot3= new ColorFull_parrot("parrotbek-3","yellow");
		ColorFull_parrot colorFull_parrot4= new ColorFull_parrot("parrotbek-4","green");

		parrots.add(colorFull_parrot1);
		parrots.add(colorFull_parrot2);
		parrots.add(colorFull_parrot3);
		parrots.add(colorFull_parrot4);
		return parrots;
	}


}
