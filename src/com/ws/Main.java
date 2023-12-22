package com.ws;

public class Main {
	public static void main(String[] args) { //프로그램 시작점
		
		Container.init(); // Container에 있는 공유 자원을 이용
		
		new App().run(); // App 객체만들고 run을 실행

		Container.close(); // Container에 있는 공유 자원을 이용 끝
	}
}