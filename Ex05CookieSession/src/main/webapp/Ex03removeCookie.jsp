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
	// 쿠키 삭제
	// 쿠키 삭제의 메서드는 따로 존재하지 않기 때문에 생성 후 만료기간을 0으로 설정해줌
	//1. 쿠키 생성(삭제하고 싶은 쿠키의 name과 같은 name을 가진 쿠키 생성),value는 달라도 됨
	 Cookie cookie = new Cookie("name","");
	
	//2. 만료기간 설정 (0초로 설정)
	cookie.setMaxAge(0);
	
	//3. 서버에서 생성된 쿠키를 클라이언트에 전송
	response.addCookie(cookie);
	%>
	
	<a href="Ex02GetCookie.jsp">쿠키 확인</a>
	
	

</body>
</html>