package com.hgurbuz.carapp;

import com.hgurbuz.carapp.Entity.Car;
import com.hgurbuz.carapp.Entity.Owner;
import com.hgurbuz.carapp.Repository.CarRepository;
import com.hgurbuz.carapp.Repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarDbApplication {
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private OwnerRepository ownerRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CarDbApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(){
		return args -> {

			Owner owner1 = new Owner("Hakan","Gurbuz");
			Owner owner2 = new Owner("Test","Mest");

			ownerRepository.save(owner1);
			ownerRepository.save(owner2);
			// Save demo data to db
			carRepository.save(new Car("Ford", "Mustang", "Red",
					"ADF-1121", 2017, 59000,owner1));
			carRepository.save(new Car("Nissan", "Leaf", "White",
					"SSJ-3002", 2014, 29000,owner2));
			carRepository.save(new Car("Toyota", "Prius", "Silver",
					"KKO-0212", 2018, 39000,owner1));
		};
	}

}
