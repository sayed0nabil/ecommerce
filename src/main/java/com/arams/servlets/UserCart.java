package com.arams.servlets;

import com.arams.beans.User;
import com.arams.beans.UserProductCart;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet("/user/cart")
public class UserCart extends HttpServlet {

    /**
     * method to retrive the user product in his cart
     * and forward the request to usercart.jsp
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User currentUser = (User) request.getSession(true).getAttribute("mine");
        Set<UserProductCart> userProductCart = currentUser.getUserProductCarts();
        if (userProductCart != null) {
            request.setAttribute("userProductCart", userProductCart);
            RequestDispatcher dispatcher = request.getRequestDispatcher("../usercart.jsp");
            dispatcher.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double totalPrice = Double.parseDouble(req.getParameter("total"));
        String submitResponse = CartSubmission.submitCart(req, totalPrice);
        if (submitResponse != null)
            resp.getOutputStream().print(submitResponse);
        else {
            resp.getOutputStream().print("no response");
        }
    }

}
