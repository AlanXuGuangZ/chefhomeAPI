package com.example.chefhome.main;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "foodchef")
public class FoodChef {

    @Id //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增主键
    private Integer id;

    @Column(name = "fid")
    private int fid;

    @Column(name = "cid")
    private int cid;

//    @ManyToOne(targetEntity = Food.class,fetch = FetchType.LAZY)
//    @JoinColumn(name = "fid",referencedColumnName = "id")
//    private Food food;
//
//    @ManyToOne(targetEntity = Chef.class,fetch = FetchType.LAZY)
//    @JoinColumn(name = "cid",referencedColumnName = "id")
//    private Chef chef;

//    public Food getFood() {
//        return food;
//    }
//
//    public void setFood(Food food) {
//        this.food = food;
//    }
//
//    public Chef getChef() {
//        return chef;
//    }
//
//    public void setChef(Chef chef) {
//        this.chef = chef;
//    }


    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
