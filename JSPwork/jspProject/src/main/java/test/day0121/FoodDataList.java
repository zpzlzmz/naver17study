package test.day0121;

import java.util.ArrayList;
import java.util.List;

import test.data.FoodDto;

public class FoodDataList {
	private List<FoodDto> list = new ArrayList<FoodDto>();
	
	public FoodDataList() {
		// TODO Auto-generated constructor stub
		list.add(new FoodDto("계란말이","계란말이.jpg",30000,"2025-01-21",2));
		list.add(new FoodDto("꼬치구이","2.jpg",12000,"2025-01-20",1));
		list.add(new FoodDto("망고빙수","11.jpg",33000,"2025-01-11",5));
		list.add(new FoodDto("야채샌드위치","1.jpg",50000,"2025-02-11",1));
		list.add(new FoodDto("순두부찌개","12.jpg",67000,"2015-11-21",7));
		list.add(new FoodDto("독일족발","독일족발.jpg",100000,"2019-12-21",5));
		
	}
	
	public List<FoodDto> getAllDatas(){
		return list;
	}
}
