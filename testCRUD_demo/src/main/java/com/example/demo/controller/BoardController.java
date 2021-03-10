package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domain.Board;
import com.example.demo.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@GetMapping("/board")
	public ModelAndView boardList() {
		List<Board> list = service.findAll();
		ModelAndView nextView = new ModelAndView("board/list");
		nextView.addObject("boardList", list);
		return nextView;
	}
	
	@GetMapping("/board/create")	//get 방식 -> /board/create -> 글 작성페이지 이동
	public ModelAndView createBoard() {
		ModelAndView nextView = new ModelAndView("board/create");
		return nextView;
	}
	
	@PostMapping("/board/create")	//post 발식 -> /board/create -> 글 작성 처리 후 글 리스트 이동
	public ModelAndView createBoard(Board board) {
		service.createBoard(board);
		ModelAndView nextView = new ModelAndView("board/list");
		List<Board> list = service.findAll();
		nextView.addObject("boardList", list);
		return nextView;
	}
}
