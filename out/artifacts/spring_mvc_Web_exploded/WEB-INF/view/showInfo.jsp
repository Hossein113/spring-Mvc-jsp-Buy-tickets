<%@ page import="com.maktab.domain.UserTicket" %><%--
  Created by IntelliJ IDEA.
  User: Hossein
  Date: 8/24/2022
  Time: 3:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/style.css">

</head>
<body>
<%
    String ticketCode = (String) request.getAttribute("ticketCode");
    String ticket = (String) request.getAttribute("userTicket");
    String gender = (String) request.getAttribute("gender");
    String origin = (String) request.getAttribute("origin");
    String dest = (String) request.getAttribute("dest");
    String date = (String) request.getAttribute("date");
    String time = (String) request.getAttribute("time");
    String travelCode = (String) request.getAttribute("travelCode");


%>


<table align="center">
    <thead class="thead3">
    <tr>
        <th colspan="2">بلیط اتوبوس</th>
    </tr>
    </thead>

    <tbody>
    <tr>
        <td><%out.print(ticketCode);%></td>
        <td>شناسه بلیط</td>
    </tr>

    <tr>
        <td><%out.print(ticket);%></td>
        <td>نام</td>
    </tr>

    <tr>
        <td><%out.print(gender);%></td>
        <td>جنسیت</td>
    </tr>

    <tr>
        <td><%out.print(origin);%></td>
        <td>مبدا</td>
    </tr>

    <tr>
        <td><%out.print(dest);%></td>
        <td>مقصد</td>
    </tr>

    <tr>
        <td><%out.print(date);%></td>
        <td>تاریخ حرکت</td>
    </tr>

    <tr>
        <td><%out.print(time);%></td>
        <td>ساعت حرکت</td>
    </tr>

    <tr>
        <td><%out.print(travelCode);%></td>
        <td>شناسه سفر</td>
    </tr>


    </tbody>
    <tfoot class="thead3 ">
    <tr>


        <td colspan="2">
            <form action="/ticket/delet-ticket" method="post">
                <input name="ticketUser" type="hidden" value="<%out.print(request.getAttribute("ticket"));%>">
                <input class="ok" type="submit" value="لغو بلیط">
            </form>
        </td>
    </tr>
    </tfoot>

</table>

</body>
</html>
