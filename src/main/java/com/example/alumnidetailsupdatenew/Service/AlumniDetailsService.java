package com.example.alumnidetailsupdatenew.Service;

import com.example.alumnidetailsupdatenew.DAO.Implementation.AlumniDetailsDAOImpl;
import com.example.alumnidetailsupdatenew.bean.AlumniDetails;

import java.util.List;

public class AlumniDetailsService {
    AlumniDetailsDAOImpl alumniDetailsDAO = new AlumniDetailsDAOImpl();
    public boolean addDetails(AlumniDetails alumniDetails){
        return alumniDetailsDAO.addDetails(alumniDetails);
    }

    public AlumniDetails getDetails(Integer id){
        return alumniDetailsDAO.getDetails(id);
    }

    public boolean updateDetails(Integer id,AlumniDetails alumniDetails){
        return alumniDetailsDAO.updateDetails(id,alumniDetails);
    }

    public List<AlumniDetails> getAllDetails(){
        return alumniDetailsDAO.getAllEmployeeDetails();
    }
    public  boolean deleteDetails(Integer id) { return alumniDetailsDAO.deleteDetails(id); }
}
