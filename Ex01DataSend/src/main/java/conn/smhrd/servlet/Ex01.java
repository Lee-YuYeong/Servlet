package conn.smhrd.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex01")
public class Ex01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		요청 데이터 name=data값 가져오기
//		getParameter(String -> form의 네임값) : 요청데이터 가져오는 메서드
//		반환타입 : String
		String data = request.getParameter("data");
		
		System.out.println(data);
		
//		응답 데이터에 인코딩 설정 추가하기 -> 한글은 인식을 못하기 때문에
//		response.setCharacterEncoding("UTF-8"); //데이터만 인코딩한 것으로 생략 가능
//		웹브라우저가 한글 인코딩을 할 수 있도록 알려주는 코드 추가하기
//		-> 브라우저에게 응답데이터 형식과 인코딩방식 알려주는 코드
		response.setContentType("text/html; charset=UTF-8");
		
//		사용자가 입력한 값 그대로 HTML문서로 만들어 응답히기
		PrintWriter out = response.getWriter();
		out.print(data); 
		
	}

}
