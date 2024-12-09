package com.dilawar.project.com.dilawar.project.repository.mysql;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class DatabaseClient {
    
    public static Session getCurrentSessionFromConfig() {
    	  Configuration config = new Configuration();
    	  config.configure();
    	  SessionFactory sessionFactory = config.buildSessionFactory();
    	  return sessionFactory.getCurrentSession();
    	}
}



