package com.arams.servlets;

import com.arams.beans.User;
import com.arams.db.dao.classes.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/admin/usersprofile")
public class AdminCustomersProfilesDispatcher extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        List<User> usersList = UserDao.getAllUser();
        req.setAttribute("users", usersList);
        req.getRequestDispatcher("../usersprofie.jsp").include(req, res);


    }
}
