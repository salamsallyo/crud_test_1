package com.example.demo.domain;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * CREATE TABLE `board_test`.`board` ( `b_id` INT NOT NULL AUTO_INCREMENT ,
 * `b_writer` VARCHAR(100) NOT NULL , `b_title` VARCHAR(100) NOT NULL ,
 * `b_contents` TEXT NOT NULL , `b_created_date` DATETIME NOT NULL DEFAULT
 * CURRENT_TIMESTAMP , `b_update_date` DATETIME NOT NULL DEFAULT
 * CURRENT_TIMESTAMP , PRIMARY KEY (`b_id`)) ENGINE = InnoDB;
 */


@Entity
@Table(name = "board")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Board {
	
	@Id //Primary key의 컬럼인 것을 나타나주는 어노테이션 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "b_id") //대응하는 컬럼명 지정
	private Integer b_id;
	
	@Column(name = "b_writer", nullable = false, length = 100)
	private String b_writer;
	
	@Column(name = "b_title" , nullable = false, length = 100)
	private String b_title;
	
	@Column(name = "b_contents", nullable = false, length = 512)
	private String b_contents;
	
	@CreationTimestamp
	@Column(name = "b_created_date")
	private LocalDateTime b_created_date;
	
	@UpdateTimestamp
	@Column(name = "b_update_date")
	private LocalDateTime b_update_date;
	
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	
	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}
	
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	
	public void setB_contents(String b_contents) {
		this.b_contents = b_contents;
	}
	
	public void setB_created_date(LocalDateTime b_created_date) {
		this.b_created_date = b_created_date;
	}
	
	public void setB_update_date(LocalDateTime b_update_date) {
		this.b_update_date = b_update_date;
	}
	
	public int getB_id() {
		return b_id;
	}
	
	public String getB_writer() {
		return b_writer;
	}
	
	public String getB_title() {
		return b_title;
	}
	
	public String getB_contents() {
		return b_contents;
	}
	
	public LocalDateTime getB_created_date() {
		return b_created_date;
	}
	
	public LocalDateTime getB_update_date() {
		return b_update_date;
	}
}
