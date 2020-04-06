package com.example.chefhome.main;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "feast")
public class Feast {

    @Id //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增主键
    private Integer id;

    @Column(name = "detail")
    private String detail;

    @Column(name = "price")
    private int price;

    @Column(name = "image")
    private String image;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @ManyToOne(targetEntity = FeastType.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "ftid",referencedColumnName = "id")
    private FeastType feastType;

    public FeastType getFeastType() {
        return feastType;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public void setFeastType(FeastType feastType) {
        this.feastType = feastType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
