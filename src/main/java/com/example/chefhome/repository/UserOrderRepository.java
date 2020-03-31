package com.example.chefhome.repository;

import com.example.chefhome.main.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserOrderRepository extends JpaRepository<UserOrder,Integer> {
}
