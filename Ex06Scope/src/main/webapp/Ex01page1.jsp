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
	// page scope에 저장된 값은 해당 페이지 안에서만 지역변수처럼 사용 가능
	// page scope 안에 저장된 값-> el(expression language)표기법 사용 가능(자바 변수는 불가능)
	// setAttribute(String(name),Object(value))
	pageContext.setAttribute("nickname","풀스택");
	// getAttribute(name)은 업캐스팅으로 값을 가져오기 떄문에 다운캐스팅 해줘야 함
	String nick = (String)pageContext.getAttribute("nickname");
    
	
	%>
	<%=nick %><br>
	${nickname} <!-- el 표기법 안에는 page영역안에 저장된 name값 지정해주어야 함 -->
	${nick } <!-- 출력 안됨 name은 변수일 뿐 page안에 저장된 name값이 아니기 때문 -->
	${pageScope.nickname }
	
	<a href="Ex01page2.jsp"> 2로 이동</a>
	

</body>
</html>