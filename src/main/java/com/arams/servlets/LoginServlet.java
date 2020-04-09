package com.arams.servlets;

import com.arams.beans.User;
import com.google.gson.Gson;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        PrintWriter out = res.getWriter();
//        SessionFactory sessionFactory = new Configuration().configure("/config/hibernate.cfg.xml").buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        Criteria criteria = session.createCriteria(User.class, "user");
//        List<User> list = criteria.list();
//        Gson gson = new Gson();
//        out.println(gson.toJson(list, new TypeToken<List<User>>() {}.getType()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        Gson gson = new Gson();
        PrintWriter out = res.getWriter();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        System.out.println(email + " , " + password);
        SessionFactory sessionFactory = new Configuration().configure("/config/hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(User.class, "user");
        criteria.add(Restrictions.eq("email", email));
        criteria.add(Restrictions.eq("password", password));
        User user = (User) criteria.uniqueResult();
        //new TypeToken<User>() {}.getType()

        if (user != null) {
            System.out.println(user.getFirstName() + " " + user.getLastName());
            String loginResult = gson.toJson(user);
            System.out.println(loginResult);
            out.println(loginResult);
        } else {
            out.println("{\"error\":\"check email or password\"}");
        }
    }
}
