package com.example.frealsb.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Blog {
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

    private String title;
    private String description;
    private String images;
    private String location;
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "blogs_tags",
            joinColumns = @JoinColumn(name = "blog_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
    @OrderBy("name ASC")
    private Collection<Tag> tags = new ArrayList<>();

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
}
