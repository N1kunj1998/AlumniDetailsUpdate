package com.example.alumnidetailsupdatenew.POJO;

public class AlumniDetailsPOJO {
    private Integer AlumniDetails_id;
    private String email;
    private String contact;
    private String degree;
    private String collage_name;
    private String position;

    public AlumniDetailsPOJO() {
    }

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
}
