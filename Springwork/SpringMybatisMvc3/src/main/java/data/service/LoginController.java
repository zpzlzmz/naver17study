package data.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
public class LoginController {
	@Autowired
	MemberService memberService;
	
	@GetMapping("/member/login")
	public Map<String, String> login(
			@RequestParam String loginid, @RequestParam String loginpass,HttpSession session
			){
		Map<String, String> map = new HashMap<>();
		boolean b= memberService.loginCheck(loginid, loginpass);
		
		if(b) {
			session.setMaxInactiveInterval(60*60*4);
			session.setAttribute("loginstatus", "success");
			session.setAttribute("loginid", loginid);
			
			
			//아이디에 해당하는 프로필 사진 얻기
			String photo = memberService.getSelectByMyid(loginid).getMphoto();
			session.setAttribute("loginphoto", photo);
		}
		
		map.put("result", b?"success":"fail");
		
		return map;
	}
	
	@GetMapping("/member/logout")
	public void memberLogout(HttpSession session) {
		session.removeAttribute("loginphoto");
		session.removeAttribute("loginstatus");
		session.removeAttribute("loginid");
		
	}
	
	
}
