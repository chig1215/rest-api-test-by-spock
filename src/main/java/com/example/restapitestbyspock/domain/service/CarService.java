package com.example.restapitestbyspock.domain.service;

import com.example.restapitestbyspock.domain.model.Car;
import com.example.restapitestbyspock.domain.repository.CarRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    @NonNull
    private final CarRepository carRepository;

    public List<Car> findByPriceLessThanEqualOrderByPriceAsc(Integer price) {
        return this.carRepository.findByPriceLessThanEqualOrderByPriceAsc(price);
    }

}
