package com.example.chefhome.main;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 创建厨师表
 * created by tony on 2020/3/26 00:25
 */
@Entity
@Table(name = "chef")
public class Chef {
    @Id //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增主键
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "good")
    private String good;
    @Column(name = "star")
    private Integer star;
    @Column(name = "money")
    private String money;
    @Column(name = "introduce")
    private String introduce;
    @Column(name = "pick")
    private Integer pick;
    public Chef(){}


//    private Set<Food> foods = new HashSet<Food>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getGood() {
        return good;
    }

    public void setGood(String good) {
        this.good = good;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Integer getPick() {
        return pick;
    }

    public void setPick(Integer pick) {
        this.pick = pick;
    }
}
