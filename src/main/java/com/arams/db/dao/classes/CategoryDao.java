package com.arams.db.dao.classes;

import com.arams.beans.Category;
import com.arams.db.connection.HibernateConnector;
import com.arams.db.dao.interfaces.ICategoryDao;
import org.hibernate.Criteria;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao implements ICategoryDao {
    @Override
    public List<Category> getAllCategories() {

        HibernateConnector hibernateConnector = HibernateConnector.getInstance();
        Session session = hibernateConnector.getSession();
        CriteriaBuilder categoryCriteria = session.getCriteriaBuilder();
        CriteriaQuery<Category> criteriaQuery = categoryCriteria.createQuery(Category.class);
        criteriaQuery.from(Category.class);
        List<Category> categories = session.createQuery(criteriaQuery).getResultList();
        return categories;
    }
}
