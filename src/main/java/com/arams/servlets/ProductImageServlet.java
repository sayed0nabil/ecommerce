package com.arams.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet(name = "ProductImageServlet", urlPatterns = {"/productImages"})

public class ProductImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext sc = getServletContext();
        String imageUrl = request.getParameter("image");
        FileInputStream fileInputStream
                = new FileInputStream("D:/ITI/WEB/products/" + imageUrl);

        OutputStream os = response.getOutputStream();
        if (fileInputStream == null) {
            response.setContentType("text/plain");
            os.write("Failed to send image".getBytes());
        } else {
            byte[] buffer = new byte[1024];
            int bytesRead;
            response.setContentType("image/png");
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        }
    }
}
