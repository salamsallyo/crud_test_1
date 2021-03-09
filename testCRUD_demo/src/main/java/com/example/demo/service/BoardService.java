package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.BoardRepository;
import com.example.demo.domain.Board;

@Service
public class BoardService {
	
	@Autowired //스프링부트가 자동으로 객체를 주입
	BoardRepository boardRepo;
	
	public List<Board> findAll() {
		List<Board> list = boardRepo.findAll(); // findAll() 메소드로 테이블 레코드 리스트 가져옴
		return list;
	}
}
