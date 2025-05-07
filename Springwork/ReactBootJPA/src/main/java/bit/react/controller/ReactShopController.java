package bit.react.controller;

import bit.react.data.ShopDto;
import bit.react.data.ShopEntity;
import bit.react.repository.ShopDao;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin //서롷 다른 도메인에서 접근할때 에러 안나게
@RequestMapping("/react")
public class ReactShopController {
	private final ShopDao shopDao;
	private final NcpObjectStorageService storageService;

	private String bucketName = "bitcamp.bucket";
	private String folderName="jpashop";

	private String uploadFilename;


	@PostMapping("/addshop")
	public String addShop(@RequestBody ShopDto dto) {
		System.out.println("addshop:"+ dto);
		ShopEntity shopEntity = ShopEntity.builder()
				.sangpum(dto.getSangpum())
				.price(dto.getPrice())
				.sangguip(dto.getSangguip())
				.color(dto.getColor())
				.photo(uploadFilename)
				.build();
		shopDao.insertShop(shopEntity);
		uploadFilename=null;
		return "insert ok";
	}
//사진은 따로 업로드

	/*@PostMapping("/upload")*/
	@PostMapping(value = "/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String uploadPhoto(@RequestParam("upload") MultipartFile upload) {
		System.out.println("업로드한 파일명:"+upload.getOriginalFilename());
		if(uploadFilename!=null)
			storageService.deleteFile(bucketName, folderName, uploadFilename);//이전에 업로드한 사진 지우기
		//네이버 클라우드에 업로드하기
		uploadFilename=storageService.uploadFile(bucketName, folderName, upload);
		return uploadFilename;
	}

	@GetMapping("/detail")
	public ShopEntity getSelectData(@RequestParam("num") int num) {
		return shopDao.getData(num);
	}

	@GetMapping("/shoplist")
	public List<ShopEntity> selectAll(){
		return shopDao.getAllShops();
	}
	@DeleteMapping("/shopdelete")
	public String deleteShop(@RequestParam("num") int num) {
		//db삭제 전에 Storage 에 사진 지우기
		String photoName = shopDao.getData(num).getPhoto();
		storageService.deleteFile(bucketName,folderName,photoName);
		shopDao.deleteShop(num);
		return "delete ok";
	}

	@PostMapping("/shopupdate")
	public String updateShop(@RequestBody ShopDto dto) {
		ShopEntity entity = ShopEntity.builder()
				.sangpum(dto.getSangpum())
				.color(dto.getColor())
				.price(dto.getPrice())
				.sangguip(dto.getSangguip())
				.num(dto.getNum())
				.photo(uploadFilename)
				.build();
		shopDao.updateShop(entity);
		uploadFilename=null;
		return "update ok";

	}



}
