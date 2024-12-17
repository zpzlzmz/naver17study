package day1217;

import java.util.Date;
import java.util.Scanner;

public class Ex1Calender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 년도 와 월을 입력하면 해당 월의 달력을 출력 하시오
		 * 달력이 제대로 나오게 하려면 
		 * 1. 그 월의 1일이 무슨요일인가.
		 * 2. 그 월이 몇일까지 있는가
		 */
		int year, month;
		int endDays, weekDay;//월의 끝(ex 31일, 요일 숫자
		boolean leapYear;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("년도를 입력하세요:");
		year = sc.nextInt();
		System.out.print("월을 입력하세요:");
		month = sc.nextInt();
		//1~12월이 아닌경우 프로그램 종료 
		if(month>12 || month<1) {
			System.out.println("잘못된 월입니다");
			return;//main 메서드 종료
		}
		//윤년인지 아닌지 확인하기 
		leapYear = year%4==0 && year%100 !=0 || month%400 == 0; 
		if(leapYear)
			System.out.println(year +" 년도는 윤년입니다.");
		else
			System.out.println(year +" 년도는 평년입니다.");
	//입력한 년도와 월의 1일에 대한 Date 클래스 생성
		
		
		Date inputDate = new Date(year-1900,month-1,1); 
		weekDay = inputDate.getDay();//0일---6토 
		//해당 월이 몇일까지 있는지 구하기
		switch(year) {
		case 2:
			endDays = leapYear?29:28;
		case 4: case 6: case 9: case 11:
			endDays=30;
			break;
		default:
			endDays = 31;
		}
		//제목부터 찍기
		System.out.println("=".repeat(50));
		System.out.println("\t\t["+year+"년 "+month+"월]");
		System.out.println("=".repeat(50));
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		System.out.println("=".repeat(50));
		
		/*for(int i =1; i<=weekDay; i++) { // weekDay 만큼 \t 하기(만약 1일이 화요일이면 일 월은 \t 으로 공백.
			System.out.print("\t");
		}*/
		 System.out.print("\t".repeat(weekDay));
		
		//1일부터 endDays 까지 출력(토요일은 출력후 \n)
		for(int i =1;i<=endDays;i++) {
			++weekDay; // 이렇게 증가해야 첫 토요일이 7.. 그 다음 부터 7의 배수가 된다.
			System.out.printf("%2d\t",i);
			if(weekDay%7 == 0) {
				System.out.println();
			}
		}
		
		
	}
	

}
