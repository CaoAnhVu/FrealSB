package com.example.frealsb.Repositories;

import com.example.frealsb.Entities.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodCategoryRepository extends JpaRepository<FoodCategory, String> {
}
