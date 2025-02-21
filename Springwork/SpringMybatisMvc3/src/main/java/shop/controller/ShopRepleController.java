package shop.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import data.dto.ShopRepleDto;
import data.service.ShopRepleService;
import jakarta.servlet.http.HttpServletRequest;

//forward 나 redirect 이런거 안됨 
@RestController
public class ShopRepleController {
	
	@Autowired
	ShopRepleService repleService;

	
	@PostMapping("/shop/addreple")
	public void insertReple(
			HttpServletRequest request,
			@RequestParam int num,
			@RequestParam String message,
			@RequestParam MultipartFile upload
			) {
		//save의 실제 경로 구하기 
		String uploadFolder= request.getSession().getServletContext().getRealPath("/save");
		//업로드할 파일 명 구하기(random uuid.확장자)
		String uploadFilename = UUID.randomUUID()+"."+upload.getOriginalFilename().split("\\.")[1];
		//사진 업로드
		try {
			upload.transferTo(new File(uploadFolder+"/"+uploadFilename));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//dto생성
		ShopRepleDto dto = new ShopRepleDto();
		dto.setNum(num);
		dto.setMessage(message);
		dto.setPhoto(uploadFilename);
		//db insert
		repleService.insertShopReple(dto);
		
		
	}
	
	
	@GetMapping("/shop/replelist")
	public List<ShopRepleDto> repleList(
				@RequestParam int num
			){
		
		List<ShopRepleDto> list = null;
		list = repleService.getRepleByNum(num);
		
		return list;
	}
	
	@GetMapping("/shop/repledelete")
	public void deleteShopReple(@RequestParam int idx,HttpServletRequest request) {
		
		repleService.deleteShopReple(idx);
		
	}
	
	@GetMapping("shop/likes")
	public Map<String, Integer> getLikes(@RequestParam int idx){
		
		repleService.updateLike(idx);
		int likes=repleService.getLikes(idx);
		Map<String, Integer> map = new HashMap<>();
		map.put("likes", likes);
		
		return map;
	}
	
	
}
