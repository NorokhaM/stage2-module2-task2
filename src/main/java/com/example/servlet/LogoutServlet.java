package com.example.servlet;
import com.example.Users;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
    protected void destroy(HttpServletRequest request, HttpServletResponse response){
        HttpSession session=request.getSession();
        session.removeAttribute("user");
        session.invalidate();
        try{
            response.sendRedirect("/user/login.jsp");
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
