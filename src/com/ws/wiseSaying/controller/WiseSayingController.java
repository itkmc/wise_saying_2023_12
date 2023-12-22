package com.ws.wiseSaying.controller;

import java.util.List;

import com.ws.Container;
import com.ws.Rq;
import com.ws.wiseSaying.entity.WiseSaying;
import com.ws.wiseSaying.service.WiseSayingService;

public class WiseSayingController {

	private WiseSayingService wiseSayingService;

	public WiseSayingController() {
		wiseSayingService = new WiseSayingService();
	}

	public void write() {
		System.out.print("명언 : ");//명언:를 출력
		String content = Container.getScanner().nextLine().trim();
		//String 타입에 변수명 content에 Container에 있는 Scanner를 이용해 입력한 문자를 담는다
		System.out.print("작가 : ");//작가:를 출력
		String author = Container.getScanner().nextLine().trim();
		//String 타입에 변수명 author에 Container에 있는 Scanner를 이용해 입력한 문자를 담는다
		int id = wiseSayingService.write(content, author);
		// int 타입에 변수명 id에 wiseSayingService에 있는 write 값을 넣는다
		System.out.printf("%d번 명언이 등록되었습니다.\n", id);
	}	// id에 있는 값을 숫자열로 표현해서 id번 명언이 등록되었습니다라는 말을 출력

	public void list() {
		List<WiseSaying> wiseSayings = wiseSayingService.findAll();
		// 리스트 WiseSaying
		System.out.println("번호  /  작가  /  명언  ");//번호  /  작가  /  명언 를 출력
		System.out.println("=".repeat(30));//=를 30번 출력

		for (int i = wiseSayings.size() - 1; i >= 0; i--) {
			//int 타입 변수명 i에 wiseSayings.size에 -1를 한 값을 넣고 i값이 0보다 이상이면 참이면 밑에를 실행 나중에 i값을 1감소
			WiseSaying ws = wiseSayings.get(i);
			//WiseSaying 타입 변수명 ws에 wiseSayings i값을 넣는다
			System.out.printf("%d  /  %s  /  %s\n", ws.getId(), ws.getAuthor(), ws.getContent());
		}	// ws에 있는 id,author,content를 숫자열 문자열로 나타내서 출력함
	}

	public void remove(Rq rq) {

		int id = rq.getIntParam("id", -1);
		// int 타입 변수명 id에 rq에 있는 getIntParam("id", -1)를 넣는다
		if (id == -1) {// id에 있는 값이 -1이랑 같으면 if문 안쪽에 있는 거를 실행
			System.out.println("id(정수)를 제대로 입력해주세요");
			//id(정수)를 제대로 입력해주세요를 출력
			return;
		}
		// 입력된 id와 일치하는 명언 객체 찾기
		WiseSaying wiseSaying = wiseSayingService.findById(id);
//WiseSaying 타입 변수명 wiseSaying에 wiseSayingService에 있는 findById(id)값을 넣는다
		if (wiseSaying == null) { //wiseSaying에 넣은 값이 null이랑 같으면 if문 안쪽을 실행
			System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
			return;
		}// 위에 있는 if문의 id 값을 숫자열로 바꾸어서 id번 명언은 존재하지 않습니다를 출력

		// 찾은 명언 객체를 object기반으로 삭제
		wiseSayingService.remove(wiseSaying);
		//wiseSayingService에 있는 remove로 이동
		System.out.printf("%d번 명언이 삭제되었습니다.\n", id);

	}//id 값을 숫자열로 바꾸어서 id번 명언이 삭제되었습니다를 출력

	public void modify(Rq rq) {
		int id = rq.getIntParam("id", -1);
// int 타입의 변수명 id에 rq에 있는 Param("id", -1)를 넣는다
		if (id == -1) {//id에 넣은 값이 -1랑 같으면 if문 안쪽이 실행
			System.out.println("id(정수)를 제대로 입력해주세요");
			return;
		}//id(정수)를 제대로 입력해주세요를 출력
		// 입력된 id와 일치하는 명언 객체 찾기
		WiseSaying wiseSaying = wiseSayingService.findById(id);
//WiseSaying 타입 변수명 wiseSaying에 wiseSayingService에 있는 findById(id) 값을 넣는다
		if (wiseSaying == null) {//wiseSaying값이 null이랑 같으면 if문 안쪽이 실행
			System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
			return;
		}//id 값을 숫자열로 바꾸어서 id번 명언은 존재하지 않습니다를 출력 

		// 찾은 명언 객체를 object기반으로 수정
		System.out.println("명언(기존) :" + wiseSaying.getContent());
		//wiseSaying.getContent()에 있는 것을 명언(기존) :와 함께 출력
		System.out.println("작가(기존) :" + wiseSaying.getAuthor());
		//wiseSaying.getAuthor()에 있는 것을 작가(기존) :와 함께 출력
		System.out.print("명언 : ");//새로운 명언을 입력할 수 있게 명언 :를 출력
		String content = Container.getScanner().nextLine().trim();
		//String 타입 변수명 content에 Container에 Scanner를 이용해 입력한 문자를 넣는다
		System.out.print("작가 : ");//새로운 작가을 입력할 수 있게 작가 :를 출력
		String author = Container.getScanner().nextLine().trim();
		//String 타입 변수명 author에 Container에 Scanner를 이용해 입력한 문자를 넣는다
		wiseSayingService.modify(wiseSaying, content, author);
		//wiseSayingService에 있는 modify
		System.out.printf("%d번 명언이 수정되었습니다.\n", id);
		//id 값을 숫자열로 바꾸어서 번 명언이 수정되었습니다를 출력
	}

}