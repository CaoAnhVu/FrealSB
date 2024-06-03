package com.example.frealsb.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

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

    // -- Timestamp --
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.sql.Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.sql.Date updatedAt;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.sql.Date deletedAt;
    // -- End timestamp --

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
