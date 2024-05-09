package com.example.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;

@WebFilter(urlPatterns = {"/user/*"})
public class AuthFilter extends HttpFilter{
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            try {
                response.sendRedirect("/login.jsp");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                chain.doFilter(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}