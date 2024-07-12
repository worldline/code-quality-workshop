package com.worldline.ep2.kata.db;

import javax.enterprise.context.ApplicationScoped;


import com.worldline.ep2.kata.entity.DVDRentEvents;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class DBRepo implements PanacheRepository<DVDRentEvents> {


    public void save(DVDRentEvents event){
        persist(event);
    }
}
