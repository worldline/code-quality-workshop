package com.worldline.ep2.kata.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.stream.Stream;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "EVENTS")
public class DVDRentEvents extends PanacheEntity {


    public   LocalDate rentingDate;

    @ManyToOne
    public  DVD  dvd;

    public int durationInDays;

    public static Stream<DVDRentEvents> findByDvd(DVD dvd){
        return find("dvd", dvd).stream();
    }
    public static Stream<DVDRentEvents> findByDate(LocalDate localDate){
        Date date = Date.valueOf(localDate);
        return find("rentingDate", localDate).stream();
    }
}
