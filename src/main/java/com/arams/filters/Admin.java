package com.arams.filters;


import com.arams.beans.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Admin implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        User user = (User) req.getSession(true).getAttribute("mine");
        if(user != null && user.getAdmin() == 1){
            filterChain.doFilter(servletRequest, servletResponse);;
        }else{
            HttpServletResponse res = (HttpServletResponse)servletResponse;
            res.sendRedirect("../main");

        }
    }

    @Override
    public void destroy() {

    }
}
