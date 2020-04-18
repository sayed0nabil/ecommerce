package com.arams.servlets;

import com.arams.beans.Product;
import com.arams.beans.User;
import com.arams.beans.UserProductCart;
import com.arams.db.dao.classes.ProductDao;
import com.arams.db.dao.classes.UserDao;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import java.util.Set;

public class CartSubmission extends HttpServlet {
    static public String submitCart(HttpServletRequest request) {
        User currentUser = (User) request.getSession().getAttribute("mine");
        int userLimit = currentUser.getCreditLimit();
        Set<UserProductCart> userProductCarts = currentUser.getUserProductCarts();
        if(userProductCarts.size()==0){
            return "your cart is empty";
        }
        int cartPrice = 0;
        String result = "";
        for (UserProductCart cartProduct : userProductCarts) {
            if (cartProduct.getQuantity() <= cartProduct.getProduct().getQuantity()) {
                cartPrice += cartProduct.getQuantity() * cartProduct.getProduct().getPrice();
            } else {
                result = "there is no available quantity of " + cartProduct.getProduct().getName();
                return result;
            }
        }
        if (cartPrice > userLimit) {
            result = "you don't have money ";
        } else {
            for (UserProductCart cartProduct : userProductCarts) {
                Product product = cartProduct.getProduct();
                int quantity = product.getQuantity() - cartProduct.getQuantity();
                product.setQuantity(quantity);
                ProductDao.updateProduct(product);
            }
            userLimit = userLimit - cartPrice;
            currentUser.setCreditLimit(userLimit);
            UserDao.clearUserCart(currentUser);
            currentUser.getUserProductCarts().clear();
            UserDao.updateUser(currentUser);
            //System.out.println("submitted");
            result = "successfully submitted";
        }
        return result;
    }

}



