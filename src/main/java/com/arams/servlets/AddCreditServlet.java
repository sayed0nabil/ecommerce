package com.arams.servlets;


import com.arams.beans.CreditCard;
import com.arams.db.dao.classes.CreditCardDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/admin/addcredit")
public class AddCreditServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<CreditCard> credits = CreditCardDao.getAllCredits();
        req.setAttribute("credits", credits);
        req.getRequestDispatcher("/addcredit.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String stringCode = req.getParameter("code");
        String stringLimit = req.getParameter("limit");
        PrintWriter out = res.getWriter();
        if(stringCode != null && stringLimit != null){
            try {
                int code = Integer.parseInt(stringCode);
                int limit = Integer.parseInt(stringLimit);
                CreditCard creditCard = new CreditCard(code, limit, 0);
                CreditCard newCreditCard = CreditCardDao.addCard(creditCard);
                if(newCreditCard != null)
                    out.write("success");
                else out.write("Credit Code Already Exist");

            }catch (NumberFormatException ex){
                out.write("Code & limit Must Be In Numbers");
            }
        }else{
            out.write("Code And Limit Must Be Not Null");
        }

    }
}
