package com.example.alumnidetailsupdatenew.controller;

import com.example.alumnidetailsupdatenew.POJO.AlumniDetailsPOJO;
import com.example.alumnidetailsupdatenew.bean.AlumniDetails;

import java.util.ArrayList;
import java.util.List;

public class AlumniDetailsControllerUtil {

    public List<AlumniDetailsPOJO> mapAlumniDetailsBeanToPojo(List<AlumniDetails> alumniDetailsList){
        List<AlumniDetailsPOJO> result = new ArrayList<>();
        for(int i=0 ; i<alumniDetailsList.size() ; i++){
            AlumniDetails alumniDetails = alumniDetailsList.get(i);
            AlumniDetailsPOJO alumniDetailsPOJO = new AlumniDetailsPOJO();
            alumniDetailsPOJO.setAlumniDetails_id(alumniDetails.getAlumniDetails_id());
            alumniDetailsPOJO.setEmail(alumniDetails.getEmail());
            alumniDetailsPOJO.setContact(alumniDetails.getContact());
            alumniDetailsPOJO.setDegree(alumniDetails.getDegree());
            alumniDetailsPOJO.setCollage_name(alumniDetails.getCollage_name());
            alumniDetailsPOJO.setPosition(alumniDetails.getPosition());
            result.add(alumniDetailsPOJO);
        }
        return result;
    }


}
