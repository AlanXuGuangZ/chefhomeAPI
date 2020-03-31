package com.example.chefhome.main;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(UserOrder.class)
@Table(name = "userorder",uniqueConstraints = {@UniqueConstraint(columnNames={"userid","orderid"})})
public class UserOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "userid", nullable = false, insertable = false, updatable = false)
    private int userid;

    @Id
    @Column(name = "orderid", nullable = false, insertable = false, updatable = false)
    private int orderid;

    @JsonIgnore
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(targetEntity = User.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "userid",referencedColumnName = "id")
    private User ouser;

    @JsonIgnore
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(targetEntity = Order.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "orderid",referencedColumnName = "id")
    private Order order;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public User getUser() {
        return ouser;
    }

    public void setUser(User user) {
        this.ouser = user;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
