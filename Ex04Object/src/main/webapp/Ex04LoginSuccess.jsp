<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <%
     String id = request.getParameter("id");
    
	 out.print(id+"님 환영합니다"); 

     %>
 
    <%= "smart님 환영합니다" %>
  
    
</body>
</html>