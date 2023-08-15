package com.smhrd.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.FullStack;


@WebServlet("/Model2")
public class Model2 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Model2로 요청 먼저!
		//1. DB 연동
		//2. SQL 실행(FullStack 테이블 안에있는 모든 값 가져오기)
		//3. 3명의 학생 정보 -> 세션에 저장
		// -> Ex02model2.jsp로 이동
		Connection conn=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		FullStack fs = null;
		//ArrayList : 데이터를 검색할 때 용이
		//LinkedList : 중간 데이터를 삭제하거나 추가할 때 용이
		List<FullStack> list = new ArrayList<FullStack>();
		try{
			// 오라클과 연결할 드라이버 가지고 오기(동적 로딩)
			Class.forName("oracle.jdbc.OracleDriver");
			
			// 지정한 데이터베이스와 연결하기 위한 객체 생성(Connection) 생성
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "service";
			String password = "12345";
			
			conn = DriverManager.getConnection(url,user,password);
			
			String sql = "select * from fullstack";
			// sql쿼리문을 다루기 위한 객체(PreparedStatement) 생성 : 완성, 실행 등의 기능을 하는 객체
			 ps = conn.prepareStatement(sql);
			
			
			//sql실행
			//insert,delete,update -> executeUpdate() ->int타입으로 반환(몇개의 행이 update되었는 지)
			//select -> executeQuery()
			 rs = ps.executeQuery();
			
			
			while(rs.next()){ //next()의 반환 타입은 true 혹은 false
				String name = rs.getString("name"); // 컬럼 이름을 지정
				String major = rs.getString(2); //테이블 상 2번째 컬럼 값 가지고 올래!
				String phone = rs.getString("phone");
				
				//학생 1명의 정보만 저장
				 fs = new FullStack(name,major,phone);
				 
				// 가지고 온 학생 정보를 
			}
			
			
		}catch(ClassNotFoundException e){
			//OracleDriver 가지고 올때 경로가 잘 못되었을 경우
			System.out.println("OracleDriver 클래스 못찾음!");
		}catch(SQLException e){
			System.out.println("sql 예외 발생!");
		}catch(Exception e){
			System.out.println("다른 예외 발생!");
			e.printStackTrace(); //원인이나 발생하게 된 절차를 출력해줌
		}finally{
			// 예외 상황이 발생하던지 하지 않던지 간에 무조건 실헹!
			// 시용한 자원 반환 -> 생성한 순서 반대로 반환
			try{
				rs.close();
				ps.close();
				conn.close();
			}catch(Exception e){
				System.out.print("finally에서 예외상황 발생");
				e.printStackTrace();
			}
			
		}
		
		
		// list -> session에 저장
		HttpSession session = request.getSession();
		session.setAttribute("list", list);
		response.sendRedirect("Ex02model2.jsp");
	}

}
