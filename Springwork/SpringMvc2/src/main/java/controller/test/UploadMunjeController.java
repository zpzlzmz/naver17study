package controller.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import data.dto.FilenameChange;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UploadMunjeController {
	
	
	
	
	
	@GetMapping("/munjeupload1")
	public String munjeUpload1()
	{
		
		return "uploadmunje/ajaxmunjeupload";
	}
	
	@PostMapping("/munjeuploadprocess")
	@ResponseBody
	public Map<String, String> munjeupload(
			HttpServletRequest requset,
			@RequestParam String title,
			@RequestParam("upload") MultipartFile upload
			)
	{
		Map<String, String> map = new HashMap<>();
		
		String uploadPath= requset.getSession().getServletContext().getRealPath("/save");
		
		String uploadFileName = FilenameChange.getDateChangeFileName(upload.getOriginalFilename());
		
		try {
			upload.transferTo(new File(uploadPath+"/"+uploadFileName));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		map.put("title",title);
		map.put("photo", uploadFileName);
		
		return map;
		
	}
	
	
	@GetMapping("/munjeupload2")
	public String multi() {
		
		return "uploadmunje/munjeuploadform";
	}
	
	@PostMapping("/multiprocess1")
	public String multiUpload(
			HttpServletRequest request,
			Model model,
			@RequestParam String title,
			@RequestParam("upload") List<MultipartFile> uploadList
			) 
	
	{
		//제목부터 모델에 저장
		model.addAttribute("title",title);
		//업로드 할 프로젝트 내의 위치 지정(webapp/save)
		String uploadFolder = request.getSession().getServletContext().getRealPath("/save");
		
		//업로드된 파일명을 저장할 리스트 변수 
		List<String> list = new Vector<>();
		
		//여러개의 파일들을 업로드(파일명 뒤에 날짜 붙여서 업로드 하기)
		for(MultipartFile multifile:uploadList) {
			//업로드할 파일명 구하기
			//String uploadFileName=FilenameChange.getDateChangeFileName(multifile.getOriginalFilename());
			String uploadFileName = FilenameChange.getRandomChangeFileName(multifile.getOriginalFilename());
			try {
				multifile.transferTo(new File(uploadFolder+"/"+uploadFileName));
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list.add(uploadFileName);
		}
		
		model.addAttribute("list",list);
		
		return "uploadmunje/munjeresultview";
	}

}
