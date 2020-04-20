package com.arams.db.dao.classes;

import com.arams.beans.Category;
import com.arams.beans.Product;
import com.arams.db.connection.HibernateConnector;
import com.arams.db.dao.interfaces.ICategoryDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {

    public static List<Category> getAllCategories() {

        HibernateConnector hibernateConnector = HibernateConnector.getInstance();
        Session session = hibernateConnector.getSession();
        CriteriaBuilder categoryCriteria = session.getCriteriaBuilder();
        CriteriaQuery<Category> criteriaQuery = categoryCriteria.createQuery(Category.class);
        criteriaQuery.from(Category.class);
        List<Category> categories = session.createQuery(criteriaQuery).getResultList();
        session.close();
        return categories;
    }

    /**
     * method for the admin to add new category
     *
     * @param category
     */
    public static void addCategory(Category category) {
        HibernateConnector hibernateConnector = HibernateConnector.getInstance();
        Session session = hibernateConnector.getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(category);
        transaction.commit();
        session.close();
    }

    /**
     * retriving category by name
     *
     * @param categoryName
     * @return
     */
    public static Category getCategoryByName(String categoryName) {
        Session session = HibernateConnector.getInstance().getSession();
        Criteria criteria = session.createCriteria(Category.class).add(Restrictions.eq("name", categoryName).ignoreCase());
        Category category = (Category) criteria.uniqueResult();
        if (category == null)
            return null;
        else
            return category;
    }


    public static Category removeCategory(int categoryId){
        Session session = HibernateConnector.getInstance().getSession();
        Category category = session.get(Category.class, categoryId);
        if(category == null) return null;
        session.beginTransaction();
        session.delete(category);
        session.getTransaction().commit();
        return category;
    }


}
