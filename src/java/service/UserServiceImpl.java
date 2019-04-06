/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Asubmitted;
import domain.HibernateUtil;
import domain.Useroep;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class UserServiceImpl implements UserService {

    /**
     *
     * @param user
     * @return
     */
    @Override
	public boolean loginstudent(Useroep user) {
		//Persist the user object here. 
           boolean status = false;
           Session session = null;
            try{
           session = HibernateUtil.getSessionFactory().openSession();
           session.beginTransaction();
           List result;
           result = session.createQuery("from Useroep where uname='"+user.getUname()+"' and faculty='false'").list();
           //for(Iterator i = result.iterator();i.hasNext();)
           //{
                 Iterator i = result.iterator();
               Useroep user1 = (Useroep)i.next();
               if(user1.getPassword().equals(user.getPassword()))
               {
                   status = true;
                  // break;
               }
               else
               {
                   status=false;
               }
           //}
           session.getTransaction().commit();
           }
        catch(Exception ex)
        {
            System.err.println("Exception::"+ex);
        }
        finally{
                System.out.println("Succesfull 123456789  "+status);
            //session.close();
        }
            System.out.println("Status "+status);
          return status;  
	}

    @Override
    public boolean loginfaculty(Useroep useroep) {
        boolean status = false;
           Session session = null;
            try{
           session = HibernateUtil.getSessionFactory().openSession();
           session.beginTransaction();
           List result;
           result = session.createQuery("from Useroep where uname='"+useroep.getUname()+"'and faculty='true'").list();
           //for(Iterator i = result.iterator();i.hasNext();)
           //{
                 Iterator i = result.iterator();
               Useroep user1 = (Useroep)i.next();
               if(user1.getPassword().equals(useroep.getPassword()))
               {
                   System.out.println("----Password"+user1.getPassword());
                   System.out.println("----Uname"+user1.getUname());
                   System.out.println("------Entered Password"+useroep.getPassword());
                   status = true;
                  // break;
               }
               else
               {
                   status=false;
               }
           //}
           session.getTransaction().commit();
           }
        catch(Exception ex)
        {
            System.err.println("Exception::"+ex);
        }
        finally{
                System.out.println("Succesfull 123456789  "+status);
            //session.close();
        }
            System.out.println("Status "+status);
          return status;  
    }

    /**
     *
     * @return
     */
    @Override
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
