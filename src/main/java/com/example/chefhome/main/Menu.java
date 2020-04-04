package com.example.chefhome.main;
import javax.persistence.*;

@Entity
@Table(name ="menu")
public class Menu {

    @Id //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增主键
    private Integer id;

    @Column(name = "menuname")
    private String menuname;
    @Column(name = "cuisine")
    String cuisine;
    @Column(name = "chefname")
    String chefname;
    @Column(name = "chefstar")
    Integer chefstar;
    @Column(name = "chefdesc")
    String chefdesc;
    @Column(name = "distance")
    String distance;
    @Column(name = "ingredients")
    String ingredients;
    @Column(name = "howtodo")
    String howtodo;
    @Column(name = "comment")
    String comment;
    @Column(name = "receivenum")
    Integer receivenum;
    @Column(name = "menumoney")
    String menumoney;

    public Menu() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public Integer getChefstar() {
        return chefstar;
    }

    public void setChefstar(Integer chefstar) {
        this.chefstar = chefstar;
    }

    public Integer getReceivenum() {
        return receivenum;
    }

    public void setReceivenum(Integer receivenum) {
        this.receivenum = receivenum;
    }

    public String getChefdesc() {
        return chefdesc;
    }

    public void setChefdesc(String chefdesc) {
        this.chefdesc = chefdesc;
    }

    public String getChefname() {
        return chefname;
    }

    public void setChefname(String chefname) {
        this.chefname = chefname;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getHowtodo() {
        return howtodo;
    }

    public void setHowtodo(String howtodo) {
        this.howtodo = howtodo;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getMenumoney() {
        return menumoney;
    }

    public void setMenumoney(String menumoney) {
        this.menumoney = menumoney;
    }
}
