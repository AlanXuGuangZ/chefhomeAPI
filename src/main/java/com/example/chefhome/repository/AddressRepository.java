package com.example.chefhome.repository;

import com.example.chefhome.main.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Integer> {

    public List<Address> findByuid(String uid);
}
