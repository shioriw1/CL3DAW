package com.DAW3.LozanoHuaihuaAlexis.ExamenT3.repository;

import com.DAW3.LozanoHuaihuaAlexis.ExamenT3.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
}
