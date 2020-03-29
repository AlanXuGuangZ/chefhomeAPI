package com.example.chefhome.main;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "feasttype")
public class FeastType {

    @Id //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增主键
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "feastType",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Feast> feasts = new HashSet<Feast>();

    public Set<Feast> getFeasts() {
        return feasts;
    }

    public void setFeasts(Set<Feast> feasts) {
        this.feasts = feasts;
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
}
