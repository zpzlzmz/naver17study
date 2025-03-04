package board.controller;


import java.util.List;
import java.util.Vector;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import data.dto.BoardDto;
import data.dto.BoardFileDto;
import data.service.BoardFileService;
import data.service.BoardService;
import data.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;

@Controller
@RequiredArgsConstructor //final 이 붙은것만 주입
@RequestMapping("/board")
public class BoardController {
	
	final NcpObjectStorageService stroageService;
	final BoardService boardService;
	final BoardFileService fileService;
	final MemberService memberService;
	
	private String bucketName="bitcamp.bucket";
	
	@GetMapping("/writeform")
	public String writeform(//아래 4개의 값은 답글일때만 넘어옴, 새글일때는 null 값이 넘어와 required 를 false 로 주거나 defaultValue를 지정하기
						@RequestParam(value="idx",defaultValue="0") int idx,
						@RequestParam(value="regroup",defaultValue="0") int regroup,
						@RequestParam(value="restep",defaultValue="0") int restep,
						@RequestParam(value="relevel",defaultValue="0") int relevel, Model model,@RequestParam(value="pageNum",defaultValue="1") int pageNum) {
		
		model.addAttribute("idx",idx);
		model.addAttribute("regroup",regroup);
		model.addAttribute("restep",restep);
		model.addAttribute("relevel",relevel);
		model.addAttribute("pageNum",pageNum);
		
		return "board/writeform";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute BoardDto dto, @RequestParam int pageNum, @RequestParam("upload") List<MultipartFile> upload, HttpSession session ) {
		
		//1.세션으로 부터 아이디를 얻느낟 
		String myid = (String)session.getAttribute("loginid");
		dto.setMyid(myid);
		//아이디를 이용해 멤버 테이블에서 작성자를 얻는다
		String writer = memberService.getSelectByMyid(myid).getMname();
		dto.setWriter(writer);
		//게시판 내용을 db에 저장 -> idx를 얻어올 수 있기 때문에 (dto가) 
		boardService.insertBoard(dto);
		
		BoardFileDto bdto = new BoardFileDto();
		
		
		for(MultipartFile list:upload) {
			if(!upload.get(0).getOriginalFilename().equals("")) {
				break;
			}else {
				bdto.setIdx(dto.getIdx());
				//빡세네
				bdto.setFilename(stroageService.uploadFile(bucketName, "board", list));
				fileService.insertBoardFile(bdto);
			}
		}
		
		
		//파일이 있는 경우에만 해당,네이버 스토리지에 저장후 파일저장(이떄 필요한게 idx,filename)
		//반복문 안에서만 이뤄져야함
		
		
		return "redirect:./list?pageNum="+pageNum;
	}
	
	
	@GetMapping("/detail")
	public String detail(@RequestParam int idx, @RequestParam int pageNum, Model model) {
		
		//조회수 1증가 
		boardService.updateReadcount(idx);
		
		//idx해당하는 dto 얻기
		BoardDto dto = boardService.getSelectByIdx(idx);
		//idx 에 글에 등록된 파일들도 가져오기 
		List<String> fileList = new Vector<>();
		List<BoardFileDto> files=fileService.getFiles(idx);
		for(BoardFileDto fdto:files) {
			fileList.add(fdto.getFilename());
		}
		dto.setPhotos(fileList);
		
		//해당 아이디에 대한 사진 멤버 테이블에서 얻기 
		String memberPhoto = memberService.getSelectByMyid(dto.getMyid()).getMphoto();
		model.addAttribute("dto",dto);
		model.addAttribute("memberPhoto",memberPhoto);
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("naverurl","https://kr.object.ncloudstorage.com/"+bucketName);
		
		
		return "board/boarddetail";
	}
	
	@GetMapping("/updateform")
	public String updateForm(
			@RequestParam int idx, @RequestParam int pageNum,
			Model model
			)
	{
		BoardDto dto=boardService.getSelectByIdx(idx);
		model.addAttribute("dto", dto);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("naverurl", "https://kr.object.ncloudstorage.com/"+bucketName);

		return "board/updateform";
	}	

	//수정폼에서 기존 사진 목록 나타냄
	@GetMapping("/photolist")
	@ResponseBody
	public List<BoardFileDto> photoList(@RequestParam int idx)
	{
		List<BoardFileDto> list=fileService.getFiles(idx);
		return list;
	}

	//수정폼에서 각각의 사진 삭제시
	@GetMapping("/photodel")
	@ResponseBody
	public void deletePhoto(@RequestParam int num)
	{
		//스토리지에 있는 파일명 얻기
		String filename=fileService.getFilename(num);

		//스토리지에서 사진 삭제
		stroageService.deleteFile(bucketName, "board", filename);

		//사진 삭제
		fileService.deleteFile(num);
	}

	//사진추가및 글수정
	@PostMapping("/update")
	public String update(
			@ModelAttribute BoardDto dto,
			@RequestParam int pageNum,
			@RequestParam("upload") List<MultipartFile> upload
			)
	{
		//제목및 내용 수정
		boardService.updateBoard(dto);
		//사진은 추가
		//파일이 있는경우에만 해당,네이버 스토리지에 저장후 파일저장(이때 필요한게 idx,filename)
		//반복문 안에서 이루어져야만 한다
		if(!upload.get(0).getOriginalFilename().equals(""))
		{
			for(MultipartFile f:upload)
			{
				String filename=stroageService.uploadFile(bucketName, "board", f);
				BoardFileDto bdto=new BoardFileDto();
				bdto.setIdx(dto.getIdx());
				bdto.setFilename(filename);
				//boardfile 에 insert
				fileService.insertBoardFile(bdto);
			}
		}

		return "redirect:./detail?idx="+dto.getIdx()+"&pageNum="+pageNum;				
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public void boardDelete(@RequestParam int idx)
	{
		//idx 에 해당하는 파일들 삭제
		List<BoardFileDto> filelist=fileService.getFiles(idx);
		for(BoardFileDto fdto:filelist)
		{
			String filename=fdto.getFilename();
			stroageService.deleteFile(bucketName, "board", filename);
		}
		
		boardService.deleteBoard(idx);//원글을 지우면 그 글에 업로드된 파일들 db정보는 자동으로 지워짐
	}
	
}
