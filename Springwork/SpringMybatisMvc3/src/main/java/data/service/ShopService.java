package data.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import data.dto.ShopDto;
import data.mapper.ShopMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ShopService {
	
	ShopMapper shopmapper;
	
	public int getTotalCount() {
		
		return shopmapper.getTotalCount();
	}
	
	public void insertShop(ShopDto dto) {
		shopmapper.insertShop(dto);
	}
	
	public List<ShopDto> getAllSangpum() {
		
		return shopmapper.getAllSangpum();
	}
	
	public ShopDto getNumSangpum(int num) {
		
		return shopmapper.getNumSangpum(num);
	}
	
	public void updateSangpum(ShopDto dto) {
		shopmapper.updateSangpum(dto);
	}
	
	public void deleteSangpum(int num) {
		shopmapper.deleteSangpum(num);
	}
	
	public void updatePhoto(int num,String photo) {
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("num",num);
		map.put("photo",photo);
		shopmapper.updatePhoto(map);
	}	
}
