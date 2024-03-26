package vn.edu.tdtu.ex6;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("register.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String birthday = request.getParameter("birthday");
        String birthtime = request.getParameter("birthtime");
        String gender = request.getParameter("gender");
        String country = request.getParameter("country");
        String toeic = request.getParameter("toeic");
        String message = request.getParameter("message");

        String renderHTML;
        if (request.getParameterValues("favorite_ide") == null || name == "" || email == "" || birthday == "" || birthtime == "" || gender == "" || country == "" || message == "") {
            renderHTML = "<html><body><h2 style='color: red'>Bạn chưa nhập đủ thông tin! Vui lòng <a href='register.jsp'>nhập lại<a></h2></body></html>";
        }
        else {
            String[] favorite_ide = request.getParameterValues("favorite_ide");
            String list_ide = "";
            for (String ide : favorite_ide) {
                list_ide += ide + "<br>";
            }
            renderHTML = rederHTML(name,email,birthday,birthtime,gender,country,list_ide,toeic,message);
        }
        out.println(renderHTML);
    }

    private String rederHTML(String name, String email, String birthday, String birthtime, String gender, String country, String list_ide, String toeic, String message) {
        String html = "<html>" +
                "  <head>" +
                "    <style>" +
                "      table {" +
                "        font-family: arial, sans-serif;" +
                "        border-collapse: collapse;" +
                "        width: 100%;" +
                "      }" +
                "      td {" +
                "        border: 1px solid black;" +
                "        text-align: left;" +
                "        padding: 8px;" +
                "        text-align: center;" +
                "      }" +
                "      td:nth-child(odd) {" +
                "        color: blue;" +
                "      }" +
                "      td:nth-child(even) {" +
                "        color: green;" +
                "      }" +
                "    </style>" +
                "  </head>" +
                "  <body>" +
                "    <table>" +
                "      <tr>" +
                "        <td>Họ tên</td>" +
                "        <td> " + name + "</td>" +
                "      </tr>" +
                "      <tr>" +
                "        <td>Email</td>" +
                "        <td>" + email + " </td>" +
                "      </tr>" +
                "      <tr>" +
                "        <td>Ngày sinh</td>" +
                "        <td>" + birthday + " </td>" +
                "      </tr>" +
                "      <tr>" +
                "        <td>Giờ sinh</td>" +
                "        <td>" + birthtime + " </td>" +
                "      </tr>" +
                "      <tr>" +
                "        <td>Giới tính</td>" +
                "        <td>" + gender + "</td>" +
                "      </tr>" +
                "      <tr>" +
                "        <td>Quốc gia</td>" +
                "        <td>" + country + "</td>" +
                "      </tr>" +
                "      <tr>" +
                "        <td>IDE Yêu thích <br> <span style='color: red'>Hãy đảm bảo rằng các IDE bạn chọn đã hiển thị<span></td>" +
                "        <td>" + list_ide + "</td>" +
                "      </tr>" +
                "      <tr>" +
                "        <td>Điểm TOEIC</td>" +
                "        <td>" + toeic + "</td>" +
                "      </tr>" +
                "      <tr>" +
                "        <td>Giới thiệu bản thân</td>" +
                "        <td>" + message + "</td>" +
                "      </tr>" +
                "    </table>" +
                "  </body>" +
                "</html>";
        return html;
    }
}
