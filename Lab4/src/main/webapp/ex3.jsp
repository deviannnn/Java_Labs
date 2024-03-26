<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2/26/2023
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manage Product</title>
</head>
<body>
    <div style="display: flex; flex-wrap: wrap">
        <div>
            <h1 style="color: coral">Test doGet</h1>
            <form action="ProductServlet" method="GET">
                <label for="id1">ID:</label><br>
                <input type="text" id="id1" name="id"><br><br>
                <input type="submit" value="Get Product">
            </form>
            <form action="ProductServlet" method="GET">
                <input type="submit" value="Get All Product">
            </form>
        </div>

        <div style="margin-left: 7%">
            <h1 style="color: darkslateblue">Test doPost Method</h1>
            <form action="ProductServlet" method="POST">
                <label for="id2">ID:</label><br>
                <input type="text" id="id2" name="id"><br>
                <label for="name2">Name:</label><br>
                <input type="text" id="name2" name="name"><br>
                <label for="price2">Price:</label><br>
                <input type="text" id="price2" name="price"><br><br>
                <button type="submit">Add Product</button>
            </form>
        </div>

        <div style="margin-left: 7%">
            <h1 style="color: dodgerblue">Test doPut Method</h1>
            <form action="ProductServlet" method="POST">
                <input type="hidden" name="_method" value="PUT">
                <label for="id3">ID:</label><br>
                <input type="text" id="id3" name="id"><br>
                <label for="name3">Name:</label><br>
                <input type="text" id="name3" name="name"><br>
                <label for="price3">Price:</label><br>
                <input type="text" id="price3" name="price"><br><br>
                <input type="submit" value="Update Product">
            </form>
        </div>

        <div style="margin-left: 7%">
            <h1 style="color: lightgreen">Test doDelete Method</h1>
            <form action="ProductServlet" method="POST">
                <input type="hidden" name="_method" value="DELETE">
                <label for="id4">ID:</label><br>
                <input type="text" id="id4" name="id"><br><br>
                <input type="submit" value="Delete Product">
            </form>
        </div>
    </div>
</body>
</html>
