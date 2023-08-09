<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	filedset{
	width : 400px;
	}
	table{
	width:200px;
	margin:0px auto;
	}

</style>
</head>
<body>
   
  <%
  String name = request.getParameter("name");
  
  String java = request.getParameter("java");
  int int_java = Integer.parseInt(java);
  String web = request.getParameter("web");
  int int_web = Integer.parseInt(web);
  String iot = request.getParameter("iot");
  int int_iot = Integer.parseInt(iot);
  String and = request.getParameter("and");
  int int_and = Integer.parseInt(and);
  response.setContentType("text/html; charset=UTF-8");
  
  int sum = int_java+int_web+int_iot+int_and;
  double avg = sum/4.0;
  String score="";
  if(avg>=95){
    score="A+";
 }else if(avg>=90){
	score="A";
 }else if(avg>=85){
	 score="B+";
 }else if(avg>=80){
	 score="B";
 }else {
	 score="F";
 }
  
 %>
 <fieldset style="width=300px">
    <legend>학점확인프로그램</legend>
    <form action="Ex01Request.jsp">
      <table>
        <tr>
	        <td>이름</td>
	        <td><%=name %></td>
        </tr>
          <tr>
	        <td>Java점수</td>
	        <td><%=java %></td>
        </tr>
          <tr>
	        <td>Web점수</td>
	        <td><%=web %></td>
        </tr>
          <tr>
	        <td>IoT점수</td>
	        <td><%=iot %></td>
        </tr>
          <tr>
	        <td>Android점수</td>
	        <td><%=and %></td>
        </tr>
        <tr>
	        <td>평균</td>
	        <td><%=avg %></td>
        </tr>
        <tr>
	        <td>학점</td>
	        <td><strong><%=score %></strong></td>
        </tr>
       
      </table>
    
    
    </form>
    </fieldset>
 

 
</body>
</html>