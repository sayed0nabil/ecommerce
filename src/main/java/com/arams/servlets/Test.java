package com.arams.servlets;


import com.arams.beans.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/test")
public class Test extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        SessionFactory sessionFactory = new Configuration().configure("/config/hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(User.class, "user");
        List<User> list = criteria.list();
        Gson gson = new Gson();
        out.println(gson.toJson(list, new TypeToken<List<User>>() {}.getType()));
    }
}
