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


@WebServlet("/user/removecart")
public class RemoveProductCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String stringProductCartId = req.getParameter("cartid");
        int status = 500;
        if(stringProductCartId != null){

            try{
                int productCartId = Integer.parseInt(stringProductCartId);
                UserProductCart deletedProductCart = UserProductCartDao.deleteProductToCart(productCartId);
                if(deletedProductCart == null){
                    status = 404;
                }
                else {
                    status = 200;
                }
            }catch(NumberFormatException ex){
                status = 500;
            }
        }
        res.getWriter().println("{\"status\": " + status +"}");
    }
}
