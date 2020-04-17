package com.arams.servlets;

import com.arams.beans.User;
import com.arams.db.dao.classes.UserDao;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/userProfile")
public class UserProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User currentUser = (User) request.getSession().getAttribute("mine");

        ObjectMapper mapper = new ObjectMapper();

        String jsonObject = mapper.writeValueAsString(currentUser);

        response.getWriter().write(jsonObject);


    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

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
            UserDao.updateUser(user);

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
        response.sendRedirect("customerProfile.html");
    }

    private User setUserData(HttpServletRequest request) {

        User loggedInUser = (User) request.getSession().getAttribute("mine");
        try {

            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

            loggedInUser.setBirthDate(dateFormat.parse((String) request.getAttribute("BirthDate")));
            loggedInUser.setFirstName((String) request.getAttribute("FirstName"));
            loggedInUser.setLastName((String) request.getAttribute("LastName"));
            loggedInUser.setEmail((String) request.getAttribute("Email"));
            loggedInUser.setId(loggedInUser.getId());//Integer.parseInt((String)request.getAttribute("id"))


        } catch (ParseException e) {
            e.printStackTrace();
        }

        return loggedInUser;

    }

}