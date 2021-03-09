package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Board;


//JpaRepository클래스 상속받음
//JpaRepository의 파라미터 인자에 Board 클래스와 Intefer 설정
public interface BoardRepository extends JpaRepository<Board, Integer> {

}
