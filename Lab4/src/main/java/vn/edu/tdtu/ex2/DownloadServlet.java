package vn.edu.tdtu.ex2;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;
import java.net.URLEncoder;

@WebServlet(name = "DownloadServlet", value = "/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String fileName = request.getParameter("file");

        // Check if file name is provided
        if (fileName == null || fileName.trim().isEmpty()) {
            PrintWriter printOut = response.getWriter();
            printOut.println("<html><body>");
            printOut.println("<h2 style='color: red'>File not found</h2>");
            printOut.println("</body></html>");
            return;
        }


        // Check trigger download when click the link "here" from Exercise 4
        InputStream in;
        String trigger = request.getParameter("trigger");
        if (trigger != null) {
            in = this.getClass().getResourceAsStream("/uploads/" + fileName);
        }
        else {
            in = this.getClass().getResourceAsStream("/" + fileName);
        }

        // Check if file exists
        if (in == null) {
            PrintWriter printOut = response.getWriter();
            printOut.println("<html><body>");
            printOut.println("<h2 style='color: orange'>Sorry, this file is not available!</h2>");
            printOut.println("</body></html>");
            return;
        }

        // Set response headers
        OutputStream out = response.getOutputStream();
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        // Set download speed if provided
        String speed = request.getParameter("speed");
        if (speed != null && !speed.trim().isEmpty()) {
            int kbPerSecond = Integer.parseInt(speed) * 1024;
            response.setBufferSize(kbPerSecond);
        }

        // Write file to response
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
            out.flush();
            if (speed != null && !speed.trim().isEmpty()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        in.close();
        out.close();
    }
}
