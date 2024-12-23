package day1223;

import java.util.Date;
import java.util.Scanner;

public class Ex8Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int birthYear, age;
		
		
		System.out.println("태어난 년도:");
		try {
		birthYear = Integer.parseInt(sc.nextLine());
		Date date =null;
		age = (date.getYear()+1900)-birthYear;
		System.out.println("내 나이는 "+age+"세 입니다.");
		}catch(NumberFormatException e) {
			System.out.println("잘못된 입력입니다.");
			System.out.println("오류 메세지: "+e.getMessage());
		}catch(NullPointerException e) {
			System.out.println("date변수가 Null입니다");
		}
		
		
		System.out.println("정상종료");
	}

}
