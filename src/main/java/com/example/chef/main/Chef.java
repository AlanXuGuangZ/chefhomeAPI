package com.example.chef.main;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 创建厨师表
 * created by tony on 2020/3/26 00:25
 */
@Entity
public class Chef {
    @Id
    @GeneratedValue
    private String name;
    private String good;
    private Integer star;
    private String money;
    private String introduce;
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
