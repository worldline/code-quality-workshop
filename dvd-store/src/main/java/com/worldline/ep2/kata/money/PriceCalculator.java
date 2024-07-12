package com.worldline.ep2.kata.money;

import com.worldline.ep2.kata.entity.DVD;
import com.worldline.ep2.kata.entity.VideoTape;

public class PriceCalculator {

    public static int computeDVDPrice(DVD dvd){
        return (int) 13.4f + 10/ ( Math.abs(dvd.getReleaseDate().getYear()-2018));
    }


    public static int computeDVDPrice(VideoTape vt){
        return (int) ((int) 5 + 0.0001d * vt.duration);
    }


}
