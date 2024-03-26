package vn.edu.tdtu.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.tdtu.dao.ProductDAO;
import vn.edu.tdtu.model.Product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "IndexServlet", value = "/")
public class IndexServlet extends HttpServlet {
    private ProductDAO product;

    public void init() {
        product = new ProductDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loggedIn") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        String action = request.getServletPath();
        try {
            switch (action) {
                case "/insert":
                    insertProduct(request, response);
                    break;
                case "/delete":
                    deleteProduct(request, response);
                    break;
                case "/logout":
                    logout(request, response);
                    break;
                default:
                    listProduct(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Product> listProduct = product.readAll();
        request.setAttribute("listProduct", listProduct);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        if (name == "" || price == "") {
            request.setAttribute("errorMessage", "Information is incomplete!");
            listProduct(request, response);
        }
        else {
            product.insert(new Product(name, Integer.parseInt(price)));
            response.sendRedirect("list");
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        product.delete(id);
        response.sendRedirect("list");
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("loggedIn");
            session.invalidate();
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
