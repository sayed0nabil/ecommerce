package com.arams.servlets;

import com.arams.beans.User;
import com.arams.db.dao.classes.UserDao;

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

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        PrintWriter out = res.getWriter();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = UserDao.getUserByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
                req.getSession(true).setAttribute("mine", user);
                out.println("{}");
        }else {
            out.println("{\"error\":\"check email or password\"}");
        }
    }
}
