package com.arams.db.connection;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConnector {
    private static HibernateConnector hibernateConnector;
    private Configuration cfg;
    private SessionFactory sessionFactory;


    private HibernateConnector() throws HibernateException {
        cfg = new Configuration();
        sessionFactory = cfg.configure("/config/hibernate.cfg.xml").buildSessionFactory();
    }

    /**
     * @return HibernateConnector single instance
     * @throws HibernateException
     */
    public static synchronized HibernateConnector getInstance() throws HibernateException {
        if (hibernateConnector == null) {
            hibernateConnector = new HibernateConnector();
        }
        return hibernateConnector;
    }

    /**
     * @return session object
     * @throws HibernateException
     */
    public Session getSession() throws HibernateException {
        Session session = sessionFactory.openSession();
//        if (!session.isConnected()) {
//            this.reconnect();
//        }
        return session;
    }

    /**
     * reconnecting to the database if session is not connected
     *
     * @throws HibernateException
     */
    private void reconnect() throws HibernateException {
        this.sessionFactory = cfg.configure("/config/hibernate.cfg.xml").buildSessionFactory();
    }
}
