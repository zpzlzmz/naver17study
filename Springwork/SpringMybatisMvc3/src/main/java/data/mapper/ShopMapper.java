package data.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import data.dto.ShopDto;

@Mapper
public interface ShopMapper {
	public int getTotalCount();
	
	public void insertShop(ShopDto dto);
	
	public List<ShopDto> getAllSangpum(); 
	
	public ShopDto getNumSangpum(int num);
	
	public void updateSangpum(ShopDto dto);
	
	public void deleteSangpum(int nun);
	
	public void updatePhoto(Map<String, Object> map);
}
