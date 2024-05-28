package com.example.frealsb.Repositories;

import com.example.frealsb.Entities.CultureCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CultureCategoryRepository extends JpaRepository<CultureCategory, String> {
}
