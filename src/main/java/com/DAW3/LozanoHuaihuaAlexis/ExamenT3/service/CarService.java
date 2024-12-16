package com.DAW3.LozanoHuaihuaAlexis.ExamenT3.service;

import com.DAW3.LozanoHuaihuaAlexis.ExamenT3.dto.CarDTO;
import com.DAW3.LozanoHuaihuaAlexis.ExamenT3.entity.Car;
import com.DAW3.LozanoHuaihuaAlexis.ExamenT3.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {


    @Autowired
    private CarRepository carRepository;

    public List<CarDTO> getAllCar(){
       List<Car> cars = carRepository.findAll();
       List<CarDTO> carDTOS = cars.stream().map(car -> new CarDTO(
               car.getCarId(),car.getMake(),car.getModel(),car.getYear(),car.getVin(),car.getLicensePlate(),car.getOwnerName(),car.getOwnerContact(),
               car.getPurchaseDate(),car.getMileage(),car.getEngineType(),car.getColor(),car.getInsuranceCompany()
               ,car.getInsurancePolicyNumber(),car.getRegistrationExpirationDate(), car.getServiceDueDate()))
               .collect(Collectors.toList());
       return carDTOS;
}

    public CarDTO getCarDetails(int id){
         Car car = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car no encontrando"));
         return new CarDTO(car.getCarId(),car.getMake(),car.getModel(),car.getYear(),car.getVin(),car.getLicensePlate(),car.getOwnerName(),car.getOwnerContact(),
                 car.getPurchaseDate(),car.getMileage(),car.getEngineType(),car.getColor(),car.getInsuranceCompany()
                 ,car.getInsurancePolicyNumber(),car.getRegistrationExpirationDate(),car.getServiceDueDate());
    }
    public Car updateCar(int id, Car carDetails){
       Car car = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car no encontrado"));
       carDetails.setCarId(id);
       return carRepository.save(carDetails);
    }
    public void deleteCar(int id) {
         carRepository.deleteById(id);
    }

     public Car createCar(Car car){
         return carRepository.save(car);
     }

}
