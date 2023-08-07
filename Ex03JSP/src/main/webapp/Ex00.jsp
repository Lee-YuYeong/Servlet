
<!--지시자 : JSP 설정 정보 및 다른 문서를 포함
지시자의 종류 : page,include,taglib(tag library ->JSTL)-->
<!-- contentType : 응답데이터의 형식과 인코딩 방식을 브라우저에게 알려주기 위함
 pageEncoding : JSP 페이지에 대한 인코딩 지정
 charset : html 문서에 대한 인코딩 지정 -->
 
<%@page import="java.util.Random"%>
<%@ page  language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 스크립틀릿 : JSP 페이지 내부에 자바소스코드 삽입
               스크립틀릿 안에 작성한 코드의 위치는 모두 service()메서드 안에 작성 됨 -->
 <% 
    //JSP 구성요소 내에서는 자바 주석으로 주석 작성
    System.out.print("Hello");
    int num = 10;
    int num2 = 20;
    
    
   Random rd = new Random();
   int ran = rd.nextInt(10);
   //Web container가 javax.servlet.jsp.JspWriter out = null;을
   //자동으로 생성해주기 때문에 out이란 객체를 생성하지 않아도 사용 가능 == 내장 객체
   out.print(ran+"<br>"); //화면 상에서 개행하고 싶다면 <br>, out.println() : 코드 개행
   
 %>
<!-- 표현식 : 웹 브라우저 상에 출력하기 위해 사용 -->
<%= ran %><br>
<%= "String" %><br>
<%= "풀"+"스택" %><br>

<!-- 선언문 : 자바 메서드,변수를 선언하기 위해 사용 
            스클립틀릿에도 변수 선언 할 수 있지만 선언문에 변수 선언해야 전역변수로 선언됨
            선언문 안에 작성한 코드의 위치는 클래스 이름 바로 밑에 작성 됨-->
<%! int num3 = 100;%>
<%!
  public void print(){
	System.out.print("Print!");
    }
%>

 
</body>
</html>