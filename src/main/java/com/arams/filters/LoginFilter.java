package com.arams.filters;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.arams.beans.Category;
import com.arams.db.dao.classes.CategoryDao;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

            Cookie ck[] = req.getCookies();
            if (ck == null) {
                if (req.getParameter("flag") == null) {
                    Cookie cn = new Cookie("username", "alaa");
                    res.addCookie(cn);
                    res.sendRedirect(req.getRequestURI() + "?flag=true");
                } else {
                    PrintWriter out = response.getWriter();
                    out.println("<label>");
                    out.println("Please open your cookie!!");
                    out.println("</label>");
                    out.flush();
                    out.close();
                }

            } else {
                List<Category> categories = new CategoryDao().getAllCategories();
                request.setAttribute("categories", categories);
                chain.doFilter(request, response);
            }
    }

    @Override
    public void destroy() {

    }

}
