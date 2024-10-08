package com.quality.workshop.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "DVD")
public class DVD extends PanacheEntity {

    String ISBN;
    String title;

    @JsonIgnore
    private String fullTitle;
    String description;

    @ManyToOne
    Schauspieler mainActor;

    @ManyToMany
    List<Schauspieler> otherActors;

    LocalDate releaseDate;

    public static DVD findByTitle(String title){
        return find("title", title).firstResult();
    }


    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getFullTitle() {
        return fullTitle;
    }

    public void setTitle(String title) {
        this.title = title.substring(0,Math.min(20,title.length()));
        this.fullTitle = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Schauspieler getMainActor() {
        return mainActor;
    }

    public void setMainActor(Schauspieler mainActor) {
        this.mainActor = mainActor;
    }

    public List<Schauspieler> getOtherActors() {
        return otherActors;
    }

    public void setOtherActors(List<Schauspieler> otherActors) {
        this.otherActors = otherActors;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

}
