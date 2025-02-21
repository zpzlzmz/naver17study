package member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import data.dto.MemberDto;
import data.service.MemberService;

@Controller
public class MemberListController {
	@Autowired
	MemberService memberService;
	
	
	@GetMapping("/member/list")
	public String memberList(Model model) {
		
		List<MemberDto> list = memberService.getAllMember();
		
		model.addAttribute("list",list);
		
		
		return "member/list";
	}
	
	
	

}
