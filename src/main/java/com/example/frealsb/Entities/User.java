package com.example.frealsb.Entities;
import com.example.frealsb.Enums.EnumRole;
import com.example.frealsb.Interface.JpaEntities;
import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
public class User extends JpaEntities {

    public interface CreateValidationGroup {}
    public interface ChangeEmailValidationGroup {}
    public interface ChangePasswordValidationGroup {}
    public interface ProfileInfoValidationGroup {}

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    // -- Timestamp --
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deletedAt;
    // -- End timestamp --

    // -- Variable --

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, length = 80)
    @Size.List({
            @Size(min = 6, message = "Password too short", groups = {CreateValidationGroup.class, ChangePasswordValidationGroup.class}),
            @Size(max = 80, message = "Password too long", groups = {CreateValidationGroup.class, ChangePasswordValidationGroup.class})
    })
    @NotBlank(groups = {CreateValidationGroup.class, ChangePasswordValidationGroup.class})
    private String password;

    @Column(unique = true, nullable = false, length = 50)
    @Email(groups = {CreateValidationGroup.class, ChangeEmailValidationGroup.class})
    @NotBlank(groups = {CreateValidationGroup.class, ChangeEmailValidationGroup.class})
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = true)
    private boolean enabled;

    @Column(nullable = true)
    private String avatarPublicId;

    @Column(nullable = true)
    private String location;

    @Column(nullable = true, length = 1000)
    @Size(max = 1000, groups = {ProfileInfoValidationGroup.class})
    private String bio;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

//  Function
    public boolean hasRole(EnumRole enumRole) {
        if (this.role == null) {
            return false;
        }
        return this.role.getRoleName() == enumRole;
    }
}
