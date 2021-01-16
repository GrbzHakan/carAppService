package com.hgurbuz.carapp;

import com.hgurbuz.carapp.Entity.Car;
import com.hgurbuz.carapp.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarDbApplication {
	@Autowired
	private CarRepository carRepository;

	public static void main(String[] args) {
		SpringApplication.run(CarDbApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(){
		return args -> {
			// Save demo data to db
			carRepository.save(new Car("Ford", "Mustang", "Red",
					"ADF-1121", 2017, 59000));
			carRepository.save(new Car("Nissan", "Leaf", "White",
					"SSJ-3002", 2014, 29000));
			carRepository.save(new Car("Toyota", "Prius", "Silver",
					"KKO-0212", 2018, 39000));
		};
	}

}
