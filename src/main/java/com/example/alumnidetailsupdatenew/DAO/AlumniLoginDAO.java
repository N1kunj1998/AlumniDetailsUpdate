package com.example.alumnidetailsupdatenew.DAO;

import com.example.alumnidetailsupdatenew.bean.AlumniLogin;

public interface AlumniLoginDAO {
    Integer verifyAlumni(AlumniLogin alumniLogin);
    boolean addAlumni(AlumniLogin alumniLogin);
}
