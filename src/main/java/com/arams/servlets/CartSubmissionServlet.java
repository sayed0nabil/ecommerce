package com.arams.servlets;

import com.arams.beans.Product;
import com.arams.beans.User;
import com.arams.beans.UserProductCart;
import com.arams.db.dao.classes.ProductDao;
import com.arams.db.dao.classes.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet(name = "CartSubmission", urlPatterns = {"/submitTest"})
public class CartSubmissionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        submitCart(request);
    }

    static public boolean submitCart(HttpServletRequest request) {
        User currentUser = (User) request.getSession().getAttribute("mine");
        int userLimit = currentUser.getCreditLimit();
        Set<UserProductCart> userProductCarts = currentUser.getUserProductCarts();
        //System.out.println(userProductCarts);
        int cartPrice = 0;
        boolean isValid = true;
        for (UserProductCart cartProduct : userProductCarts) {
            if (cartProduct.getQuantity() <= cartProduct.getProduct().getQuantity()) {
                cartPrice += cartProduct.getQuantity() * cartProduct.getProduct().getPrice();
                //System.out.println(cartPrice);
            } else {
                isValid = false;
            }
        }
        if (cartPrice > userLimit) {
            isValid = false;
            System.out.println("error");
        } else {
            for (UserProductCart cartProduct : userProductCarts) {
                Product product = cartProduct.getProduct();
                int quantity = product.getQuantity() - cartProduct.getQuantity();
                product.setQuantity(quantity);
                ProductDao.updateProduct(product);
            }
            userLimit = userLimit - cartPrice;
            currentUser.setCreditLimit(userLimit);
            UserDao.updateUser(currentUser);
            UserDao.clearUserCart(currentUser);
            System.out.println("submitted");
            isValid = true;
        }
        return isValid;
    }

}



