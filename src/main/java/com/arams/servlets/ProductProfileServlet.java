package com.arams.servlets;

import com.arams.beans.Product;
import com.arams.beans.User;
import com.arams.beans.UserProductCart;
import com.arams.beans.UserProductCartId;
import com.arams.db.dao.classes.ProductDao;
import com.arams.db.dao.classes.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet(name = "ProductProfile", urlPatterns = {"/productprofile"})
public class ProductProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pId = request.getParameter("productId");
        if (pId != null) {
            int productId = Integer.parseInt(pId);
            Product product = ProductDao.getProductById(productId);
            request.setAttribute("product", product);
//            request.setAttribute("primaryImage" , product.getProductImages().iterator().next());
            RequestDispatcher rd
                    = request.getRequestDispatcher("productProfile.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User loggedIn = (User) request.getSession().getAttribute("mine");

        String productId = request.getParameter("productId");
        String Quantity = request.getParameter("quantity");
        if (productId != null) {
            int userId = loggedIn.getId();
            System.out.println(userId);
            int productID = Integer.parseInt(productId);
            System.out.println(productID);
            int qty = Integer.parseInt(Quantity);
            Product product = ProductDao.getProductById(productID);
            UserProductCartId userProductCartId = new UserProductCartId(userId, productID);
            UserProductCart userProductCart = new UserProductCart(userProductCartId, product, loggedIn, qty);
            Set<UserProductCart> userProductCartSet = loggedIn.getUserProductCarts();
            if (userProductCartSet != null) {
                userProductCartSet.add(userProductCart);
                UserDao.updateUser(loggedIn);
            }

        }
    }

}
