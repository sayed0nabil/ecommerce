package com.arams.servlets;

import com.arams.beans.Product;
import com.arams.beans.User;
import com.arams.beans.UserProductCart;
import com.arams.db.dao.classes.ProductDao;
import com.arams.db.dao.classes.UserDao;
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
        String stringProductId = req.getParameter("productid");
        String stringUserId = req.getParameter("userid");
        if(stringProductId != null && stringUserId != null){
            try{
                int productId = Integer.parseInt(stringProductId);
                int userId = Integer.parseInt(stringUserId);
                UserProductCart deletedProductCart = UserProductCartDao.removeProductFromCart(productId, userId);
                if(deletedProductCart != null) {
                    req.getSession(true).setAttribute("mine", UserDao.getUser(((User)req.getSession(true).getAttribute("mine")).getId()));
                    res.sendRedirect("cart");
                } else res.sendRedirect("../main");
            }catch(NumberFormatException ex){
                res.sendRedirect("../main");
            }
        }else {
            res.sendRedirect("../main");
        }
    }
}
