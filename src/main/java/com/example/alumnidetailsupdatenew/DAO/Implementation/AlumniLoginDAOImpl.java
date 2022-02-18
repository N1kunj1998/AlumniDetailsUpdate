package com.example.alumnidetailsupdatenew.DAO.Implementation;

import com.example.alumnidetailsupdatenew.DAO.AlumniLoginDAO;
import com.example.alumnidetailsupdatenew.bean.AlumniDetails;
import com.example.alumnidetailsupdatenew.bean.AlumniLogin;
import com.example.alumnidetailsupdatenew.util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;

public class AlumniLoginDAOImpl implements AlumniLoginDAO {

    @Override
    public Integer verifyAlumni(AlumniLogin alumniLogin) {
        Session session = HibernateSessionUtil.getSession();
        try {
            System.out.println("from frontend username : "+alumniLogin.getUsername());
            System.out.println("from frontend password : "+alumniLogin.getPassword());
            Query query = session.createQuery("from AlumniLogin where username=:username and password=:password");
            query.setParameter("username", alumniLogin.getUsername());
            query.setParameter("password", alumniLogin.getPassword());

            if(query.getResultList().size()==1){
                AlumniLogin alumniLogin1 = (AlumniLogin) query.getResultList().get(0);
                return alumniLogin1.getId();
            }

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean addAlumni(AlumniLogin alumniLogin) {
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction t = session.beginTransaction();
            session.save(alumniLogin);
            t.commit();
            return true;
        } catch (HibernateException exception){
            System.out.println(exception.getLocalizedMessage());
            return false;
        }
    }
}
