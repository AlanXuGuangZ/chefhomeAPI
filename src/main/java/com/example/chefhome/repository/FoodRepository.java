package com.example.chefhome.repository;

import com.example.chefhome.main.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food,Integer> {
}
