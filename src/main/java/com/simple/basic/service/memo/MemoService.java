package com.simple.basic.service.memo;

import java.util.List;

import com.simple.basic.command.MemoVo;

public interface MemoService {
	
	public void memoInsert(MemoVo vo);
	public List<MemoVo> getList();
	public MemoVo getDetail(int mno);
}
