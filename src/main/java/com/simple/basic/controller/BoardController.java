package com.simple.basic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.basic.command.BoardVo;
import com.simple.basic.service.board.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	//멤버변수   // 1st
	//BoardService boardService = new BoardServiceImpl();
	
	
	@Autowired
	@Qualifier("이름")
	BoardService boardService;
	
	//등록화면
	@GetMapping("/boardRegist")
	public String boardRegist() {
		return "board/boardRegist";
	}
	//목록화면
	@GetMapping("/boardList")
	public String boardList(Model model) {
		
		//데이터를 가지고 나간다.
		List<BoardVo> list = boardService.getList();
		
		model.addAttribute("list", list); //화면에 데이터를 전달
		
		return "board/boardList";
	}
	//결과화면
	@GetMapping("/boardResult")
	public String boardResult() {
		
		System.out.println("리다이렉트 탐");
		
		return "board/boardResult";
		
	}
	
	@PostMapping("/boardForm")
	public String boardForm(BoardVo vo) {
		
		//System.out.println(vo.toString()); // 등록하고 넘오오는지 보는거지 어디서 터졌는지 확인하기 싫으면 하나 하고 확인하는 습관을 들여라 잘 못하니까
		
		
		boolean result = boardService.insert(vo);
		System.out.println("성공실패:" + result);
		//화면에 데이터를 가져나갈 필요가 없다면 리다이렉트 방식으로 처리
		//스프링에서 리다이렉트 방식은 다시 컨트롤러를 태워보내는 방식.
		return "redirect:/board/boardResult"; //결과화면으로
	}
	
	//상세화면
	@GetMapping("/boardDetail")
	public String boardDetail(@RequestParam("bno") int bno, Model model) {
		//글 1개를 가지고 화면으로 나간다.
		BoardVo vo = boardService.getDetail(bno);
		
		model.addAttribute("vo", vo);
		
		
		return "board/boardDetail";
	}
	
	//글 삭제
	@GetMapping("/boardDelete")
	public String boardDelete(@RequestParam("bno") int bno,
							RedirectAttributes RA) {
		
		boolean result = boardService.delete(bno);
		System.out.println("성공실패:" + result);
		//리다이렉트시에 간단한 메시지 전달방법 (1회성 메시지)
		//RedirectAttributes
		RA.addFlashAttribute("mag", "정상 처리되었습니다");
		
		//삭제한 이후에는 
		//데이터를 가지고 화면으로 
		return "redirect:/board/boardList";
	}
	
	
	
}
