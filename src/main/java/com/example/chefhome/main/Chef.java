package com.example.chefhome.main;

import javax.persistence.*;

/**
 * 创建厨师表
 * created by tony on 2020/3/26 00:25
 */
@Entity
@Table(name = "chef")
public class Chef {
    @Id
    @GeneratedValue
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

    public String getName() {
        return name;
    }
    public void setName() {
        this.name = name;
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
