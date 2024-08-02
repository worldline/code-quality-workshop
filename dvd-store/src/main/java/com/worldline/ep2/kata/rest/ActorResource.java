package com.worldline.ep2.kata.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.worldline.ep2.kata.entity.Schauspieler;

@Path("/actor")
public class ActorResource {

    @GET
    public List<Schauspieler> listActors() {
        return Schauspieler.listAll();
    }

    @GET
    @Path("/{id}")
    public Schauspieler get( @PathParam("id") String id) {
        Schauspieler result = null;

        try {
            Long idL = Long.parseLong(id);
            result = Schauspieler.findById(idL);
        } catch (Exception e){        }

        if ( result == null){
            result = Schauspieler.findByName(id);
        }

        return result;
    }

}

