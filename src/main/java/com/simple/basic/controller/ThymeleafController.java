package com.simple.basic.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.basic.command.BuilderVo2;
import com.simple.basic.command.SimpleVo;

@RequestMapping("/view")
@Controller
public class ThymeleafController {
	
	//ex01화면 출력
	@GetMapping("/ex01")
	public String ex01() {
		return "view/ex01";
	}
	
	//ex02화면 출력
	@GetMapping("/ex02")
	public String ex02(Model model) {
		
		ArrayList<BuilderVo2> list = new ArrayList<>();
		
		//데이터(list)를 가지고 화면으로
		for(int i = 1; i <=10; i++) {
			BuilderVo2 vo = BuilderVo2
							.builder()
							.name("홍길동" + i)
							.age(i)
							.build();
			list.add(vo); //리스트에 추가
		}
		//list ex02화면으로 가지고 나가보세요.
		model.addAttribute("aaa", list);
		model.addAttribute("bbb", list);
		
		return "view/ex02";
	}
	
	
	//quiz01 화면으로 simpleVo를 반복문을 통해 20개 리스트에 담아 가져나갑니다.
	//quiz01 화면에 sno값이 3의 배수일 때만 출력.
	//LocalDateTime -> LocalDateTime.now()
	@GetMapping("/quiz01")
	public String quiz01(Model model) {
	
	ArrayList<SimpleVo> list = new ArrayList<>();
	LocalDateTime time = LocalDateTime.now();
	
	for(int i = 1; i <=20; i++) {
		SimpleVo vo = SimpleVo.builder().sno(i).first("홍").last("길동").regdate(time).build();
		list.add(vo);
	}
	model.addAttribute("ccc", list);
	model.addAttribute("time", time);
	
	return "view/quiz01";
	}
	
	@GetMapping("/ex03")
	public String ex03(Model model) {
		
		ArrayList<SimpleVo> list = new ArrayList<>();
		LocalDateTime time = LocalDateTime.now();
		
		for(int i = 1; i <=20; i++) {
			SimpleVo vo = SimpleVo.builder().sno(i).first("홍").last("길동").regdate(time).build();
			list.add(vo);
		}
		model.addAttribute("ccc", list);
		model.addAttribute("time", time);
		
		return "view/ex03";
	}
	
	//키 넘기기
	@GetMapping("/result")
	public String result(/* HttpServletRequest request */
						
	 					//@RequestParam("sno") int sno,
	 					//@RequestParam("first") String first
	 					
						SimpleVo vo
				) {
		
		//System.out.println(request.getParameter("sno"));
		//System.out.println(request.getParameter("first"));
		
		System.out.println(vo.toString());
		
		return "view/ex3_result";
	}
	
	@GetMapping("/result02/{sno}/{first}")
	public String result02(@PathVariable("sno") int sno, 
						   @PathVariable("first") String first) {
		
		System.out.println(sno);
		System.out.println(first);
		
		return "view/ex3_result";
	}
	
	//ex04 화면
	@GetMapping("/ex04")
	public String ex04(Model model) {
		
		 SimpleVo vo = SimpleVo.builder().sno(10)
										.first("홍")
										.last("길동")
										.regdate(LocalDateTime.now())
										.build();

		model.addAttribute("vo", vo);
		model.addAttribute("name", "홍길동");
		model.addAttribute("arr", new int[] {1,2,3,4});
		
		
		
		return "view/ex04";
	}
	
	//ex05 화면
	@GetMapping("/ex05")
	public String ex05(Model model) {
		
		SimpleVo vo = SimpleVo.builder().sno(10)
				.first("홍")
				.last("길동")
				.regdate(LocalDateTime.now())
				.build();

		model.addAttribute("vo", vo);
		model.addAttribute("name", "홍길동");
		model.addAttribute("arr", Arrays.asList(1,2,3));
		
		return "view/ex05";
	}
	
	//quiz02 화면
	@GetMapping("/quiz02")
	public String quiz02(Model model) {
		
		SimpleVo vo = SimpleVo.builder().first("김").last("지호").regdate(LocalDateTime.now()).sno(1018).build();
		
		model.addAttribute("vo", vo);
		
		return "view/quiz02";
	}
	
	//quiz02_result 화면
	@GetMapping("/quiz02_result")
	public String quiz02_result(@RequestParam("sno") int sno, 
							    @RequestParam("name") String name,
							    Model model) {
		
		System.out.println(sno);
		System.out.println(name);
		
		model.addAttribute("sno", sno);
		model.addAttribute("name", name);
		
		return "view/quiz02_result";
	}

	//ex06화면 출력(replace)
	@GetMapping("/ex06")
	public String ex06() {
		return "view/ex06";
	}
	
	//ex07화면 출력(replace)
	@GetMapping("/ex07")
	public String ex07() {
		return "view/ex07";
	
	
	}

}








