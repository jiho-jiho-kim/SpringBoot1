package com.simple.basic.service.board;

import java.util.List;

import com.simple.basic.command.BoardVo;

public interface BoardService {
	
	public boolean insert(BoardVo vo); 	// #{vo}
	
	public List<BoardVo> getList();  //전체목록조회
	
	public BoardVo getDetail(int bno); // 1개 목록 조회
	
	public boolean delete(int bno); // 글 삭제
	
}
