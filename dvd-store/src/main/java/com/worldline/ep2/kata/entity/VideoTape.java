package com.worldline.ep2.kata.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "VIDEO_TAPE")
public class VideoTape extends PanacheEntity {

    public  String ISBN;
    public  String desciption;
    public  String title;

    @ManyToMany
    public  List<Schauspieler> actors; // name as key, firstName + name as value

    public LocalDate releaseDate;
    public  Double locations;
    public  Long duration; // Duration in minuts ( between 60 and 180 )



}
