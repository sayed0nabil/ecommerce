package com.arams.servlets;


import com.arams.beans.Product;
import com.arams.db.dao.classes.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/removeproduct")
public class RemoveProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String stringProductId = req.getParameter("productid");
        if(stringProductId == null){

        }else{
            int status = 500;
            try{
                int productId = Integer.parseInt(stringProductId);
                Product deletedProduct = ProductDao.deleteProduct(productId);
                if(deletedProduct == null){
                    status = 404;
                }
                else {
                    status = 200;
                }
            }catch(NumberFormatException ex){
                status = 500;
            }
            req.getRequestDispatcher("../responsemessage.jsp?status=" + status).include(req, res);
        }
    }
}
