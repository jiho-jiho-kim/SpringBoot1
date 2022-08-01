package com.simple.basic.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.basic.command.BoardVo;

@Service("이름")
public class BoardServiceImpl implements BoardService {

	@Autowired  //인터페이스명과 mapper 이름은 동일해야합니다.
	BoardMapper boardMapper;
	
	
	@Override
	public boolean insert(BoardVo vo) {
		
//		String result = boardMapper.getTime();
//		System.out.println(result);
		
		return  boardMapper.insert(vo);
	}


	@Override
	public List<BoardVo> getList() {
		
		return boardMapper.getList();
	}


	@Override
	public BoardVo getDetail(int bno) {
		
		return boardMapper.getDetail(bno);
	}


	@Override
	public boolean delete(int bno) {
		
		return boardMapper.delete(bno);
	}

	
	
}
