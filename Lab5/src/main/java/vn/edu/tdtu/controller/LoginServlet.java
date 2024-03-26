package vn.edu.tdtu.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.tdtu.dao.UserDAO;
import vn.edu.tdtu.model.User;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private UserDAO user;

    public void init() {
        user = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("rememberMe")) {
                    String[] userInfo = cookie.getValue().split(":");
                    String email = userInfo[0];
                    String password = userInfo[1];
                    User loginUser = user.validate(email, password);
                    if (loginUser != null) {
                        HttpSession session = request.getSession();
                        session.setAttribute("loggedIn", loginUser.getFullname());
                        response.sendRedirect("list");
                        return;
                    }
                }
            }
        }
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("loggedIn") != null) {
            // User is logged in
            response.sendRedirect("list");
        } else {
            // User is not logged in
            response.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        boolean rememberMe = "on".equals(request.getParameter("remember"));

        User loginUser = user.validate(email, password);

        if (email == "" || password == "") {
            request.setAttribute("errorMessage", "Information is incomplete!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else if (loginUser == null) {
            request.setAttribute("errorMessage", "Invalid username or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            if (rememberMe) {
                Cookie cookie = new Cookie("rememberMe", email + ":" + password);
                cookie.setMaxAge(30 * 24 * 60 * 60); // 30 days
                response.addCookie(cookie);
            }
            HttpSession session = request.getSession();
            session.setAttribute("loggedIn", loginUser.getFullname());
            response.sendRedirect("list");
        }
    }

}
