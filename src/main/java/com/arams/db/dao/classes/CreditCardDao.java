package com.arams.db.dao.classes;

import com.arams.beans.CreditCard;
import com.arams.beans.Product;
import com.arams.beans.ProductImage;
import com.arams.db.connection.HibernateConnector;
import org.hibernate.Session;
import org.hibernate.query.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.stream.Collectors;

public class CreditCardDao {


    public static List<CreditCard> getAllCredits(){
        Session session = HibernateConnector.getInstance().getSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<CreditCard> criteriaQuery = criteriaBuilder.createQuery(CreditCard.class);
        criteriaQuery.from(CreditCard.class);
        List<CreditCard> credits = session.createQuery(criteriaQuery).getResultList();
        return credits;
    }

    public static CreditCard addCard(CreditCard creditCard){
        Session session = HibernateConnector.getInstance().getSession();
        if(session.get(CreditCard.class, creditCard.getCode()) == null){
            session.beginTransaction();
            session.save(creditCard);
            session.getTransaction().commit();
            session.close();
            return creditCard;
        }
        return null;
    }

    public static CreditCard updateCard(CreditCard creditCard) {

        Session session = HibernateConnector.getInstance().getSession();
        session.beginTransaction();
        session.update(creditCard);
        session.getTransaction().commit();
        session.close();
        return creditCard;

    }

    public static CreditCard getCardByCode(int code) {

        CreditCard creditCard = null;

        try {

            Session session = HibernateConnector.getInstance().getSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<CreditCard> query = builder.createQuery(CreditCard.class);
            Root<CreditCard> root = query.from(CreditCard.class);
            query.select(root).where(builder.equal(root.get("code"), code));
            Query<CreditCard> q = session.createQuery(query);
            creditCard = q.getSingleResult();
            session.close();

        } catch (javax.persistence.NoResultException e) {

            System.out.println("No credit card found exception at get card by " +
                    "code method in Credit card dao class");

        }

        return creditCard;
    }

}
