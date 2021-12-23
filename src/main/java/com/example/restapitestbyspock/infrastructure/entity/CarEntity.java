package com.example.restapitestbyspock.infrastructure.entity;

import com.example.restapitestbyspock.domain.model.Car;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cars")
public class CarEntity {
    @Id
    private Integer id;
    private String name;
    private Integer price;

    public Car toDomainCar() {
        return Car.builder()
                .id(this.id)
                .name(this.name)
                .price(this.price)
                .build();
    }

}
