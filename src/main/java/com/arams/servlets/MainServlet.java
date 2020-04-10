package com.arams.servlets;

import com.arams.beans.Category;
import com.arams.db.dao.classes.CategoryDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/main")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Category> categories = new CategoryDao().getAllCategories();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("main.jsp").include(req, res);
    }
}
