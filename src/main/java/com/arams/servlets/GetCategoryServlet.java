package com.arams.servlets;

import com.arams.db.dao.classes.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/category")
public class GetCategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String categoryName = req.getParameter("categoryname");
        if(categoryName != null) {
            req.setAttribute("products", ProductDao.getProductsByCategory(categoryName));
            req.getRequestDispatcher("products.jsp").forward(req, res);
        }else res.sendRedirect("main.jsp");
    }
}
