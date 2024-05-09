package com.example.servlet;

import com.example.Users;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session= request.getSession();
        if (session.getAttribute("name")==null){
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String login=request.getParameter("login");
        String password=request.getParameter("password");
        if (login==null || !Users.getInstance().getUsers().contains(login) || password==null || password.isEmpty()){
            try{
                request.getRequestDispatcher("/user/login.jsp").forward(request, response);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        else{
            HttpSession session=request.getSession();
            session.setAttribute("user", "user");
            try{
                response.sendRedirect("/user/hello.jsp");
            } catch(Exception e){
                e.printStackTrace();
            }
        }

    }
}
