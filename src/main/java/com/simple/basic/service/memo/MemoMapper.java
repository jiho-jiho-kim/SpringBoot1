package com.simple.basic.service.memo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.simple.basic.command.MemoVo;

@Mapper
public interface MemoMapper {

	public void memoInsert(MemoVo vo);
	public List<MemoVo> getList();
	public MemoVo getDetail(int mno);
}
