package com.quality.workshop.db;

import javax.enterprise.context.ApplicationScoped;


import com.quality.workshop.entity.DVDRentEvents;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class DBRepo implements PanacheRepository<DVDRentEvents> {


    public void save(DVDRentEvents event){
        persist(event);
    }
}
