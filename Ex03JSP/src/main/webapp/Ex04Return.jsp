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
  String num1 = request.getParameter("num1");
    int int_num1 = Integer.parseInt(num1);
  String num2 = request.getParameter("num2");
    int int_num2 = Integer.parseInt(num2);
  String ope = request.getParameter("ope");
  
  if(ope.equals("plus")){
	    out.print(int_num1+"+"+ int_num2 +"="+(int_num1+int_num2));
  }else if(ope.equals("minus")){
	  out.print(int_num1+"-"+ int_num2 +"="+(int_num1-int_num2));
  }else if(ope.equals("mul")){
	  out.print(int_num1+"*"+ int_num2 +"="+(int_num1*int_num2));
  }else{
	  out.print(int_num1+"/"+ int_num2 +"="+(int_num1/int_num2));
  }

  %>
   
</body>
</html>