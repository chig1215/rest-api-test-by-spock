package com.example.restapitestbyspock.domain.repository;

import com.example.restapitestbyspock.domain.model.Car;

import java.util.List;

public interface CarRepository {

    List<Car> findByPriceLessThanEqualOrderByPriceAsc(Integer price);

}
