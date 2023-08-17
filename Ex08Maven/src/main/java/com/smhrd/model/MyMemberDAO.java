package com.smhrd.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.database.SqlSessionManager;

// MyBatis DAO 정의
public class MyMemberDAO {
	
	// SqlSessionFactory 생성 : DB관련 기능을 직접 사용할 수 있는 세션을 생성
	// static으로 만들었기 때문에 따로 객체 생성 안 해도 됨
	SqlSessionFactory sqlSessionFactory =SqlSessionManager.getSqlSessionFactory();
	
	// 회원가입
	public int join(MyMember member) {
		
		// Factory 사용해서 Session 생성
		// openSession(true) : 여기서 true는 auto commit
		// 기본 값이 false
		SqlSession sqlSession = sqlSessionFactory.openSession(true);// 세션 생성
		int cnt = 0;
		try {
			// 실제 실행할 sql문은 MemberMapper.xml에 적혀져 있음
			// insert(실제 실행할 sql문 - namespace.id (xml),sql 실행할 때 넘겨줄 값(?))
		    // 반환값 : sql 실행 성공(삽입 성공하면 1 / 실패 0)
			cnt =  sqlSession.insert("MyMemberDAO.insert",member);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close(); //자원 반환
		}
		return cnt;
	}
	//로그인 기능
	
	public MyMember login(MyMember member) {
		MyMember member2=null;
		// 세션 생성
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		try {
			// select(실제 실행할 sql문 - namespace.id (xml),sql 실행할 때 넘겨줄 값)
			// selectOne : 한 명의 회원 정보
			// selectList : 전체 회원 정보
			member2 = sqlSession.selectOne("MyMemberDAO.login",member);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close(); //자원 반환
		}
		return member2;
	}
}
