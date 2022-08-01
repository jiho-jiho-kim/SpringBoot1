package com.simple.basic.service.memo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.basic.command.MemoVo;

@Service("memoService") //고유한 이름
public class MemoServiceImpl implements MemoService {

	@Autowired
	MemoMapper memoMapper;

	@Override
	public void memoInsert(MemoVo vo) {
		
		memoMapper.memoInsert(vo);
	}

	@Override
	public List<MemoVo> getList() {
		
		return memoMapper.getList();
	}

	@Override
	public MemoVo getDetail(int mno) {
		
		return memoMapper.getDetail(mno);
	}
	
	
	
}
