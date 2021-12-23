package com.example.restapitestbyspock.infrastructure.repository;

import com.example.restapitestbyspock.infrastructure.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarJpaRepository extends JpaRepository<CarEntity, Integer> {
    List<CarEntity> findByPriceLessThanEqualOrderByPriceAsc(Integer price);
}
