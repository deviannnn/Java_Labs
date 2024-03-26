package vn.edu.tdtu.ex5;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HomeServlet", value = "/")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String page = request.getParameter("page");
        if (page == null) {
            out.println("<h1>Welcome to our website</h1>");
            return;
        }
        switch (page) {
            case "about":
                forwardToPage("about.jsp", request, response);
                break;
            case "contact":
                forwardToPage("contact.jsp", request, response);
                break;
            case "help":
                forwardToPage("help.jsp", request, response);
                break;
            default:
                out.println("<h1>Welcome to our website</h1>");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);
    }

    private void forwardToPage(String page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }
}
