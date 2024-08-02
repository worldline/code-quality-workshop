package com.worldline.ep2.kata.rest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.worldline.ep2.kata.entity.DVD;
import com.worldline.ep2.kata.entity.DVDRentEvents;

@Path("/dvdevents")
@Produces
public class DVDEventsResource {


    @GET
    public List<DVDRentEvents> listDVDs() {
        return DVDRentEvents.listAll();
    }

    @GET
    @Path("/{idOrName}")
    public List<DVDRentEvents> listDVDByIdOrName(@PathParam("idOrName") String idOrName) {

        DVD dvvd = null;

        try {
            Long idL = Long.parseLong(idOrName);
            dvvd = DVD.findById(idL);
        } catch (Exception e){        }

        if ( dvvd == null){
            dvvd = DVD.findByTitle(idOrName);
        }

        if ( dvvd!=null){
            return DVDRentEvents.findByDvd(dvvd).collect(Collectors.toList());
        }

        return null;
    }

    @GET
    @Path("/byDate/{dateS}")
    public List<DVDRentEvents> listDVDByDate(@PathParam("dateS") String dateS) {
        List<DVDRentEvents> result = DVDRentEvents.findByDate( LocalDate.parse(dateS)).collect(Collectors.toList());
        return result;
    }
}


