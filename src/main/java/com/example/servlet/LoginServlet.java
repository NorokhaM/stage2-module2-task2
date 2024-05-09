package com.example.servlet;

import com.example.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session= request.getSession();
        if (session.getAttribute("name")!=null){
            try{
                response.sendRedirect("/user/hello.jsp");
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            try{
                response.sendRedirect("/user/login.jsp");
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("login");
        String password = req.getParameter("password");
        if(user == null || !Users.getInstance().getUsers().contains(user) || password == null || password.isEmpty()) {
            req.getRequestDispatcher("/user/login.jsp").forward(req, resp);
        }
        else {
            req.getSession().setAttribute("user", "user");
            resp.sendRedirect("/user/hello.jsp");
        }
    }
}
