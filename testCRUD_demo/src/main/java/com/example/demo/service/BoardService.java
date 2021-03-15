package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Board;
import com.example.demo.repository.BoardRepository;

@Service
public class BoardService {
	
	@Autowired //스프링부트가 자동으로 객체를 주입
	BoardRepository boardRepo;
	
	public List<Board> findAll() {
		List<Board> list = boardRepo.findAll(); // findAll() 메소드로 테이블 레코드 리스트 가져옴
		return list;
	}
	
	//글 작성 service
	public void createBoard(Board board) {
		boardRepo.save(board);
	}
	
	//글 보기 service
	public Board getOne(int b_id) {
		return boardRepo.getOne(b_id);
	}
	
	//글 수정 service
	public void updateBoard(int b_id, Board new_board) {
		boardRepo.findById((int)b_id)
		.map(board -> {
			board.setB_title(new_board.getB_title());
			board.setB_contents(new_board.getB_contents());
			board.setB_update_date(LocalDateTime.now());
			return boardRepo.save(board);
		}).orElseGet(()->{
			new_board.setB_id(b_id);
			return boardRepo.save(new_board);
		});
	}
	
	public void deleteOne(int b_id) {
		boardRepo.deleteById(b_id);
	}
	
}
