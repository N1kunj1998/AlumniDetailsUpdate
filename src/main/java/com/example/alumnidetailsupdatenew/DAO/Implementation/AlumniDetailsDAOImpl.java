package com.example.alumnidetailsupdatenew.DAO.Implementation;

import com.example.alumnidetailsupdatenew.DAO.AlumniDetailsDAO;

import com.example.alumnidetailsupdatenew.bean.AlumniDetails;
import com.example.alumnidetailsupdatenew.util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class AlumniDetailsDAOImpl implements AlumniDetailsDAO {
    @Override
    public boolean addDetails(AlumniDetails alumniDetails) {
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction t = session.beginTransaction();
            session.save(alumniDetails);
            t.commit();
            return true;
        } catch (HibernateException exception){
            System.out.println(exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public boolean updateDetails(Integer id,AlumniDetails alumniDetails) {
        try(Session session = HibernateSessionUtil.getSession()){
            session.beginTransaction();
            alumniDetails.setAlumniDetails_id(id);
            session.update(alumniDetails);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (HibernateException exception){
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteDetails(Integer id) {
        try(Session session = HibernateSessionUtil.getSession()){
            session.beginTransaction();
            Query query = session.createQuery("delete AlumniDetails where AlumniDetails_id=:alumniId");
            query.setParameter("alumniId",id);
            int result = query.executeUpdate();
            if(result > 0 ){
                System.out.println("Alumni details with id {" + id + "} deleted");
            }
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (HibernateException exception){
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public AlumniDetails getDetails(Integer id) {
        try(Session session = HibernateSessionUtil.getSession()){
            return session.get(AlumniDetails.class, id);
        } catch (HibernateException exception){
            System.out.println(exception.getLocalizedMessage());
            return  new AlumniDetails();
        }
    }

    @Override
    public List<AlumniDetails> getAllEmployeeDetails() {
        Session session = HibernateSessionUtil.getSession();
        List<AlumniDetails> alumniDetailsList = new ArrayList<>();
        try{
            for (final Object alumniDetails : session.createQuery("from AlumniDetails ").list()){
                alumniDetailsList.add((AlumniDetails) alumniDetails);
            }
        }catch (HibernateException exception){
            System.out.println(exception.getLocalizedMessage());
        }
        return alumniDetailsList;
    }
}
