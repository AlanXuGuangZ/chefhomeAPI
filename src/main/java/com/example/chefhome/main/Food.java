package com.example.chefhome.main;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "food")
public class Food {

    @Id //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增主键
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "detail")
    private String detail;

    @Column(name = "image")
    private String image;

    @ManyToMany(targetEntity = Chef.class)
    @JoinTable(name = "foodchef", joinColumns = {@JoinColumn(name = "fid",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "cid",referencedColumnName = "id")})
    private Set<Chef> chefs = new HashSet<Chef>();


    @JsonIgnore
    @ManyToOne(targetEntity = FoodType.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "tid",referencedColumnName = "id")
    private FoodType foodType;


//    @OneToMany(mappedBy = "food",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    private Set<FoodChef> foodChefs = new HashSet<FoodChef>();
//
//    public Set<FoodChef> getFoodChefs() {
//        return foodChefs;
//    }
//
//    public void setFoodChefs(Set<FoodChef> foodChefs) {
//        this.foodChefs = foodChefs;
//    }

    public Set<Chef> getChefs() {
        return chefs;
    }

    public void setChefs(Set<Chef> chefs) {
        this.chefs = chefs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

}
