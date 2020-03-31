package com.example.chefhome.main;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增主键
    private Integer id;

    @Column(name = "address")
    private String address;

    @Column(name = "preparefood")
    private String preparefood;

    @Column(name = "orderstat")
    private String orderstat;

    @Column(name = "datetime")
    private String datetime;

    @Column(name = "message")
    private String message;

    @Column(name = "packages")
    private String packages;

    @Column(name = "money")
    private String money;

    @Column(name = "number")
    private String number;

    @Column(name = "source")
    private String source;

    @Column(name = "chefname")
    private String chefname;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<UserOrder> userOrders = new HashSet<UserOrder>();

    public Set<UserOrder> getUserOrders() {
        return userOrders;
    }

    public void setUserOrders(Set<UserOrder> userOrders) {
        this.userOrders = userOrders;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPreparefood() {
        return preparefood;
    }

    public void setPreparefood(String preparefood) {
        this.preparefood = preparefood;
    }

    public String getOrderstat() {
        return orderstat;
    }

    public void setOrderstat(String orderstat) {
        this.orderstat = orderstat;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPackages() {
        return packages;
    }

    public void setPackages(String packages) {
        this.packages = packages;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getChefname() {
        return chefname;
    }

    public void setChefname(String chefname) {
        this.chefname = chefname;
    }
}
