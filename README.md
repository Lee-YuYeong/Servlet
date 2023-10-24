# Servlet
- 서블릿(Servlet)이란 동적 웹 페이지를 만들 때 사용되는 자바 기반의 웹 애플리케이션 프로그래밍 기술
- 서블릿은 웹 요청과 응답의 흐름을 간단한 메서드 호출만으로 체계적으로 다룰 수 있게 해줌

# 주요 특징
- 클라이언트의 Request에 대해 동적으로 작동하는 웹 어플리케이션 컴포넌트
- 기존의 정적 웹 프로그램의 문제점을 보완하여 동적인 여러 가지 기능을 제공
- JAVA의 스레드를 이용하여 동작
- MVC패턴에서 컨트롤러로 이용됨
- 컨테이너에서 실행
- 보안 기능을 적용하기 쉬움

# 동작 과정
- 1. 클라이언트 요청
- 2. HttpServletRequest, HttpServletResponse 객체 생성
- 3. Web.xml이 어느 서블릿에 대해 요청한 것인지 탐색
- 4. 해당하는 서블릿에서 service() 메소드 호출 
- 5. doGet() 또는 doPost() 호출 
- 6. 동적 페이지 생성 후 ServletResponse 객체에 응답 전송
- 7. HttpServletRequest, HttpServletResponse 객체 소멸
