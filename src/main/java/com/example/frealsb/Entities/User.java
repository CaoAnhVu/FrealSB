package com.example.frealsb.Entities;
import com.example.frealsb.Interface.JpaEntities;
import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class User extends JpaEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.util.Date createAt;
    @Column(nullable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.util.Date updateAt;
    @Column(nullable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deletedAt;

    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = true)
    private String avatarPublicId;
    @Column(nullable = true)
    private String location;
    @Column(nullable = true)
    private String bio;

}
