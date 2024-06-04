package com.example.frealsb.Repositories;

import com.example.frealsb.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    // You can define custom query methods here if needed
    @Query("select u from User u where u.email=?1")
    User findByEmail(String email);
}
