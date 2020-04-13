package com.arams.servlets;

import com.arams.beans.CreditCard;
import com.arams.beans.User;
import com.arams.db.dao.classes.CreditCardDao;
import com.arams.db.dao.classes.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CreditLimitServlet")
public class CreditLimitServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String creditCode = request.getParameter("creditlimit");
        User currentUser = (User) request.getSession().getAttribute("mine");
        PrintWriter out = response.getWriter();
        int code = 0;

        try {

            code = Integer.parseInt(creditCode);

        } catch (NumberFormatException e) {

            out.write("0");

        }

        CreditCard card = CreditCardDao.getCardByCode(code);

        if (card == null) {

            out.write("0");

        } else if (card.getUsed() == (byte) 1) {

            out.write("1");

        } else {

            card.setUsed((byte) 1);
            currentUser.setCreditLimit((currentUser.getCreditLimit() + card.getLimit()));
            CreditCardDao.updateCard(card);
            UserDao.updateUser(currentUser);
            out.write("2");

        }
    }
}
