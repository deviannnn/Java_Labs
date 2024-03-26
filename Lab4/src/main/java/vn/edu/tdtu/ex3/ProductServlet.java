package vn.edu.tdtu.ex3;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.GsonBuilder;


@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static List<Product> productList = new ArrayList<>();

    public void init() throws ServletException {
        super.init();
        productList.add(new Product(1, "iPhone 11", 186));
        productList.add(new Product(2, "iPhone 12 Pro", 267));
        productList.add(new Product(3, "iPhone 14", 398));
        productList.add(new Product(4, "Samsung Galaxy S22 Ultra", 357));
        productList.add(new Product(5, "Oppo Reno X 5G", 299));
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        String idParam = request.getParameter("id");

        if (idParam == null) {
            // Return all products
            Response<List<Product>> responseObject = new Response<>(0, "Đọc sản phẩm thành công", productList);
            String jsonResponse = gson.toJson(responseObject);
            response.getWriter().write(jsonResponse);
            return;
        }

        // Validate the input
        String validateString = validateInput(idParam);
        if (validateString != "") {
            response.getWriter().write(validateString);
            return;
        }

        int id = Integer.parseInt(idParam);

        // Return a product by id
        Product product = getProductById(id);
        if (product != null) {
            Response<Product> responseObject = new Response<>(0, "Đọc sản phẩm thành công", product);
            String jsonResponse = gson.toJson(responseObject);
            response.getWriter().write(jsonResponse);
        } else {
            Response<Object> responseObject = new Response<>(2, "Không tìm thấy sản phẩm nào với mã số " + id, null);
            String jsonResponse = gson.toJson(responseObject);
            response.getWriter().write(jsonResponse);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Trigger for method doPut() & doDelete()
        String method = request.getParameter("_method");
        if ("PUT".equals(method)) {
            doPut(request, response);
            return;
        } else if ("DELETE".equals(method)) {
            doDelete(request, response);
            return;
        }
        // -------------------------------------------------

        response.setContentType("application/json;charset=UTF-8");
        String idParam = request.getParameter("id");
        String name = request.getParameter("name");
        String priceParam = request.getParameter("price");

        // Validate the input
        String validateString = validateInput(idParam,name,priceParam);
        if (validateString != "") {
            response.getWriter().write(validateString);
            return;
        }

        int id = Integer.parseInt(idParam);
        int price = Integer.parseInt(priceParam);

        if (getProductById(id) != null) {
            String jsonResponse = gson.toJson(new Response(2, "Mã sản phẩm đã tồn tại", null));
            response.getWriter().write(jsonResponse);
            return;
        }

        // Add the new product to the list
        Product newProduct = new Product(id, name, price);
        productList.add(newProduct);

        // Return the newly added product
        String jsonResponse = gson.toJson(new Response(0, "Thêm sản phẩm thành công", newProduct));
        response.getWriter().write(jsonResponse);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        String idParam = request.getParameter("id");
        String name = request.getParameter("name");
        String priceParam = request.getParameter("price");

        // Validate the input
        String validateString = validateInput(idParam,name,priceParam);
        if (validateString != "") {
            response.getWriter().write(validateString);
            return;
        }

        int id = Integer.parseInt(idParam);
        int price = Integer.parseInt(priceParam);
        Product updatedProduct = getProductById(id);

        if (updatedProduct == null) {
            Response<Object> responseObject = new Response<>(2, "Không tìm thấy sản phẩm nào với mã số " + id, null);
            String jsonResponse = gson.toJson(responseObject);
            response.getWriter().write(jsonResponse);
            return;
        }

        // Update the product's information
        updatedProduct.setName(name);
        updatedProduct.setPrice(price);

        // Return the newly updated product
        String jsonResponse = gson.toJson(new Response(0, "Cập nhật sản phẩm thành công", updatedProduct));
        response.getWriter().write(jsonResponse);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        String idParam = request.getParameter("id");

        String validateString = validateInput(idParam);
        if (validateString != "") {
            response.getWriter().write(validateString);
            return;
        }

        int id = Integer.parseInt(idParam);

        Product deletedProduct = getProductById(id);
        if (deletedProduct != null) {
            productList.remove(deletedProduct);
            String jsonResponse = gson.toJson(new Response(0, "Xóa sản phẩm thành công", null));
            response.getWriter().write(jsonResponse);
        } else {
            String jsonResponse = gson.toJson(new Response(2, "Không tìm thấy sản phẩm nào với mã số " + id, null));
            response.getWriter().write(jsonResponse);
        }

    }

    private Product getProductById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    private static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static String validateInput(String idParam, String name, String priceParam) {
        String jsonResponse = "";
        if (!isNumeric(priceParam)) {
            jsonResponse = gson.toJson(new Response(1, "Giá sản phẩm không hợp lệ", null));
        }
        if (name == "") {
            jsonResponse = gson.toJson(new Response(1, "Tên sản phẩm không hợp lệ", null));
        }
        if (!isNumeric(idParam)) {
            jsonResponse = gson.toJson(new Response(1, "Mã sản phẩm không hợp lệ", null));
        }
        return jsonResponse;
    }

    private static String validateInput(String idParam) {
        String jsonResponse = "";
        if (!isNumeric(idParam)) {
            jsonResponse = gson.toJson(new Response(1, "Mã sản phẩm không hợp lệ", null));
        }
        return jsonResponse;
    }
}
