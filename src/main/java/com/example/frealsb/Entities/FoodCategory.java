package com.example.frealsb.Entities;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class FoodCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String title;
}
