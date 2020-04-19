package com.arams.servlets;

import com.arams.beans.Product;
import com.arams.db.dao.classes.ProductDao;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/searchproducts")
public class GetSearchedProductsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        if(keyword != null) {
            List<Product> productsResult = ProductDao.searchProductByLimit(keyword, false);
            req.setAttribute("products", productsResult);
            req.getRequestDispatcher("products.jsp").forward(req, res);
        }
        else res.sendRedirect("main.jsp");

    }
}
