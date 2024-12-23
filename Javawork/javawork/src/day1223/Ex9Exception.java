package day1223;

import java.util.Date;
import java.util.Scanner;

public class Ex9Exception {
	public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		
		int birthYear, age;
		
		
		System.out.println("태어난 년도:");
		try {
		birthYear = Integer.parseInt(sc.nextLine());
		Date date =null;
		age = (date.getYear()+1900)-birthYear;
		System.out.println("내 나이는 "+age+"세 입니다.");
		}catch(NumberFormatException|NullPointerException e) {
			//둘중 하나의exception 발생시 catch 로 이동
			System.out.println("예외 발생:"+e.getMessage());
		}
		
		System.out.println("정상종료");
	}
}

