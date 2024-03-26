package vn.edu.tdtu.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.tdtu.dao.UserDAO;
import vn.edu.tdtu.model.User;

import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private UserDAO user;

    public void init() {
        user = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        String fullname = request.getParameter("fullname");
        String repassword = request.getParameter("repassword");

        if (email == "" || password == "" || fullname == "" || repassword == "") {
            request.setAttribute("errorMessage", "Information is incomplete!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else if (user.existed(email) != null) {
            request.setAttribute("errorMessage", "This email has existed!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else if (password.length() < 6) {
            request.setAttribute("errorMessage", "Password must have at least 6 characters!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else if (!password.equals(repassword)) {
            request.setAttribute("errorMessage", "Confirm password didn't correct!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else {
            user.add(new User(fullname, email, password));
            request.getRequestDispatcher("/LoginServlet").forward(request, response);
        }
    }

}
