package com.quality.workshop.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "ACTOR")
public class Schauspieler extends PanacheEntity {
    public String name;
    public String lastName;

    public static Schauspieler findByName(String name){
        return find("name", name).firstResult();
    }



}
