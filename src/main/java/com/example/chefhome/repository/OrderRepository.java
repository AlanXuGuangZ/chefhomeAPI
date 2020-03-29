package com.example.chefhome.repository;

import com.example.chefhome.main.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
