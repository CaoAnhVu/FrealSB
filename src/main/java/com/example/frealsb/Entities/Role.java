package com.example.frealsb.Entities;

import com.example.frealsb.Enums.EnumRole;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true, nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private EnumRole roleName;

    @OneToMany(mappedBy = "role")
    private List<User> users;
}
