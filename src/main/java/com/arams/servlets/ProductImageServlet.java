package com.arams.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "ProductImageServlet", urlPatterns = {"/productImages"})

public class ProductImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String imageNumber = request.getParameter("imageNumber");
        String productID = request.getParameter("productID");

        String usersImageDirectory
                = this.getServletConfig().getServletContext()
                .getInitParameter("product-image-directory");

        System.out.println(usersImageDirectory
                + productID + "-" + imageNumber);

        File imageFile = new File(usersImageDirectory
                + productID + "-" + imageNumber);

        if (imageFile.exists()) {

            response.getOutputStream().write(new FileInputStream(imageFile).readAllBytes());

        } else {

            new File("user").mkdir();
            response.getOutputStream().write(new FileInputStream(new File(getServletContext()
                    .getRealPath("views/images/product.png")))
                    .readAllBytes());

        }


    }
}
