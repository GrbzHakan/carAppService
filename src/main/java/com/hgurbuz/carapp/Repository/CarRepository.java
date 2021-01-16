package com.hgurbuz.carapp.Repository;

import com.hgurbuz.carapp.Entity.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car,Long> {
}
