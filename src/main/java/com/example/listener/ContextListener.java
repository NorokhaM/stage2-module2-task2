package com.example.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.*;
import java.time.LocalDateTime;

public class ContextListener extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        ServletContext context = getServletContext();
        context.setAttribute("ServletTimeInit", LocalDateTime.now());
    }
}
