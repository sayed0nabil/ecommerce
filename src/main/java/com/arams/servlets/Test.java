package com.arams.servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/test")
public class Test extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();

        //User user=UserDao.getUser(1);
        //List<User> allUsers=UserDao.getAllUser();
        //Gson gson = new Gson();
        //out.println(gson.toJson(user));
        //out.println(gson.toJson(allUsers, new TypeToken<List<User>>() {}.getType()));
    }
}
