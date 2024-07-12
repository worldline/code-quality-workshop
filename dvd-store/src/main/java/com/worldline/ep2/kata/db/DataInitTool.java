package com.worldline.ep2.kata.db;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import javax.transaction.Transactional;

import com.worldline.ep2.kata.entity.DVD;
import com.worldline.ep2.kata.entity.DVDRentEvents;
import com.worldline.ep2.kata.entity.Schauspieler;
import com.worldline.ep2.kata.entity.VideoTape;

import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class DataInitTool {

    @Transactional
    public void initData(@Observes StartupEvent event){
        System.out.println("Init database");

        //Usefull objets
        LocalDate date2006 = LocalDate.parse("2007-02-03");
        LocalDate date2007 = LocalDate.parse("2007-02-03");
        LocalDate date2017 = LocalDate.parse("2017-02-03");
        LocalDate date2018 = LocalDate.parse("2018-05-05");
        LocalDate date2019Xmas = LocalDate.parse("2019-12-24");
        LocalDate date2015 = LocalDate.parse("2015-04-04");


        // Actors
        Schauspieler tomC  = createActor("Cruise","Tom");
        Schauspieler leoC  = createActor("DiCaprio","Leonardo");
        Schauspieler angie  = createActor("Jolie","Angelina");
        Schauspieler brad  = createActor("Pitt","Brad");
        Schauspieler scaJo  = createActor("Johansson","Scarlett");
        Schauspieler galG  = createActor("Gadot","Gal");

        // DVD
        DVD ninja1 = createDVD("1233","Ninja-revenge-II","Ninja's revenge ! He will not let it go!",tomC,date2007,angie,brad);
        DVD ninja2 = createDVD("1234","Ninja-revenge-III","The return of the ninja, let's kick names and take ass!",tomC,date2015,angie,brad);
        DVD ninja3 = createDVD("1235","Ninja-revenge-IV","Origin of the saga",tomC,date2017,angie,brad);
        DVD ninja4 = createDVD("1236","Ninja-revenge-V","Will Ninja's kids get their father's revenge ?",tomC,date2018,angie,brad);
        DVD ninja4Bis = createDVD("1236","Ninja-revenge-V","Will Ninja's kids get their father's revenge ?",angie,date2018,tomC,brad);

        DVD ninjaXmas = createDVD("127","Ninja-revenge-Xmas's-special","No gifts, only kicks",leoC,date2019Xmas,angie,brad);

        //Video
        VideoTape ninja2V = createVideo("1234","Ninja-revenge-III","The return of the ninja, let's kick names and take ass!",date2015,10,125,brad,angie,tomC);

        VideoTape ninja0 = createVideo("1232","Ninja-revenge-I","War between ninja brothers",date2006,10,125,brad,angie);
        VideoTape ladyWar = createVideo("1232","Crossover-Starwars-VS-Marvel","Who will save the earth",date2006,120,125,galG,scaJo);
        VideoTape ladyWar2 = createVideo("1232","Crossover-Starwars-VS-Marvel-2","Who will save the universe",date2018,20,90,brad,angie);
        VideoTape ninja4V = createVideo("","Ninja-revenge-V","Will Ninja's kids get their father's revenge ?",date2018,10,125,brad,angie,tomC);


        LocalDate rent12122012 = LocalDate.parse("2012-12-12");
        LocalDate rent03032020 = LocalDate.parse("2020-03-03");
        LocalDate rent04042018 = LocalDate.parse("2018-04-04");

        //DVDEvents
        DVDRentEvents event_ninja1_1= createEvent(ninja1,rent12122012,5);
        DVDRentEvents event_ninja1_2= createEvent(ninja1,rent03032020,3);
        DVDRentEvents event_ninja1_3= createEvent(ninja1,rent04042018,1);

        DVDRentEvents event_ninjaXMAS_1= createEvent(ninjaXmas,rent03032020,10);


    }

    Schauspieler createActor(String lastName, String firstName){
        Schauspieler actor = new Schauspieler();
        actor.lastName=lastName;
        actor.name=firstName;
        actor.persist();

        return actor;
    }


    DVD createDVD(String ISBN, String title, String description, Schauspieler actor, LocalDate releaseDate, Schauspieler... actors) {
        DVD dvd = new DVD();
        dvd.setISBN(ISBN);
        dvd.setTitle(title);
        dvd.setDescription(description);
        dvd.setMainActor(actor);
        dvd.setReleaseDate(releaseDate);
        dvd.setOtherActors(Arrays.stream(actors).collect(Collectors.toList()) );

        dvd.persist();

        return dvd;
    }

    DVDRentEvents createEvent(DVD dvd, LocalDate rentingDate ,int durationInDays){
        DVDRentEvents event = new DVDRentEvents();

        event.dvd=dvd;
        event.rentingDate=rentingDate;
        event.durationInDays= durationInDays;

        event.persist();
        return event;
    }

    VideoTape createVideo(String ISBN,String title, String description, LocalDate releaseDate, double locations, long duration, Schauspieler... actors) {
        VideoTape video = new VideoTape();
        video.ISBN = ISBN;
        video.title=title;
        video.desciption = description;
        video.releaseDate = releaseDate;
        video.locations = locations;
        video.duration= duration;
        video.actors= Arrays.stream(actors).collect(Collectors.toList());

        video.persist();

        return video;
    }


}
