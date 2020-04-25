package com.arams.servlets;

import com.arams.beans.Category;
import com.arams.db.dao.classes.CategoryDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/addcategory")
public class AddingCategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryDao categoryDao = new CategoryDao();
        List<Category> categoryList = categoryDao.getAllCategories();
        req.setAttribute("categories", categoryList);
        RequestDispatcher rd = req.getRequestDispatcher("../newcategory.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = "";
        String categoryname = req.getParameter("category_name");
        if (categoryname != null && isPersist(categoryname)) {
            result = "This Category Already Exists";
            resp.getOutputStream().print(result);
        } else {
            Category category = new Category();
            category.setName(categoryname);
            CategoryDao.addCategory(category);
            result = "Category has been created successfully";
            resp.getOutputStream().print(result);
        }
    }

    private boolean isPersist(String categoeyName) {
        Category category = CategoryDao.getCategoryByName(categoeyName);
        if (category != null)
            return true;
        else
            return false;
    }
}
