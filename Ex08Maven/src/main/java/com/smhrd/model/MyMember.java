package com.smhrd.model;

public class MyMember {
	
	// id,pw,nick
	private String id;
	private String pw;
	private String nick;
	
	//초기화 해주는 생성자 생성
	public MyMember( String id, String pw, String nick ) {
		this.id=id;
		this.pw=pw;
		this.nick=nick;
	}
	
	public MyMember( String id, String pw ) {
		this.id=id;
		this.pw=pw;
		
	}
	
	// getter
	public String getId() {
		return id;
	}
	
	public String getPw() {
		return pw;
	}
	
	public String getNick() {
		return nick;
	}
	
}
