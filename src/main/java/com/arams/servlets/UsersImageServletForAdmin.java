package com.arams.servlets;


import com.arams.beans.CreditCard;
import com.arams.beans.User;
import com.arams.db.dao.classes.CreditCardDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/admin/usersimages")
public class UsersImageServletForAdmin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usersImageDirectory
                = this.getServletConfig().getServletContext()
                .getInitParameter("user-image-directory");

        User currentUser = (User) request.getSession().getAttribute("mine");
        String userIDString = request.getParameter("userid");


        if (userIDString != null) {

            File imageFile = new File(usersImageDirectory
                    + userIDString);

            if (imageFile.exists()) {

                response.getOutputStream().write(new FileInputStream(imageFile).readAllBytes());

            } else {

                new File("user").mkdir();
                response.getOutputStream().write(new FileInputStream(new File(getServletContext()
                        .getRealPath("views/images/user.png")))
                        .readAllBytes());

            }

        } else {

            new File("user").mkdir();
            response.getOutputStream().write(new FileInputStream(new File(getServletContext()
                    .getRealPath("views/images/user.png")))
                    .readAllBytes());

        }

    }

}
