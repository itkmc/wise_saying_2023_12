package com.ws.wiseSaying.service;

import java.util.List;

import com.ws.wiseSaying.entity.WiseSaying;
import com.ws.wiseSaying.repository.WiseSayingRepository;

public class WiseSayingService {

	private WiseSayingRepository wiseSayingRepository;

	public WiseSayingService() {

		wiseSayingRepository = new WiseSayingRepository();
	}

	public List<WiseSaying> findAll() {
		return wiseSayingRepository.findAll();
	}//wiseSayingRepository에 있는 findAll()으로 값을 돌려준다

	public int write(String content, String author) {

		return wiseSayingRepository.write(content, author);
	}//wiseSayingRepository에 있는 write(content, author)으로 값을 돌려준다

	public WiseSaying findById(int id) {
		return wiseSayingRepository.findById(id);
	}//wiseSayingRepository에 있는 findById(id)으로 값을 돌려준다

	public void remove(WiseSaying wiseSaying) {
		wiseSayingRepository.remove(wiseSaying);
	}//wiseSayingRepository에 있는 remove(wiseSaying)으로 값을 돌려준다

	public void modify(WiseSaying wiseSaying, String content, String author) {
		wiseSayingRepository.modify(wiseSaying, content, author);
		//wiseSayingRepository에 있는 modify(wiseSaying, content, author)으로 값을 돌려준다
	}

}