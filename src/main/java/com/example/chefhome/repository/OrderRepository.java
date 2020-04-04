package com.example.chefhome.repository;

import com.example.chefhome.main.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {

    public List<Order> findByuid(String uid);
}
