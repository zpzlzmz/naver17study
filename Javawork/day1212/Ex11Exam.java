package day1212;

import java.util.Date;
import java.util.Scanner;

public class Ex11Exam {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/*
		 * year, month, day 를 입력 후 해당 날짜에 대한 date클래스를 생성 후 (mydate)를 이용해 년도 월 일 요일(weekNum 을 구해서 출력 하시오)
		 * 
		 */
		System.out.println("년도를 입력하시오"); 
		int myYear = sc.nextInt();
		System.out.println("월을 입력하시오");
		int myMonth = sc.nextInt();
		System.out.println("일을 입력하시오");
		int myDay = sc.nextInt();
		Date myDate = new Date(myYear-1900, myMonth-1,myDay);
		int weekDay=myDate.getDay();

		
		String weekNum = (weekDay==0?"일":weekDay == 1?"월":weekDay==2?"화":weekDay==3?"수":weekDay==4?"목":weekDay==5?"금":"토");
		
		
		System.out.println("년도는"+(myDate.getYear()+1900)+"년 "+(myDate.getMonth()+1)+"월 "+myDate.getDate()+"일 입니다.");
		System.out.println(weekNum+"요일입니다.");
		
	}

}
