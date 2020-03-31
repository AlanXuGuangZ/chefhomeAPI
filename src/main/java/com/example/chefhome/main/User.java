package com.example.chefhome.main;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增主键
    private Integer id;

    @Column(name = "phonenum")
    private String phonenum;

    @JsonIgnore
    @OneToMany(mappedBy = "ouser",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<UserOrder> userOrders = new HashSet<UserOrder>();

    public Set<UserOrder> getUserOrders() {
        return userOrders;
    }

    public void setUserOrders(Set<UserOrder> userOrders) {
        this.userOrders = userOrders;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "auser",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<UserAddress> userAddresses = new HashSet<UserAddress>();

    public Set<UserAddress> getUserAddresses() {
        return userAddresses;
    }

    public void setUserAddresses(Set<UserAddress> userAddresses) {
        this.userAddresses = userAddresses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }
}
