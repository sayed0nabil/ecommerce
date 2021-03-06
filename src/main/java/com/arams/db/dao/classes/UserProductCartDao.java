package com.arams.db.dao.classes;

import com.arams.beans.User;
import com.arams.beans.UserProductCart;
import com.arams.beans.UserProductCartId;
import com.arams.db.connection.HibernateConnector;
import org.hibernate.Session;

import java.util.Set;

public class UserProductCartDao {

    public static UserProductCart addProductToCart(UserProductCart userProductCart) {
        Session session = HibernateConnector.getInstance().getSession();
        session.beginTransaction();
        session.persist(userProductCart);
        session.getTransaction().commit();
        return userProductCart;
    }

    public static UserProductCart updateProductToCart(UserProductCart userProductCart) {
        Session session = HibernateConnector.getInstance().getSession();
        session.beginTransaction();
        session.merge(userProductCart);
        session.getTransaction().commit();
        return userProductCart;
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

    public static UserProductCart removeProductFromCart(int productId, int userId) {
        Session session = HibernateConnector.getInstance().getSession();
        UserProductCart userProductCart = session.get(UserProductCart.class, new UserProductCartId(userId, productId));
        if(userProductCart == null) {
            System.out.println("Null Two");
            return null;
        };
        session.beginTransaction();
        session.delete(userProductCart);
        session.getTransaction().commit();
        return userProductCart;
    }
}
