package com.arams.filters;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class User implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        com.arams.beans.User user = (com.arams.beans.User) req.getSession(true).getAttribute("mine");
        if(user != null && user.getAdmin() == 0){
            filterChain.doFilter(servletRequest, servletResponse);;
        }else{
            HttpServletResponse res = (HttpServletResponse)servletResponse;
            res.sendRedirect("../main");

        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
