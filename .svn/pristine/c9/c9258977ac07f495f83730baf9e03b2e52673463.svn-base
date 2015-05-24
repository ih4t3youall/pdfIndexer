package ar.com.indexer.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil
{  
    private static final SessionFactory sessionFactory;   

    static 
    { 
        try 
        { 
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            
        } catch (HibernateException he) 
        { 
           System.err.println("Ocurrio un error en la inicializacion de la SessionFactory: " + he); 
            throw new ExceptionInInitializerError(he); 
        } 
    }  
    
    

    public static SessionFactory getSessionFactory() 
    { 
        return sessionFactory; 
    } 
}