package com.example.chefhome.main;


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
    private int phonenum;

    @OneToMany(mappedBy = "auser",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Address> addresses = new HashSet<Address>();

//    @OneToMany(mappedBy = "ouser",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    private Set<Order> orders = new HashSet<Order>();

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

//    public Set<Order> getOrders() {
//        return orders;
//    }
//
//    public void setOrders(Set<Order> orders) {
//        this.orders = orders;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(int phonenum) {
        this.phonenum = phonenum;
    }
}
