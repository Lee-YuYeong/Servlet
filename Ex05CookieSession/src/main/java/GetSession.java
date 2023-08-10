
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/GetSession")
public class GetSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//세션 객체 생성
		HttpSession session = request.getSession();
		
		// 세션 값 가지고 오기
		// getAttribute(String(name))
		// 업 캐스팅(Object 타입으로 반환)되기 때문에 원래 타입으로 다운 캐스팅해주어야 함
	     String id = (String)session.getAttribute("id");
		 int age = (int)session.getAttribute("age");
		 ArrayList<String> al= (ArrayList<String>) session.getAttribute("list");
		
		 //응답 데이터 형식지정
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("id :"+id+"<br>");
		out.print("age :"+age+"<br>");
		out.print("list :"+al.toString()+"<br>");
	}

}
