package com.example.frealsb.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String city;
    private String province;
    private String features;
    private Date timestamp;
    private Date deleteAt;
}
