<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  -->
   <%
   Random rd = new Random();
   String subject = request.getParameter("subject");
   String[] item = request.getParameterValues("item");
   int random = rd.nextInt(item.length);
   
   
   %>
<h1 align="center">랜덤 당첨 게임</h1>
   <fieldset align="center">
    <legend>랜덤뽑기결과</legend>
    <h1><%= subject%></h1>
    <h1><%= item[random] %></h1>
    </fieldset>
   
</body>
</html>