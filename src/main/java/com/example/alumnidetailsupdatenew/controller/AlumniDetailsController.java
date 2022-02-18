package com.example.alumnidetailsupdatenew.controller;



import com.example.alumnidetailsupdatenew.POJO.AlumniDetailsPOJO;
import com.example.alumnidetailsupdatenew.Service.AlumniDetailsService;
import com.example.alumnidetailsupdatenew.bean.AlumniDetails;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Path("AlumniDetails")
public class AlumniDetailsController extends AlumniDetailsControllerUtil{
    AlumniDetailsService alumniDetailsService = new AlumniDetailsService();

    @POST
    @Path("/addDetails")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDetails(AlumniDetails alumniDetails) throws URISyntaxException {
        System.out.println(" data that we got from front end" +alumniDetails.getAlumniLogin());
        boolean val = alumniDetailsService.addDetails(alumniDetails);
        if(val == true)
            return Response.ok().build();
        else
            return Response.status(203).build();
    }

    @POST
    @Path("/{AlumniDetailsId}/updateDetails")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDetails(@PathParam("AlumniDetailsId") Integer id,AlumniDetails alumniDetails){
        System.out.println(alumniDetails);
        boolean val = alumniDetailsService.updateDetails(id,alumniDetails);
        if(val == true)
            return Response.ok().build();
        else
            return Response.status(203).build();
    }

    @GET
    @Path("/{AlumniDetailsId}/getDetails")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDetails(@PathParam("AlumniDetailsId") Integer id){
        System.out.println("getDetails is working");
        AlumniDetails alumniDetails = alumniDetailsService.getDetails(id);
        List<AlumniDetails> alumniDetailsList = new ArrayList<>();
        alumniDetailsList.add(alumniDetails);

        List<AlumniDetailsPOJO> alumniDetailsPOJOList = mapAlumniDetailsBeanToPojo(alumniDetailsList);

        if(alumniDetails == null){
            return Response.noContent().build();
        }
        return Response.ok().entity(alumniDetailsPOJOList).build();
    }

    @GET
    @Path("/getAllDetails")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDetails(){
        List<AlumniDetails> alumniDetailsList = alumniDetailsService.getAllDetails();
        List<AlumniDetailsPOJO> alumniDetailsPOJOList = mapAlumniDetailsBeanToPojo(alumniDetailsList);

        if(alumniDetailsList == null){
            return Response.noContent().build();
        }
        return Response.ok().entity(alumniDetailsPOJOList).build();
    }

    @DELETE
    @Path("/{AlumniDetailsId}/deleteDetails")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteDetails(@PathParam("AlumniDetailsId") Integer id){
        boolean val = alumniDetailsService.deleteDetails(id);
        if(val == true)
            return Response.ok().build();
        else
            return Response.status(203).build();
    }
}
