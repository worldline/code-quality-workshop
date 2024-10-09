package com.quality.workshop;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.quality.workshop.entity.Schauspieler;
import com.quality.workshop.entity.VideoTape;

/**
 * Helper class to get Entity-like objects for unit-tests
 *
 * This may be improve, but it is easy to adapt to other entities
 */
public class TestEntityHelper {

    //Usefull objets
    static LocalDate date2006 = LocalDate.parse("2007-02-03");
    static LocalDate date2007 = LocalDate.parse("2007-02-03");
    static LocalDate date2017 = LocalDate.parse("2017-02-03");
    static LocalDate date2018 = LocalDate.parse("2018-05-05");
    static  LocalDate date2019Xmas = LocalDate.parse("2019-12-24");
    static LocalDate date2015 = LocalDate.parse("2015-04-04");

    // Famous Actors
    static Schauspieler TOM_C = createActor("Cruise","Tom");
    static Schauspieler LEO_C  = createActor("DiCaprio","Leonardo");
    static Schauspieler ANGIE  = createActor("Jolie","Angelina");
    static  Schauspieler BRAF  = createActor("Pitt","Brad");
    static Schauspieler SCAJO  = createActor("Johansson","Scarlett");
    static Schauspieler GALG = createActor("Gadot","Gal");

    //Video
    static VideoTape NINJA2V = createVideo("1234","Ninja-revenge-III","The return of the ninja, let's kick names and take ass!",date2015,10,125,BRAF,ANGIE,TOM_C);
    static VideoTape NINJA0 = createVideo("1232","Ninja-revenge-I","War between ninja brothers",date2006,10,125,BRAF,ANGIE);
    static VideoTape LADY_WAR = createVideo("1232","Crossover-Starwars-VS-Marvel","Who will save the earth",date2006,120,125,GALG,SCAJO);
    static VideoTape LADY_WAR_2 = createVideo("1232","Crossover-Starwars-VS-Marvel-2","Who will save the universe",date2018,20,90,BRAF,ANGIE);
    static VideoTape NINJA4V = createVideo("","Ninja-revenge-V","Will Ninja's kids get their father's revenge ?",date2018,10,125,BRAF,ANGIE,TOM_C);




    private static Schauspieler createActor(String lastName, String firstName){
        Schauspieler actor = new Schauspieler();
        actor.lastName=lastName;
        actor.name=firstName;

        return actor;
    }

    public static Stream<Schauspieler> getTestActors() {
        return Stream.of(TOM_C, LEO_C, ANGIE, BRAF, SCAJO, GALG);
    }

    public static Schauspieler getActor(String criteria){
        return  getTestActors().filter(actor -> actor.name.equals(criteria) || actor.lastName.equals(criteria))
                .findFirst().orElse(null);
    }

    public static Stream<VideoTape> getTestVideos() {
        return Stream.of(NINJA2V, NINJA0, LADY_WAR, LADY_WAR_2, NINJA4V);
    }

    public static VideoTape getVideo(String criteria){
        return  getTestVideos().filter(video -> video.title.equals(criteria) || video.ISBN.equals(criteria))
                .findFirst().orElse(null);
    }

    static VideoTape createVideo(String ISBN,String title, String description, LocalDate releaseDate, double locations, long duration, Schauspieler... actors) {
        VideoTape video = new VideoTape();
        video.ISBN = ISBN;
        video.title=title;
        video.desciption = description;
        video.releaseDate = releaseDate;
        video.locations = locations;
        video.duration= duration;
        video.actors= Arrays.stream(actors).collect(Collectors.toList());

        return video;
    }

}
