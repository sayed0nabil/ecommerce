package com.arams.servlets;

import com.arams.beans.User;
import com.arams.db.dao.classes.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/images/users")
public class UserImageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usersImageDirectory
                = this.getServletConfig().getServletContext()
                .getInitParameter("user-image-directory");

        User currentUser = (User) request.getSession().getAttribute("mine");

        File imageFile = new File(usersImageDirectory
                + currentUser.getId());

        if (imageFile.exists()) {

            response.getOutputStream().write(new FileInputStream(imageFile).readAllBytes());

        } else {

            new File("user").mkdir();
            response.getOutputStream().write(new FileInputStream(new File(getServletContext()
                    .getRealPath("views/images/user.png")))
                    .readAllBytes());

        }

    }

}