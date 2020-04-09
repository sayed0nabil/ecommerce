package com.arams.db.dao.classes;

import com.arams.beans.User;
import com.arams.db.connection.HibernateConnector;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.List;

public class UserDao {

    public static void addUser(User user) {
        Session session = HibernateConnector.getInstance().getSession();
        session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();
    }

    public static User getUser(int id) {
        Session session = HibernateConnector.getInstance().getSession();
        User user = session.get(User.class, id);
        return user;
    }

    public static List<User> getAllUser() {
        Session session = HibernateConnector.getInstance().getSession();
        Criteria criteria = session.createCriteria(User.class, "user");
        List<User> allUsers = criteria.list();
        return allUsers;
    }

    public void deleteUser(int id) {

    }

    public void updateUser(User user) {
    }

}
