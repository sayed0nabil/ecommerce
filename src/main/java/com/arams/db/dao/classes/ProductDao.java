package com.arams.db.dao.classes;

import com.arams.beans.Product;
import com.arams.beans.ProductImage;
import com.arams.db.connection.HibernateConnector;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductDao {

    public static Product addProduct(Product product) {
        Session session = HibernateConnector.getInstance().getSession();
        session.beginTransaction();
        session.persist(product);
        Set<ProductImage> productImages = product.getProductImages();
        for (Iterator<ProductImage> it = productImages.iterator(); it.hasNext(); ) {
            ProductImage productImage = it.next();
            productImage.getId().setProductId(product.getId());
            session.persist(productImage);
        }
        session.getTransaction().commit();
        return product;
    }

    public static Product updateProduct(Product product) {
        Session session = HibernateConnector.getInstance().getSession();
        session.beginTransaction();
        session.merge(product);
        session.getTransaction().commit();
        return product;
    }

    public static Product deleteProduct(int productId) {
        Session session = HibernateConnector.getInstance().getSession();
        Product product = session.get(Product.class, productId);
        if(product == null) return null;
        session.beginTransaction();
        session.delete(product);
        session.getTransaction().commit();
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

    public static Product getProductById(int id) {
        Session session = HibernateConnector.getInstance().getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root<Product> root = query.from(Product.class);
        query.select(root).where(builder.equal(root.get("id"), id));
        Query<Product> q=session.createQuery(query);
        Product product =q.getSingleResult();
//        session.close();
        return product;
    }

    public static List<Product> searchProductByLimit(String keyword, boolean limit){
        Session session = HibernateConnector.getInstance().getSession();
        CriteriaBuilder productCriteria = session.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = productCriteria.createQuery(Product.class);
        Root<Product> root = criteriaQuery.from(Product.class);
        criteriaQuery.where(productCriteria.like(root.get("name"), "%" + keyword +"%"));
        Query<Product> query = session.createQuery(criteriaQuery);
        if(limit) query = query.setMaxResults(10);
        List<Product> products = query.getResultList();
        return products;
    }

    public static List<Product> getProductsByCategory(String categoryName) {
        Session session = HibernateConnector.getInstance().getSession();
//        CriteriaBuilder builder = session.getCriteriaBuilder();
        session.beginTransaction();
        String select = "select p FROM Product p INNER JOIN p.category";
        Query query = session.createQuery(select);
        List<Product> products = query.getResultList();
        products = products.stream().filter(product -> product.getCategory().getName().equals(categoryName)).collect(Collectors.toList());
        session.getTransaction().commit();
        return products;
    }
}
