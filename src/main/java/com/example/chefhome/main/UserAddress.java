package com.example.chefhome.main;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(UserAddress.class)
@Table(name = "useraddress",uniqueConstraints = {@UniqueConstraint(columnNames={"userid","addressid"})})
public class UserAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "userid", nullable = false, insertable = false, updatable = false)
    private int userid;

    @Id
    @Column(name = "addressid", nullable = false, insertable = false, updatable = false)
    private int addressid;

    @JsonIgnore
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(targetEntity = User.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "userid",referencedColumnName = "id")
    private User auser;

    @JsonIgnore
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(targetEntity = Address.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "addressid",referencedColumnName = "id")
    private Address address;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getAddressid() {
        return addressid;
    }

    public void setAddressid(int addressid) {
        this.addressid = addressid;
    }

    public User getUser() {
        return auser;
    }

    public void setUser(User user) {
        this.auser = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
