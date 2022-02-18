package com.example.alumnidetailsupdatenew.DAO;

import com.example.alumnidetailsupdatenew.bean.AlumniDetails;

import java.util.List;

public interface AlumniDetailsDAO {
    boolean addDetails(AlumniDetails alumniDetails);
    boolean updateDetails(Integer id,AlumniDetails alumniDetails);
    boolean deleteDetails(Integer id);
    AlumniDetails getDetails(Integer id);
    public abstract List<AlumniDetails> getAllEmployeeDetails();

}
