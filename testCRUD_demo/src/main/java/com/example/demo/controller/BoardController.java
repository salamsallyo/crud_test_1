package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/board/{b_id}")
	public ModelAndView boardOneRead(@PathVariable("b_id") int b_id) {
		ModelAndView nextView = new ModelAndView("board/read");
		Board res = service.getOne(b_id);
		nextView.addObject("board", res);
		return nextView;
	}
	
	@GetMapping("/board/update/{b_id}")		//글 수정페이지로 이동
	public ModelAndView updateBoard(@PathVariable("b_id") int b_id) {
		System.out.println("Contents Updating(get).......");
		ModelAndView nextView = new ModelAndView("board/update");
		Board res = service.getOne(b_id);
		nextView.addObject("board", res);
		return nextView;
	}
	
	@PostMapping("/board/update/{b_id}")	//수정 후 해당 게시글 페이지로 이동
	public ModelAndView updateBoard(@PathVariable("b_id") int b_id, Board board) {
		System.out.println("Contents Updating(post).......");
		service.updateBoard(b_id, board);
		ModelAndView nextView = new ModelAndView("board/read");
		Board res = service.getOne(b_id);
		nextView.addObject("board", res);
		return nextView;
	}
	
	@GetMapping("/board/delete/{b_id}")
	public ModelAndView deleteBoard(@PathVariable("b_id") int b_id) {
		System.out.println("Delete Contents.......");
		service.deleteOne(b_id);
		ModelAndView nextView = new ModelAndView("board/list");
		List<Board> list = service.findAll();
		nextView.addObject("boardList", list);
		return nextView;
	}
}
