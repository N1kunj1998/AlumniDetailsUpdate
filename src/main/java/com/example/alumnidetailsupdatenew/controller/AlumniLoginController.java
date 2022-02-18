package com.example.alumnidetailsupdatenew.controller;

//import com.example.alumnidetailsupdatenew.Service.AlumniDetailsService;
import com.example.alumnidetailsupdatenew.Service.AlumniLoginService;
import com.example.alumnidetailsupdatenew.bean.AlumniDetails;
import com.example.alumnidetailsupdatenew.bean.AlumniLogin;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;

@Path("Alumni")
public class AlumniLoginController {
    AlumniLoginService alumniLoginService = new AlumniLoginService();

    @POST
    @Path("/verify")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response verifyFaculty(AlumniLogin alumniLogin) throws URISyntaxException {
        Integer facultyId = alumniLoginService.verifyAlumni(alumniLogin);
        if(facultyId != null){

            return Response.ok(facultyId).build();
        }else{
            return Response.status(203).build();
        }
    }

    @POST
    @Path("/addAlumni")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDetails(AlumniLogin alumniLogin) throws URISyntaxException {
        boolean val = alumniLoginService.addAlumni(alumniLogin);
        if(val == true)
            return Response.ok().build();
        else
            return Response.status(203).build();
    }
}
