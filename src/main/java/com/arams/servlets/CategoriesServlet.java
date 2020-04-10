package com.arams.servlets;

import com.arams.beans.Category;
import com.arams.beans.Product;
import com.arams.db.connection.HibernateConnector;
import com.arams.db.dao.classes.CategoryDao;
import com.arams.db.dao.classes.ProductDao;
import com.arams.db.dao.interfaces.ICategoryDao;
import com.arams.db.dao.interfaces.IProductDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoriesServlet", urlPatterns = {"/newProduct"})
public class CategoriesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ICategoryDao categoryDao = new CategoryDao();
        List<Category> categoryList = categoryDao.getAllCategories();
        request.setAttribute("categories", categoryList);
        System.out.println(categoryList);
        RequestDispatcher rd
                = request.getRequestDispatcher("newproduct.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productName = request.getParameter("name");
        int productPrice =Integer.valueOf(request.getParameter("price")) ;
        int productQuantity = Integer.valueOf(request.getParameter("quantity"));
        String description = request.getParameter("description");
        int category = Integer.valueOf(request.getParameter("category"));
        System.out.println(category);
        Category productCategory = new Category();
        productCategory.setId(category);
        Product product = new Product(productCategory, productName, productPrice ,productQuantity);
        product.setDescription(description);
        ProductDao.addProduct(product);
        response.getWriter().print("done");
    }


}
