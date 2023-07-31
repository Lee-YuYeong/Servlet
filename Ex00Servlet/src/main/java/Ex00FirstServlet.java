

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @ : 어노테이션(주석) -> 주석이지만 컴파일될 떄 한 번 확인을 해줌
// @WebServlet : url-mapping을 해줌
@WebServlet("/first")
public class Ex00FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	객체를 직렬화해서 자바 바이트 형태로 변환해주어야 함
//	자바 바이트 형태의 값을 객체로 변환해주어야 함(역직렬화)
//	직렬화,역직렬화를 하는 과정에서 클래스 자체가 변환될 수 있어 버전을 부여해줌
       
//   생성자 : 객체 생성
//	 이 생성자를 사용해서 객체가 생성되었다고 해서 바로 서블릿의 기능을 사용활 수 있는 게 아님(서블릿 객체가 아님)
//	 서블릿 객체==통신 즉 요청이나 응답 할 수 있음
    public Ex00FirstServlet() {
       System.out.println("생성자 호출!");
    }

//	init 메서드 : 객체가 서블릿역할을 할 수 있도록 초기화해주는 역할이지만
//    비용이 많이 드는 작업으로
//    서버로 요청이 들어올 떄마다 이 작업을 해줘야 한다고 하면 비효율적!
//    따라서 최초로 요청이 들어오면 객체 생성 init메서드 호출해서 서블릿 객체로 초기화시켜주고
//    그 다음 요청이 들어오면 이미 생성되어 있는 객체 그대로 사용
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 호출!");
	}

//	destroy 메서드 : 서블릿 객체소멸해주는 역할(서버 종료,재시작할 때)
//	이 메서드가 호출되고 난 후 요청이 들어오면 다시 객체 생성하고 init메서드 호출해야 함
	public void destroy() {
		System.out.println("destroy 호출!");
	}

//	service 메서드: 사용자의 요청을 처리하고 응답해주는 역할
//	사용자가 요청할 떄 정해져있는 규칙 == http요청 메서드
//	**http요청 메서드 : GET(기본 값),POST,DELETE,PATCH,PUT
//	1.모든 요청은 Service에서 받음
//	2.요청 메서드에 따라 다르게 처리하고 싶은 경우
//	service가 doGet/doPost 메서드 호출되게 함
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service 호출!");
		super.service(request, response);
	}

//	doGet 메서드 : http 요청 메서드가 get일 경우 호출됨
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 호출!");
	}

//	doPost 메서드 : http 요청 메서드가 post인 경우 호출됨
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 호출!");
	}

}
