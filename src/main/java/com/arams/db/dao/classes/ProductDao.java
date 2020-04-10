package com.arams.db.dao.classes;

import com.arams.beans.Category;
import com.arams.beans.Product;
import com.arams.db.connection.HibernateConnector;
import com.arams.db.dao.interfaces.IProductDao;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class ProductDao {

    public  static Product addProduct(Product product) {
        Session session = HibernateConnector.getInstance().getSession();
        session.beginTransaction();
        session.persist(product);
        session.getTransaction().commit();
        session.close();
        return product;
    }

    public static Product updateProduct(Product product) {
        Session session = HibernateConnector.getInstance().getSession();
        session.beginTransaction();
        session.update(product);
        session.getTransaction().commit();
        session.close();
        return product;
    }

    public static Product deleteProduct(int productId) {
        Session session = HibernateConnector.getInstance().getSession();
        Product product = session.load(Product.class, productId);
        session.beginTransaction();
        session.delete(product);
        session.getTransaction().commit();
        session.close();
        return product;
    }

    public static List<Product> getAllProducts() {
        Session session = HibernateConnector.getInstance().getSession();
        CriteriaBuilder productCriteria = session.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = productCriteria.createQuery(Product.class);
        criteriaQuery.from(Product.class);
        List<Product> products = session.createQuery(criteriaQuery).getResultList();
        return products;
    }
}
