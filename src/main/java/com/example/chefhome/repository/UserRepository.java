package com.example.chefhome.repository;

import com.example.chefhome.main.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByphonenum(String phoneNum);
}
