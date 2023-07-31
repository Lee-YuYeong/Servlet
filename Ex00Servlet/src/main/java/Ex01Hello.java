

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex01Hello")
public class Ex01Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	service: 요청을 처리하고 응답을 해줌
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		클라이언트에서 /Ex01Hello 경로로 요청
//		서버주소:8081/context-root(path)->Ex00/url mapping값
//		localhost:8081/Ex00/Ex01Hello
		
//		요청을 받으면서버가 클라이언트에게 정적리소트(HTML문서)을 응답해주는데
//		HTML문서 안에 HelloServlst이라는 문자가 출력되어야 함
//		즉 서버가 클라이언트한테 응답해주는 문서가 문자열이 작성되어 있는 HTML문서이다.
//		화면에 Hello Servlet이라고 출력!

//		response : 서버가 클라이언트에게 응답해주는 거
//		getWritter() : 서버가 클라이언트로 데이터를 보내기 위한 통로(스트림-> PrintWritter) 생성해주는 역할
		PrintWriter out = response.getWriter();
//		PrintWritter() : (데이터==텍스트)를 보내기 위한 통로
		
//		print(String) : 스트림을 통해서 텍스트 출력
		out.print("<b>Hello Servlet</b>"); // 응답할 HTML문서 만드는 작업
		
		
	}

}
