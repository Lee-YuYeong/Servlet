package com.smhrd.model;
// Full Stack 테이블에서 가지고 온 학생 데이터를 하나로 묶어주는 작업
// 객체 -> 학생 한 명의 데이터를 의미 -> VO(Value Object)
// VO : 필드(테이블의 컬럼 이름과 일치하도록 작성), 생성자
public class FullStack {
	private String name;
	private String major;
	private String phone;
	
	// DB에서 가지고 온 값으로 초기화 해주는 생성자
	public FullStack(String name,String major,String phone) {
		this.name=name;
		this.major=major;
		this.phone=phone;
	}

	public String getName() {
		return name;
	}

	public String getMajor() {
		return major;
	}

	public String getPhone() {
		return phone;
	}
	
}
