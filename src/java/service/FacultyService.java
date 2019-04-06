/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Aspost;
import domain.Asubmitted;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author mrvataliya
 */
public class FacultyService {
    
    public boolean postasmnt(Aspost aspost)
    {
        //insert
        boolean isatatus = false;
        try{
       Configuration configuration = new Configuration().configure();
            ServiceRegistry serviceRegistry;
            serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            // builds a session factory from the service registry
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
           Session session = sessionFactory.openSession();
           session.beginTransaction();
           session.save(aspost);
           session.getTransaction().commit();
           isatatus = true;
       }catch(Exception e)
       {
           e.printStackTrace();
       }
       
        return isatatus;
    }
    public List getsubmissions()
    {
        List result = null;
        //get submitted assignment bu students
       Asubmitted asub = new Asubmitted();
       try{
       Configuration configuration = new Configuration().configure();
            ServiceRegistry serviceRegistry;
            serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            // builds a session factory from the service registry
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
           Session session = sessionFactory.openSession();
           session.beginTransaction();
           
            result = session.createQuery("from domain.Asubmitted").list();
           session.getTransaction().commit();
       }catch(Exception e)
       {
           e.printStackTrace();
       }
       
       return result;
    }
    
}
