package vn.edu.tdtu.ex1;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private HashMap<String, String> accounts = new HashMap<String, String>();;

    public void init() throws ServletException {
        super.init();
        accounts.put("browser1", "qwertyuiop");
        accounts.put("browser2", "asdfghjkl");
        accounts.put("browser3", "zxcvbnm");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (accounts.containsKey(username) && accounts.get(username).equals(password)) {
            out.println("<html><body>");
            out.println("<h2>Name/Password match</h2>");
            out.println("</body></html>");
        } else {
            out.println("<html><body>");
            out.println("<h2>Name/Password does not match</h2>");
            out.println("</body></html>");
        }
    }
}
