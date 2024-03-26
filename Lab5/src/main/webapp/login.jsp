<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String loggedIn = (String) session.getAttribute("loggedIn");
    if (loggedIn != null) {
        response.sendRedirect("index.jsp");
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6 col-lg-5">
            <h3 class="text-center text-secondary mt-5 mb-3">User Login</h3>
            <form class="border rounded w-100 mb-5 mx-auto px-3 pt-3 bg-light" method="post" action="LoginServlet">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input id="username" type="text" class="form-control" placeholder="Username (email)" name="email">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input id="password" type="password" class="form-control" placeholder="Password" name="password">
                </div>
                <div class="form-group">
                    <input id="remember" type="checkbox" name="remember" value="on">
                    <label for="remember">Remember username & password</label>
                </div>
                <div class="form-group">
                    <button class="btn btn-success px-5" type="submit">Login</button>
                </div>
                <c:if test="${not empty errorMessage}">
                    <div class="alert alert-danger" role="alert">${errorMessage}</div>
                </c:if>
                <div class="form-group">
                    Don't have an account? <a href="register.jsp">Register now</a>
                </div>
            </form>

        </div>
    </div>
</div>

</body>
</html>

