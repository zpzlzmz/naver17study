package shop.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import data.dto.ShopDto;
import data.service.ShopService;
import jakarta.servlet.http.HttpServletRequest;
import naver.storage.NcpObjectStorageService;

@Controller
public class ShopDetailDeleteController {
	
	@Autowired
	ShopService shopService;
	
	private String bucketName="bitcamp.bucket";
	
	@Autowired
	NcpObjectStorageService storageService;
	
	@GetMapping("/shop/detail")
	public String shopDetail(@RequestParam int num,Model model) {
		
		
		ShopDto dto = shopService.getNumSangpum(num);
		String mainPhoto = dto.getSphoto().split(",")[0];
		dto.setMainphoto(mainPhoto);
		
		model.addAttribute("dto",dto);
		model.addAttribute("naverurl","https://kr.object.ncloudstorage.com/bitcamp.bucket");
		return "shop/detail";
	}
	
	
	
	
	
	 @GetMapping("/shop/delete")
	 public String deleteSangpum(@RequestParam int num
			 	/*HttpServletRequest request*/
			 ) {
		 
		 //String uploadFolder= request.getSession().getServletContext().getRealPath("/save");
		 String photos=shopService.getNumSangpum(num).getSphoto();
		 String photo[] = photos.split(",");
		 
			/*
			 * for(String file:list) { File f = new File(uploadFolder+"/"+file); f.delete();
			 * }
			 */
		 
		 for(String f:photo) {
			 storageService.deleteFile(bucketName,"shop",f);
		 }
		 
		 shopService.deleteSangpum(num);
		 
		 return "redirect:./list";
	 }
	
	 
	 
	 
	 
	 
	@GetMapping("/shop/photos")
	public String shopPhotos(@RequestParam int num,Model model)
	{
		
		//num에 해당하는 사진 얻기 
		String sphoto=shopService.getNumSangpum(num).getSphoto();
		model.addAttribute("sphoto", sphoto);
		model.addAttribute("num", num);
		model.addAttribute("fronturl", "https://f8l9t99j8727.edge.naverncp.com/RNV7xv6BFG");
		model.addAttribute("backurl", "?type=f&w=100&h=120&faceopt=true&ttype=jpg");
		return "shop/photos";
	}
	
	@GetMapping("/shop/delphoto")
	@ResponseBody
	public void deletePhoto(@RequestParam int num, @RequestParam String pname, HttpServletRequest request) {
		
		/*
		 * String
		 * uploadFolder=request.getSession().getServletContext().getRealPath("/save");
		 * File file=new File(uploadFolder+"/"+pname); if(file.exists()) file.delete();
		 */
		
		storageService.deleteFile(bucketName, "shop", pname);
		
		//num에 해당하는 sphoto를 db에서 얻는다
		String sphoto=shopService.getNumSangpum(num).getSphoto();
		//sphoto에서 p name 부분을 삭제하는데 중간일 경우 , 까지 삭제
		String changephoto="";
		if(sphoto.endsWith(pname))
			changephoto=sphoto.replace(pname, "");
		else
			changephoto=sphoto.replace(pname+",", "");
		System.out.println(changephoto);
		//변경된 changephoto를 updatePhoto 로 보내기 
		shopService.updatePhoto(num, changephoto);
	}
	
	
	@PostMapping("/shop/addphoto")
	@ResponseBody
	public void addPhoto(@RequestParam int num, @RequestParam("upload") List<MultipartFile> uploadList, HttpServletRequest request) {
		//업로드 경로 구하기 
		/*
		 * String uploadFolder =
		 * request.getSession().getServletContext().getRealPath("/save"); String
		 * photos=""; for(MultipartFile f:uploadList) { //업로드 할 파일명 String
		 * uploadFilename =
		 * UUID.randomUUID()+"."+f.getOriginalFilename().split("\\.")[1];
		 * photos+=uploadFilename+","; //업로드 try { f.transferTo(new
		 * File(uploadFolder+"/"+uploadFilename)); } catch (IllegalStateException |
		 * IOException e) { // TODO Auto-generated catch block e.printStackTrace(); } }
		 */
		
		String photos="";
		for(MultipartFile f: uploadList) {
			String uploadFilename=storageService.uploadFile(bucketName,"shop",f);
			photos+=uploadFilename+",";
			
		}
		
		//마지막 컴마 제거 
		photos =photos.substring(0,photos.length()-1);
		//db에서 sphoto 얻기
		String sphoto = shopService.getNumSangpum(num).getSphoto();
		//sphgoto 가 값이 없을 경우 photos 를 대입하고ㅡ 이미 있을경우 ,를 추가한 후 photos  추가
		if(sphoto.length() == 0) {
			sphoto=photos;
		}else {
			sphoto=sphoto+","+photos;
		}
		
		//db에서 sphoto 수정
		shopService.updatePhoto(num, sphoto);
		
		
	}
	
}
