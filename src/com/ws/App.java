package com.ws;

import com.ws.system.controller.SystemController;
import com.ws.wiseSaying.controller.WiseSayingController;

public class App {

	private byte system_status = 1; //system_status라는 변수에 1를 담는다

	public App() {

	}

	public void run() { // run이라는 메소드 실행
		System.out.println("== 명언 앱 실행 =="); // == 명언 앱 실행 ==를 출력

		SystemController systemController = new SystemController();
//SystemController 타입과 연결될 변수명 systemController에 SystemController라는 객체를 생성
		WiseSayingController wiseSayingController = new WiseSayingController();
// WiseSayingControlle 타입과 연결될 변수명 wiseSayingController에 WiseSayingController라는 객체를 생성
		while (system_status == 1) { // system_status == 1를 비교하여 참이면 밑에를 실행 거짓이면 실행안함 
			System.out.print("명령어 ) ");// 명령어 )를 출력
			String cmd = Container.getScanner().nextLine().trim();
			// String 타입에 변수명 cmd에 Container.getScanner를 이용해 입력한 문자를 담는다 
			Rq rq = new Rq(cmd);
			// Rq 타입에 변수명 rq에 Rq객체에 만들고 거기에 입력한 명령어를 넣는다. 
			switch (rq.getActionCode()) { // rq에 있는 ActionCode에 담긴 내용이 밑에 case들 중에 있는지 확인 
			case "종료":
				systemController.exit();// ActionCode가 종료이면 systemController에 있는 exit로 간다 
				system_status = 0;
				break;// 가까운 반복문 탈출
			case "등록":
				wiseSayingController.write();//ActionCode가 등록이면 wiseSayingController에 있는 write로 간다 
				break;// 가까운 반복문 탈출
			case "목록":
				wiseSayingController.list();//ActionCode가 등록이면 wiseSayingController에 있는 list로 간다
				break;// 가까운 반복문 탈출
			case "삭제":
				wiseSayingController.remove(rq);//ActionCode가 등록이면 wiseSayingController에 있는 remove로 간다
				break;// 가까운 반복문 탈출
			case "수정":
				wiseSayingController.modify(rq);//ActionCode가 등록이면 wiseSayingController에 있는 modify로 간다
				break;// 가까운 반복문 탈출
			default:
				System.out.println("존재하지 않는 명령어입니다");
				break;// 가까운 반복문 탈출
			}
		}

	}
}