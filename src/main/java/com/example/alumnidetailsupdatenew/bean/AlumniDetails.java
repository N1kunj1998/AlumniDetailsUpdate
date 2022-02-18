package com.example.alumnidetailsupdatenew.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
public class AlumniDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer AlumniDetails_id;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false,unique = true)
    private String contact;

    @Column(nullable = false)
    private String degree;

    @Column(nullable = false)
    private String collage_name;

    @Column(nullable = false)
    private String position;

//    @Column(nullable = false)
//    private Date joining_date;

    @ManyToOne
    @JoinColumn(name = "alumni_login_id")
    private AlumniLogin alumniLogin;

    public AlumniDetails() {
    }

//    public AlumniDetails(String email, String contact, String degree, String collage_name, String position, Date joining_date, AlumniLogin alumniLogin) {
//        this.email = email;
//        this.contact = contact;
//        this.degree = degree;
//        this.collage_name = collage_name;
//        this.position = position;
//        this.joining_date = joining_date;
//        this.alumniLogin = alumniLogin;
//    }

    public AlumniDetails(String email, String contact, String degree, String collage_name, String position, AlumniLogin alumniLogin) {
        this.email = email;
        this.contact = contact;
        this.degree = degree;
        this.collage_name = collage_name;
        this.position = position;
        this.alumniLogin = alumniLogin;
    }


//    public AlumniDetails(String email, String contact, String degree, String collage_name, String position) {
//        this.email = email;
//        this.contact = contact;
//        this.degree = degree;
//        this.collage_name = collage_name;
//        this.position = position;
//    }

    public Integer getAlumniDetails_id() {
        return AlumniDetails_id;
    }

    public void setAlumniDetails_id(Integer alumniDetails_id) {
        AlumniDetails_id = alumniDetails_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getCollage_name() {
        return collage_name;
    }

    public void setCollage_name(String collage_name) {
        this.collage_name = collage_name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public AlumniLogin getAlumniLogin() {
        return alumniLogin;
    }

    public void setAlumniLogin(AlumniLogin alumniLogin) {
        this.alumniLogin = alumniLogin;
    }
    //    public Date getJoining_date() {
//        return joining_date;
//    }
//
//    public void setJoining_date(Date joining_date) {
//        this.joining_date = joining_date;
//    }
//
//    public AlumniLogin getAlumniLogin() {
//        return alumniLogin;
//    }
//
//    public void setAlumniLogin(AlumniLogin alumniLogin) {
//        this.alumniLogin = alumniLogin;
//    }
}
