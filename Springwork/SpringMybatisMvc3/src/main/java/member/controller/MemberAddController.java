package member.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import data.dto.MemberDto;
import data.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import naver.storage.NcpObjectStorageService;

@Controller
@RequestMapping("/member")
public class MemberAddController {

	@Autowired
	MemberService memberService;
	
	//버켓 이름 얻기 
	private String bucketName="bitcamp.bucket";
	
	@Autowired
	NcpObjectStorageService stroageService;
	
	
	@GetMapping("/form")
	public String form()
	{
		return "member/memberform";
	}
	
	//아이디가 존재하면 result 에 fail 를 ,존재하지 않으면 success 를 보내기
	@GetMapping("/idcheck")
	@ResponseBody
	public Map<String, String> idCheck(@RequestParam String myid)
	{
		Map<String, String> map=new HashMap<>();
		if(memberService.isMyidCheck(myid)) {
			map.put("result", "fail");
		}else {
			map.put("result", "success");
		}
		return map;
	}
	
	
	@PostMapping("/insert")
	public String insert(
			HttpServletRequest request,
			@ModelAttribute MemberDto dto,
			@RequestParam("upload") MultipartFile upload
			) {
		//사진 선택 안했을 경우 upload의 파일명을 확인 
		
		/*
		 * String uploadFolder=
		 * request.getSession().getServletContext().getRealPath("/save");
		 * 
		 * if(upload == null || upload.isEmpty()){ dto.setMphoto("No"); } else { String
		 * uploadFilename =
		 * UUID.randomUUID()+"."+upload.getOriginalFilename().split("\\.")[1];
		 * dto.setMphoto(uploadFilename); try { upload.transferTo(new
		 * File(uploadFolder+"/"+uploadFilename)); } catch (IllegalStateException |
		 * IOException e) { // TODO Auto-generated catch block e.printStackTrace(); } }
		 */
		//네이버 storager 에 사진 저장 하기  -> 네이버 object stroage 에 사진을 업로드 후 업로드한 파일명을 반환 
		String uploadFilename=stroageService.uploadFile(bucketName, "member", upload);
		dto.setMphoto(uploadFilename);
		memberService.insertMember(dto);
		
		
		
		return "redirect:../";
	}
	
	
	
	
	
}
