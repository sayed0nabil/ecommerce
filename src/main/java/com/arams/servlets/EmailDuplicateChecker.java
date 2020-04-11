package com.arams.servlets;

import com.arams.beans.User;

import java.io.PrintWriter;
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

@WebServlet("/emailChecker")
public class EmailDuplicateChecker extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        User user = UserDao.getUserByEmail(email);
        if (user == null) {

            out.write("false");

        } else {

            out.write("true");

        }

    }

}