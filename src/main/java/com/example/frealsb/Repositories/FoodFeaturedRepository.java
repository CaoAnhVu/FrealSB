package com.example.frealsb.Repositories;

import com.example.frealsb.Entities.FoodFeatured;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodFeaturedRepository extends JpaRepository<FoodFeatured, String> {
}
