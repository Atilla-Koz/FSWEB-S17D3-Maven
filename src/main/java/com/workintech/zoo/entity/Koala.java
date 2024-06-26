package com.workintech.zoo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Koala {
    private Long id;
    private String name;
    private Double weight;
    private Integer sleepHour;
    private String gender;
}
