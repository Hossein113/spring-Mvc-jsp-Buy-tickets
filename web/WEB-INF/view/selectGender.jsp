<%--
  Created by IntelliJ IDEA.
  User: Hossein
  Date: 8/23/2022
  Time: 11:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/style.css">
</head>

<body class="back">

<br>
<br>
<br>
<form action="/ticket/buy-ticket" method="post">
    <table align="center">
        <thead>
        </thead>

        <tbody>
        <tr>
            <label for="name"></label>
            <td><input class="size" type="text" id="name" name="name"></td>
            <td>: نام و نام خانوادگی</td>
        </tr>

        <tr>
            <td><input type="radio" name="gender" value="female">مرد<input type="radio" name="gender" value="male">زن
            </td>
            <td>: جنسیت</td>
        </tr>
        <tr>
            <td colspan="2"><input class="ok" type="submit" value="تایید"></td>
        </tr>

        </tbody>

    </table>
</form>
</body>
</html>
