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
        String pw = request.getParameter("pw");
        
        if(id.equals("smart")&&pw.equals("123")){
        	// 페이지 이동하는 방법
        	//1. Redirecting
        	//2. forwarding
        	
        	// id값을 보내는 방법
        	// 1. url에 데이터를 추가해서 요청하는 방법 => 쿼리 스트링
        	// 쿼리 스크링 형식=> url?name=value&name2=value2
         // response.sendRedirect("Ex04LoginSuccess.jsp?id="+id); =>Redirecting
        	//2. request객체를 다음 페이지로 넘겨주는 방법(공유하는 방법)=> forwarding 
        	// RequestDispatcher :
        	//클라이언트로부터 최초로 들어온 요청을 원하는 자원으로 넘기는 등의 메서드를 가지고 있는 객체
        	RequestDispatcher rd = request.getRequestDispatcher("Ex04LoginSuccess.jsp");
        	// 지정한 자원으로 request객체 (response객체도) 넘기기
        	rd.forward(request, response);
        }else{
          response.sendRedirect("Ex04LoginFail.jsp");
        }
        %>
</body>
</html>