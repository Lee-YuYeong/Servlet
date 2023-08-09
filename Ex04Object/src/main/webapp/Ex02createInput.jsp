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
       String num = request.getParameter("num");
       int int_num = Integer.parseInt(num);
       
       response.setContentType("text/html; charset=UTF-8");
       
       String input="";
       for(int i =0; i<int_num; i++){
    	   
       }
       %>
    <h1 align="center">랜덤 당첨 게임</h1>
    <fieldset align="center">
    <legend>랜덤뽑기</legend>
    <form action="Ex02randomOutput.jsp">
   <table>
	   <tr>
	     <td>주제 : </td>
	     <td><input type="text" name="subject"></td><br>
	   </tr>
	    
	   <%for(int i = 1; i<=int_num; i++){%>
	   <tr>
	     <td>아이템 : </td>
	     <td><input type="text" name="item"></td>
	     <br>
	    </tr> 
          <%  }  %>
	    
	   
	   <tr>
	   <td><input type="submit" value="랜덤뽑기"></td>
	   </tr>
   </table>
   </form>
   </fieldset>
 
 
</body>
</html>