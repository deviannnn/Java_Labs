package org.example;

import java.sql.*;
import java.util.ArrayList;

public class ProductDAO implements Repository<Product, Integer> {
    public static ProductDAO getInstance() {
        return new ProductDAO();
    }
    public static Connection getConnectionn(){

        Connection con=null;
        try {
            //Đăng ký MySQL
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            //Các thông số
            String url="jdbc:mysql://localhost:3306/productmanagement";
            String username="root";
            String password="";

            //Tạo kết nối
            con=DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return con;

    }

    public static void closeConnection(Connection con) {
        try {
            if(con!=null) {
                con.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public Integer add(Product item) {
        try {
            Connection con = getConnectionn();

            String query = "INSERT INTO product (name, price, color) VALUES (?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, item.getName());
            statement.setInt(2, item.getPrice());
            statement.setString(3, item.getColor());

            int rowsAffected = statement.executeUpdate();

            System.out.println("Add product success");

            closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public ArrayList<Product> readAll() {
        ArrayList<Product> p = new ArrayList<>();
        try
        {
            Connection con = getConnectionn();
            Statement st = con.createStatement();

            ResultSet resultSet = st.executeQuery("SELECT * FROM product");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                String color = resultSet.getString("color");
                p.add(new Product(id, name, price, color));
            }

            closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public Product read(Integer id) {
        Product p = null;
        try
        {
            Connection con = getConnectionn();
            String query = "SELECT * FROM product WHERE id = ?";
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, id);

            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                p = new Product();
                p.setId(resultSet.getInt("id"));
                p.setName(resultSet.getString("name"));
                p.setPrice(resultSet.getInt("price"));
                p.setColor(resultSet.getString("color"));
            }

            closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public boolean update(Product item) {
        boolean success = false;
        try {
            Connection con = getConnectionn();

            String query = "UPDATE product SET name=?, price=?, color=? WHERE id=?";
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, item.getName());
            st.setInt(2, item.getPrice());
            st.setString(3, item.getColor());
            st.setInt(4, item.getId());

            int rowsAffected = st.executeUpdate();

            System.out.println("Update product success");

            closeConnection(con);
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    @Override
    public boolean delete(Integer id) {
        boolean success = false;
        try {
            Connection con = getConnectionn();

            String query = "DELETE FROM product WHERE id=?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, id);

            int rowsAffected = statement.executeUpdate();

            System.out.println("Delete product success");

            closeConnection(con);
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }
}
