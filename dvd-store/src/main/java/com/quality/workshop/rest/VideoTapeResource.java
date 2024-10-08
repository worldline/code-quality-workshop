package com.quality.workshop.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.quality.workshop.entity.Schauspieler;
import com.quality.workshop.entity.VideoTape;

@Path("/video")
public class VideoTapeResource {

    @GET
    public List<VideoTape> listActors() {
        return VideoTape.listAll();
    }

    @GET
    @Path("/{id}")
    public VideoTape get( @PathParam("id") String id) {
        VideoTape result = null;

        try {
            Long idL = Long.parseLong(id);
            result = VideoTape.findById(idL);
        } catch (Exception e){        }


        return result;
    }

}

