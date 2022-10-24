<%@ page import="java.util.List" %>
<%@ page import="com.maktab.domain.Ticket" %><%--
  Created by IntelliJ IDEA.
  User: Hossein
  Date: 8/22/2022
  Time: 6:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>


<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/style.css">


</head>
<body class="back">

<div class="div1">
    <form action="/ticket/search-ticket" method="post">
        <input class="search-box" type="submit" value="جستجوی آنلاین">
        <input class="data-box" type="date" name="date">
        <label for="dist"></label>
        <select dir="rtl" class="loc-box" id="dist" name="dist">

            <option>لطفا مقصد را وارد نمایید</option>
            <option value="tehran" name="dist">تهران</option>
            <option value="mashhad" name="dist">مشهد</option>
            <option value="qom" name="dist">قم</option>
            <option value="arak" name="dist">اراک</option>
            <option value="esfahan" name="dist">اصفهان</option>
            <option value="shiraz" name="dist">شیراز</option>

        </select>
        <label for="origin"></label>
        <select dir="rtl" class="loc-box" id="origin" name="origin">
            <option>لطفا مبدا را وارد نمایید</option>
            <option value="tehran">تهران</option>
            <option value="mashhad">مشهد</option>
            <option value="qom">قم</option>
            <option value="arak">اراک</option>
            <option value="esfahan">اصفهان</option>
            <option value="shiraz">شیراز</option>

        </select>
    </form>
</div>

<% String notFind = (String) request.getAttribute("nofind");
    if (notFind != null) {
        notFind = "موردی یافت نشد";
%>

<div class="notfind"><%
        out.print(notFind);
    }
%></div>


<%--<% List<Ticket> ticket = (List<Ticket>) request.getAttribute("ticket");--%>
<%--if(ticket != null){%>--%>
<%--    <h2><% ticket.forEach(out.println);}%></h2>--%>

<% List<Ticket> search = (List<Ticket>) request.getAttribute("search");%>

<%--    if (search != null) {--%>

<%--        for (Ticket text : search) {--%>
<%--%>--%>

<%--<h2><%out.println(text);%><input type="submit"><%--%>
<%--        }--%>
<%--    }--%>
<%--%></h2>--%>

<%--<%--%>
<% Boolean hasTicket = (Boolean) request.getAttribute("hasTicket");
    if (hasTicket != null && hasTicket) {

%>
<br>
<br>
<br>
<br>
<br>

<table align="center">
    <thead class="thead1">
    <tr>
        <th> &emsp; <% out.print(request.getAttribute("time"));%> : تاریخ حرکت &emsp;</th>
        <th class="selectBuy" colspan="2"> &emsp; <% out.print(request.getAttribute("source")); %> - <%
            out.print(request.getAttribute("dest"));%>: مسیر &emsp;
        </th>
    </tr>
    <tr class="thead2">
        <th>شناسه سفر</th>
        <th>ساعت حرکت</th>
        <th>انتخاب</th>
    </tr>

    </thead>

    <tbody>

    <%
        for (Ticket text : search) {


    %>
    <tr class="center">
        <td><%out.print(text.getTravelCode());%></td>
        <td><%out.print(text.getMoveTime());%></td>
        <td class="pading" align="center">
            <%--            --%>

            <%--            <a href="/submit-ticket?ticketId=<%out.print(text.getId());%>">--%>
            <%--            مثال برای نمایش--%>
            <%--            </a>--%>


            <form action="/ticket/submit-ticket" method="post">
                <input name="ticketId" type="hidden" value="<%out.print(text.getId());%>">
                <input class="select" type="submit" value="خرید">


            </form>
        </td>
    </tr>
    <%
        }
    %>

    </tbody>

</table>

<%
} else {
%>
<%
    //String nofind = " . ";
    // nofind  = (String) request.getAttribute("nofind");
%>
<p><% out.print(" ");%></p>

<%
    }
%>

</body>
</html>


<%--  servlet -> /single-ticket?ticketId=  --%>