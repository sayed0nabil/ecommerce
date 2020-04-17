package com.arams.servlets;

import com.arams.beans.Product;
import com.arams.beans.ProductImage;
import com.arams.db.dao.classes.ProductDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductProfile", urlPatterns = {"/productprofile"})
public class ProductProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pId = request.getParameter("productId");
        if(pId!=null){
            int productId = Integer.parseInt(pId);
            Product product = ProductDao.getProductById(productId);
            request.setAttribute("product", product);
//            request.setAttribute("primaryImage" , product.getProductImages().iterator().next());
            RequestDispatcher rd
                    = request.getRequestDispatcher("productProfile.jsp");
            rd.forward(request, response);
        }
    }

}
