package com.arams.servlets;

import com.arams.beans.User;

import java.nio.file.Paths;
import java.text.DateFormat;

import com.arams.db.dao.classes.UserDao;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        FileItem imageFile = null;

        DiskFileItemFactory factory = new DiskFileItemFactory();
        String usersImageDirectory
                = this.getServletConfig().getServletContext()
                .getInitParameter("user-image-directory");

        ServletFileUpload uploadHandler = new ServletFileUpload(factory);

        try {

            List<FileItem> files = uploadHandler.parseRequest(request);
            for (int i = 0; i < files.size(); i++) {

                FileItem fileItem = files.get(i);

                if (fileItem.isFormField()) {

                    request.setAttribute(fileItem.getFieldName(), fileItem.getString());

                } else {

                    imageFile = fileItem;

                }

            }

            User user = setUserData(request);
            UserDao.addUser(user);

            if (imageFile.getSize() != 0) {
                new File(usersImageDirectory).mkdirs();
                File newFile = new File(usersImageDirectory + user.getId());
                newFile.createNewFile();
                imageFile.write(newFile);

            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private User setUserData(HttpServletRequest request) {

        User user = new User();
        try {

            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

            user.setAdmin((byte) 0);
            user.setBirthDate(dateFormat.parse((String) request.getAttribute("birth_date")));
            user.setCreditLimit(0);
            user.setFirstName((String) request.getAttribute("first_name"));
            user.setLastName((String) request.getAttribute("last_name"));
            user.setPassword((String) request.getAttribute("password"));
            user.setEmail((String) request.getAttribute("email"));


        } catch (ParseException e) {
            e.printStackTrace();
        }

        return user;

    }
}