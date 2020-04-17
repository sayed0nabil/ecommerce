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


@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        String limit = req.getParameter("limit");
        PrintWriter out = res.getWriter();
        if(limit == null){
            List<Product> productsResult = ProductDao.searchProductByLimit(keyword, false);
            String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(productsResult);
            out.write(json);
        }else{
            if(keyword == null){
                out.println("[]");
            }else{
                List<Product> productsResult = ProductDao.searchProductByLimit(keyword, true);
                String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(productsResult);
                out.write(json);
            }
        }
    }
}
