package com.example.alumnidetailsupdatenew.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "AlumniLogin")
public class AlumniLogin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "alumniLogin")
    private List<AlumniDetails> alumniDetails;

    public AlumniLogin() {
    }

//    public AlumniLogin(String username, String password) {
//        this.username = username;
//        this.password = password;
//    }

    public AlumniLogin(String username, String password, List<AlumniDetails> alumniDetails) {
        this.username = username;
        this.password = password;
        this.alumniDetails = alumniDetails;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<AlumniDetails> getAlumniDetails() {
        return alumniDetails;
    }

    public void setAlumniDetails(List<AlumniDetails> alumniDetails) {
        this.alumniDetails = alumniDetails;
    }
}