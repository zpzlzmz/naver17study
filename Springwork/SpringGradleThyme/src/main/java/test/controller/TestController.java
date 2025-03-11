package test.controller;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import test.dto.FoodDto;

@Controller
public class TestController {
	
	
	@GetMapping("/")
	public String home() {
		
		
		return "food/home";
	}
	
	
	@GetMapping("/hello")
	public String home(Model model) {
		
		model.addAttribute("message","Have a nice Day");
		model.addAttribute("myfood","nonoimage.png"); 
		
		return "food/hello";
	}
	
	@GetMapping("/hello2")
	public String hello2(Model model,@RequestParam(value="name") String name, @RequestParam(value="age") int age) {
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		
		
		return "food/hello2";
	}
	
	@GetMapping("/hello3")
	public String hello3(Model model) {
		
		FoodDto dto=FoodDto.builder()
				.foodName("망고빙수")
				.foodPhoto("nonoimage.png")
				.foodPrice(15000)
				.build();
		model.addAttribute("dto",dto);
		model.addAttribute("bgcolor","#00ff7f");
		model.addAttribute("today",new Date());
		return "food/hello3";
	}
	@GetMapping("/hello4")
	public String hello4(Model model) {
		List<FoodDto> list = new Vector<>();
		list.add(new FoodDto("야채샌드위치",12000,"s1.jpg"));
		list.add(new FoodDto("망고빙수",22000,"s2.jpg"));
		list.add(new FoodDto("코코넛",16700,"s3.jpg"));
		list.add(new FoodDto("야자수",12100,"s4.jpg"));
		list.add(new FoodDto("내머리야자수",62000,"s5.jpg"));
		list.add(new FoodDto("코카트리스",1112000,"s6.jpg"));
		list.add(new FoodDto("코끼리",1222000,"s7.jpg"));
		list.add(new FoodDto("만오천원",120640021,"s8.jpg"));
		
		model.addAttribute(list);
		
		return "food/hello4";
	}
	
	@GetMapping("/hello5")
	public String hello5(Model model,@RequestParam(value = "myid") String myid,
			HttpSession session)
	{
		session.setAttribute("loginid", myid);
		return "food/hello5";
	}
}
