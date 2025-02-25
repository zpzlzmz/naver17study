package member.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.NonFinal;
import naver.storage.NcpObjectStorageService;

@Controller
//@AllArgsConstructor
//final을 붙인 멤버 변수만 자동주입 
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberDelUpdateController {
	
	final MemberService memberService;
	
	private String bucketName="bitcamp.bucket";
	
	
	final NcpObjectStorageService stroageService;
	
	
	@GetMapping("/delete")
	public String deleteMember(@RequestParam int num) {
		
		memberService.deleteMember(num);
		
		return "redirect:./list";
	}
	
	@GetMapping("/mypagedel")
	@ResponseBody
	public void mypageDelete(@RequestParam int num, HttpSession session)
	{
		memberService.deleteMember(num);
		
		//모든 세션 제거 
		session.removeAttribute("loginstatus");
		session.removeAttribute("loginid");
		session.removeAttribute("loginphoto");
		
	}
	
	@GetMapping("/checkdel")
	@ResponseBody
	public void checkDeleteMember(@RequestParam String nums) {
		
		String num[] = nums.split(",");
		
		for(String str:num) {
			 int n = Integer.parseInt(str);
			 memberService.deleteMember(n);
		}
		
	}
	
	@GetMapping("/mypage")
	public String goMypage(HttpSession session,Model model) {
		//세션으로 부터 아이디를 얻는다
		String myid=(String)session.getAttribute("loginid");
		//아이디에 해당하는 dto 얻기
		MemberDto dto=memberService.getSelectByMyid(myid);
		//모델에 dto 저장
		model.addAttribute("dto",dto);
		model.addAttribute("naverurl","https://kr.object.ncloudstorage.com/bitcamp.bucket");
		return "member/mypage";
	}
	
	@PostMapping("/changephoto")
	@ResponseBody
	public void changePhoto(
			HttpServletRequest request,
			@RequestParam("upload") MultipartFile upload,
			@RequestParam("num") int num,
			HttpSession session
			) {
		
				/*
				 * //sqve 경로 String uploadFolder =
				 * request.getSession().getServletContext().getRealPath("/save");
				 * 
				 * //기존 파일 명 얻기 String
				 * oldFilename=memberService.getSelectByNum(num).getMphoto(); //기존 파일 삭제 File
				 * oldFile = new File(uploadFolder+"/"+oldFilename); if(oldFile.exists())
				 * oldFile.delete();
				 * 
				 * //upload 할 파일명 String
				 * uploadFilename=UUID.randomUUID()+"."+upload.getOriginalFilename().split("\\."
				 * )[1]; //업로드 try { upload.transferTo(new
				 * File(uploadFolder+"/"+uploadFilename)); //session도 변경
				 * session.setAttribute("loginphoto", uploadFilename); //db도 사진 변경
				 * memberService.changePhoto(num, uploadFilename); } catch
				 * (IllegalStateException | IOException e) { // TODO Auto-generated catch block
				 * e.printStackTrace(); }
				 */
		//사진 수정시 db에 저장된 파일명을 받아서 storage에서 삭제 후 추가할것 
		String oldFilename = memberService.getSelectByNum(num).getMphoto();
		stroageService.deleteFile(bucketName,"member", oldFilename);
		
		//네이버 스토리지에 업로드
		String updateFilename = stroageService.uploadFile(bucketName, "member", upload);
		//db에서 수정 
		
		memberService.changePhoto(num, updateFilename);
		//세션도 변경 
		session.setAttribute("loginphgoto", updateFilename);
		
		
	}
	
	@PostMapping("/update")
	@ResponseBody
	public void update(@ModelAttribute MemberDto dto) {
		System.out.println(dto.getNum());
		memberService.updateMember(dto);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
