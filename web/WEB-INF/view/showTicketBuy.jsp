<%@ page import="com.maktab.domain.User" %>
<%@ page import="com.maktab.domain.UserTicket" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Hossein
  Date: 8/24/2022
  Time: 5:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/style.css">

</head>

<body>

<div class="c">
    <table class="margin-buy">
        <thead>
        <tr class="thead3">
            <th colspan="3"> &emsp; لیست بلیط های خریداری شده</th>
        </tr>


        </thead>

        <tbody>
        <tr>
            <th>تاریخ</th>
            <th>شناسه بلیط</th>
            <th>انتخاب</th>
        </tr>

        <%
            List<UserTicket> userTickets = (List<UserTicket>) request.getAttribute("listTicket");
            for (UserTicket ticket : userTickets
            ) {


        %>


        <tr>
            <td><%out.print(ticket.getTicketUser().getMoveDate());%></td>
            <td><%out.print(ticket.getTicketUser().getTicketCode());%></td>
            <td>


                <a href="/ticket/show-info-ticket?ticketId=<%out.print(ticket.getId());%>"> نماش بلیط</a>


            </td>
        </tr>
        <%
            }
        %>

        </tbody>

    </table>
</div>
</body>
</html>
