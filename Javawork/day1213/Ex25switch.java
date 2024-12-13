package day1213;

import java.util.Scanner;

public class Ex25switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
//		char ch;
//		System.out.println("알파벳 한글자 입력");
//		ch = sc.nextLine().charAt(ch);
//		
//		switch(ch)
//		{
//		case 'a':
//		case 'A':
//			System.out.println("Apple");
//			break
//		
		
//		}
		System.out.println("영어단어를 입력해주세요");
		String msg=sc.nextLine();
		
		switch(msg) {
		case "red":
		case "RED":
			System.out.println("빨간색");
			break;
		case "green":
		case "GREEN":
			System.out.println("초록색");
			break;
		default:
			System.out.println("빨강과 초록을 제외한 색상");
		
		}
	}

}
