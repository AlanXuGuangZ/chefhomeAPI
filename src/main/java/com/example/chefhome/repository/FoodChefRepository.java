package com.example.chefhome.repository;

import com.example.chefhome.main.FoodChef;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodChefRepository extends JpaRepository<FoodChef,Integer> {
    List<FoodChef> findByCid(Integer cid);
    List<FoodChef> findByFid(Integer fid);
}
