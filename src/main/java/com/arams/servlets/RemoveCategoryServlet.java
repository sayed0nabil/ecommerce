package com.arams.servlets;

import com.arams.beans.Product;
import com.arams.beans.UserProductCart;
import com.arams.db.dao.classes.ProductDao;
import com.arams.db.dao.classes.UserProductCartDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/admin/removecategory")
public class RemoveCategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String stringCategoryId = req.getParameter("categoryid");
        int status = 500;
        if(stringCategoryId != null){

            try{
                int categoryId = Integer.parseInt(stringCategoryId);
//                UserProductCart deletedCategory = CateogyrDao.deleteCategory(categoryId);
                if("deletedCategory" == null){
                    status = 404;
                }
                else {
                    status = 200;
                }
            }catch(NumberFormatException ex){
                status = 500;
            }
        }
        res.getWriter().println(status == 200 ? "success": "fail");
    }
}
