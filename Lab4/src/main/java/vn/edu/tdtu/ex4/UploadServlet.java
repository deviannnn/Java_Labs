package vn.edu.tdtu.ex4;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "UploadServlet", value = "/UploadServlet")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    private static final String ROOT_DIR = "T:\\YEAR3\\SEMESTER2\\JAVA\\ThucHanh\\Lab4\\src\\main\\resources\\uploads";
    private static final List<String> SUPPORTED_EXTENSIONS = Arrays.asList("txt", "doc", "docx", "img", "pdf", "rar", "zip");

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            // Create a multi-part configuration
            MultipartConfigElement multipartConfigElement = new MultipartConfigElement(ROOT_DIR);
            // Set the multi-part configuration for the request
            request.setAttribute("jakarta.servlet.multipartConfig", multipartConfigElement);

            // Get the form fields and uploaded file
            String fileName = request.getParameter("name");
            Part filePart = request.getPart("document");
            String overrideCheckbox = request.getParameter("override");

            // Get the file extension and check if it's supported
            String fileExtension = getFileExtension(filePart.getSubmittedFileName());
            if (!SUPPORTED_EXTENSIONS.contains(fileExtension)) {
                out.println("<h1 style='color: red'>Unsupported file extension</h1>");
                return;
            }

            // Check if a file with the same name already exists
            File file = new File(ROOT_DIR + File.separator + fileName + "." + fileExtension);
            if (file.exists() && overrideCheckbox == null) {
                out.println("<h1 style='color: red'>File already exists</h1>");
                return;
            }

            // If the file exists and the "override" checkbox is checked, delete the existing file
            if (file.exists() && overrideCheckbox != null) {
                file.delete();
            }

            // Save the file to the server
            filePart.write(ROOT_DIR + File.separator + fileName + "." + fileExtension);

            // Return a success message with a link to the uploaded file
            String downloadLink = "/download?file=" + fileName + "." + fileExtension + "&trigger=true";
            out.println("<h1 style='color: green'>File uploaded. Click <a href='" + downloadLink + "'>here</a> to visit file.</h1>");

        } catch (IOException | ServletException e) {
            out.println("<h1 style='color: red'>Unable to process file upload: " + e.getMessage() + "</h1>");
        }
    }

    private String getFileExtension(String fileName) {
        String extension = "";

        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i + 1);
        }

        return extension;
    }
}
