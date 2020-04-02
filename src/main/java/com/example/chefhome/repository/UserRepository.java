package com.example.chefhome.repository;

import com.example.chefhome.main.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    public User findByPhoneNum(String phoneNum);
}
