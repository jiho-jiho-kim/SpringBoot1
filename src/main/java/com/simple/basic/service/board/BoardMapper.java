package com.simple.basic.service.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.simple.basic.command.BoardVo;

@Mapper 	//부트에서는 메퍼로 사용할 인터페이스에 반드시 붙인다.
public interface BoardMapper {

	//public String getTime();
	public boolean insert(BoardVo vo);
	
	public List<BoardVo> getList(); //전체목록 조회
	
	public BoardVo getDetail(int bno); // 1개 목록 조회
	
	public boolean delete(int bno); // 글 삭제
}
