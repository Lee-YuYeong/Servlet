package com.smhrd.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.database.SqlSessionManager;

public class WebMemberDAO {

SqlSessionFactory sqlSessionFactory =SqlSessionManager.getSqlSessionFactory();
	
	// 회원가입
	public int join(WebMember member) {
		
		// Factory 사용해서 Session 생성
		// openSession(true) : 여기서 true는 auto commit
		// 기본 값이 false
		SqlSession sqlSession = sqlSessionFactory.openSession(true);// 세션 생성
		int cnt = 0;
		try {
			// 실제 실행할 sql문은 MemberMapper.xml에 적혀져 있음
			// insert(실제 실행할 sql문 - namespace.id (xml),sql 실행할 때 넘겨줄 값(?))
		    // 반환값 : sql 실행 성공(삽입 성공하면 1 / 실패 0)
			cnt =  sqlSession.insert("WebMemberDAO.insert",member);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close(); //자원 반환
		}
		return cnt;
	}
	//로그인 기능
	
		public WebMember login(WebMember member) {
			WebMember member2=null;
			// 세션 생성
			SqlSession sqlSession = sqlSessionFactory.openSession(true);
			try {
				// select(실제 실행할 sql문 - namespace.id (xml),sql 실행할 때 넘겨줄 값)
				// selectOne : 한 명의 회원 정보
				// selectList : 전체 회원 정보
				member2 = sqlSession.selectOne("WebMemberDAO.login",member);
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				sqlSession.close(); //자원 반환
			}
			return member2;
		}
	
	//업데이트 기능
		public int update(WebMember updateMember) {
			SqlSession sqlSession = sqlSessionFactory.openSession(true);
			int cnt = 0;
			
			try {
				cnt = sqlSession.update("WebMemberDAO.update",updateMember);
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				sqlSession.close(); //자원 반환
			}
			return cnt;
			
		}
		
	//
		public List<WebMember> select() {
			SqlSession sqlSession = sqlSessionFactory.openSession(true);
			
			List<WebMember> list = null;
			try {
				//회원정보를 모두 불러와야함으로 selectList를 사용
				list = sqlSession.selectList("WebMemberDAO.select");// 넘겨줘야하는 값이 없으면 매개인자1개만
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				sqlSession.close(); //자원 반환
			}
			return list;
		}
		
		public int delete(String email) {
			SqlSession sqlSession = sqlSessionFactory.openSession(true);
			int cnt = 0;
			
			try {
				//회원정보를 모두 불러와야함으로 selectList를 사용
				cnt = sqlSession.delete("WebMemberDAO.delete",email);// 넘겨줘야하는 값이 없으면 매개인자1개만
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				sqlSession.close(); //자원 반환
			}
			return cnt;
		}
		
		
		}
	
	
	
	

