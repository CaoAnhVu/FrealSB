package com.example.frealsb.Repositories;

import com.example.frealsb.Entities.Culture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CultureRepository extends JpaRepository<Culture, String> {
}
