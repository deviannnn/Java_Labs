<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2/27/2023
  Time: 10:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Register Ex6</title>
    <style>
        input, select, textarea {
            box-sizing: border-box;
        }
        input[type="text"], select {
            height: 24px;
        }
        td {
            padding: 4px;
        }
    </style>
</head>
<body>
<form method="post" action="RegisterServlet">
    <table>
        <tr>
            <td>Your Name</td>
            <td>
                <input name="name" type="text" style="width: 200px" placeholder="Full Name">
            </td>
        </tr>
        <tr>
            <td>Email Address</td>
            <td><input name="email" type="text" style="width: 200px" placeholder="Email"></td>
        </tr>
        <tr>
            <td>Birthday</td>
            <td><input name="birthday" type="date" style="width: 200px"></td>
        </tr>
        <tr>
            <td>Birthtime</td>
            <td><input name="birthtime" type="time" style="width: 200px"></td>
        </tr>
        <tr>
            <td>Gender</td>
            <td>
                <input type="radio" value="male" name="gender"> Male
                <input type="radio" value="female" name="gender"> Female
            </td>
        </tr>
        <tr>
            <td>From</td>
            <td>
                <select name="country" style="width: 200px">
                    <option value="">Select a country</option>
                    <optgroup label="Asia">
                        <option>Vietnam</option>
                        <option>Laos</option>
                        <option>Cambodia</option>
                        <option>Singapore</option>
                    </optgroup>
                    <optgroup label="Europe">
                        <option>France</option>
                        <option>Belgium</option>
                        <option>Italy</option>
                        <option>Finland</option>
                        <option>Ireland</option>
                    </optgroup>
                </select>
            </td>
        </tr>
        <tr>
            <td style="vertical-align: text-top">Favorite IDE</td>
            <td>
                <div><input type="checkbox" name="favorite_ide" value="Visual Studio Code"> Visual Studio Code</div>
                <div><input type="checkbox" name="favorite_ide" value="Sublime Text"> Sublime Text</div>
                <div><input type="checkbox" name="favorite_ide" value="Eclipse"> Eclipse</div>
                <div><input type="checkbox" name="favorite_ide" value="Atom"> Atom</div>
                <div><input type="checkbox" name="favorite_ide" value="Intelij Idea"> Intelij Idea</div>
            </td>
        </tr>
        <tr>
            <td>TOEIC Score</td>
            <td><input name="toeic" type="range" style="width: 200px" min="5" max="990" step="5"></td>
        </tr>
        <tr>
            <td style="vertical-align: text-top">Message</td>
            <td>
                <textarea name="message" rows="5" style="width: 200px"></textarea>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button>Register</button>
                <button><a href="register.jsp">Again</a></button>
            </td>
        </tr>


    </table>
</form>
</body>
</html>
