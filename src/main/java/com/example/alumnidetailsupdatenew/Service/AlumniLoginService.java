package com.example.alumnidetailsupdatenew.Service;

import com.example.alumnidetailsupdatenew.DAO.Implementation.AlumniLoginDAOImpl;
import com.example.alumnidetailsupdatenew.bean.AlumniLogin;

public class AlumniLoginService {
    AlumniLoginDAOImpl alumniLoginDAO = new AlumniLoginDAOImpl();
    public Integer verifyAlumni(AlumniLogin alumniLogin){
        return alumniLoginDAO.verifyAlumni(alumniLogin);
    }
    public boolean addAlumni(AlumniLogin alumniLogin){
        return alumniLoginDAO.addAlumni(alumniLogin);
    }
}
