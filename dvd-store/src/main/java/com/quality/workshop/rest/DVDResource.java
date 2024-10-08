package com.quality.workshop.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.quality.workshop.entity.DVD;
import com.quality.workshop.entity.Schauspieler;

@Path("/dvd")
public class DVDResource {


        @GET
        public List<DVD> listDVDs() {
            return DVD.listAll();
        }

    @GET
    @Path("/{id}")
    public DVD get( @PathParam("id") String idOrName) {
        DVD result = null;

        try {
            Long idL = Long.parseLong(idOrName);
            result = DVD.findById(idL);
        } catch (Exception e){        }

        if ( result == null){
            result = DVD.findByTitle(idOrName);
        }

        return result;
    }

}
