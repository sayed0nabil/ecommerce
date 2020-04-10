package com.arams.servlets;

import com.arams.beans.User;
import com.arams.db.dao.classes.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/regestration")
public class RegestrationServlet extends HttpServlet {

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            response.setContentType("text/html");
//            RequestDispatcher dispatcher=request.getRequestDispatcher("regeterform.html");
//            dispatcher.forward(request,response);
//    }

        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            response.setContentType("text/html");
//            RequestDispatcher dispatcher=request.getRequestDispatcher("regeterform.html");
//            dispatcher.forward(request,response);
        String fName=request.getParameter("first_name");
        String lName=request.getParameter("last_name");
        String email=request.getParameter("email");
        String password=request.getParameter(" pass");
        int credite= Integer.parseInt(request.getParameter("credite"));
        System.out.println(credite+"****"+fName+"***"+lName+"****"+email+"****"+password);
        User user=new User();
        user.setCreditLimit(credite);
        user.setFirstName(fName);
        user.setLastName(lName);
        user.setEmail(email);
        user.setPassword(password);
        user.setAdmin((byte)0);


//        User user=new User();
//        user.setCreditLimit(20000);
//        user.setFirstName("maro");
//        user.setLastName("tocom");
//        user.setEmail("maro@gmail.com");
//        user.setPassword("579865");
//        user.setAdmin((byte)0);
//
        UserDao.addUser(user);
        response.getWriter().write("user regesterd successfully");

    }
}