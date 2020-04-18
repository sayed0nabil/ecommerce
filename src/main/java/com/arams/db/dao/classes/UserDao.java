package com.arams.db.dao.classes;

import com.arams.beans.User;
import com.arams.beans.UserProductCart;
import com.arams.db.connection.HibernateConnector;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.Set;

public class UserDao {

    public static void addUser(User user) {
        Session session = HibernateConnector.getInstance().getSession();
        session.beginTransaction();
        session.saveOrUpdate(user);
        session.getTransaction().commit();
    }

    public static User getUser(int id) {
        Session session = HibernateConnector.getInstance().getSession();
        User user = session.get(User.class, id);
        return user;
    }

    public static User getUserByEmail(String email) {
        Session session = HibernateConnector.getInstance().getSession();
        Criteria criteria = session.createCriteria(User.class, "user");
        criteria.add(Restrictions.eq("email", email));
        User user = (User) criteria.uniqueResult();
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

    public static void updateUser(User user) {

        Session session = HibernateConnector.getInstance().getSession();
        session.beginTransaction();
        session.merge(user);
        session.getTransaction().commit();

    }

    public static void clearUserCart(User user) {
        Session session = HibernateConnector.getInstance().getSession();
        session.beginTransaction();
        Set<UserProductCart> userProductCarts = user.getUserProductCarts();
        for (UserProductCart cartProduct : userProductCarts) {
            session.remove(cartProduct);
            cartProduct.setId(null);
        }
        session.getTransaction().commit();
    }

}
