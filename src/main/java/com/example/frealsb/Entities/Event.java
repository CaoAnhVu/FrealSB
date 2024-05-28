package com.example.frealsb.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = true)
    private String title;
    @Column(nullable = true)
    private Date timeStart;
    @Column(nullable = true)
    private Date timeEnd;
    @Column(nullable = true)
    private String status;
    @Column(nullable = true)
    private String cultureId;
    @Column(nullable = true)
    private String location;
    @Column(nullable = true)
    private String contactNumber;
    @Column(nullable = true)
    private String openingHours;
    @Column(nullable = true)
    private String mapAddress;
    @Column(nullable = true)
    private double ticketPrice;
}
