<%@page import="com.smhrd.model.MyMember"%>
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
		MyMember member = (MyMember)session.getAttribute("member");
	%>
	
	<%if(member==null){ //로그인 안 했을 때 %>
		<a href="join.html"><button>회원가입</button></a>
		<a href="login.html"><button>로그인</button></a>
	<%}else{ // 로그인 성공했을 때%>
		<%=member.getNick() %>님 환영합니다
	<%} %>
	
	
</body>
</html>