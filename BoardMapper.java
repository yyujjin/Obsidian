package com.vam.mapper;

import java.util.List;

import com.vam.model.BoardVO;


//DB와 연결되는 제목만 생성한다.
//해당 제목이 실행되면 그 제목의 SQL 문이 실해된다. 
public interface BoardMapper {
	  /* 게시판 등록 DB연결 */
    public void enroll(BoardVO board);
    
    /* 게시판 목록 DB연결  */
    public List<BoardVO> getList();
}

