package com.arams.filters;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        PrintWriter out = response.getWriter();
        Cookie ck[] = req.getCookies();
        if (ck == null) {
            if (req.getParameter("flag") == null) {
                Cookie cn = new Cookie("username", "alaa");
                res.addCookie(cn);
                res.sendRedirect(req.getRequestURI() + "?flag=true");
            } else {
                out.println("<label>");
                out.println("Please open your cookie!!");
                out.println("</label>");
            }

        } else {
            chain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {

    }

}
