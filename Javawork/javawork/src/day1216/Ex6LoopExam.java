package day1216;

import java.util.Scanner;

public class Ex6LoopExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 문자열 Str을 입력 후 엔터를 누르면 문자열을 분석해서 대문자, 소문자, 숫자 각각의
		 * 갯수를 구해서 출력하시오 
		 * 사용할 문자 메소드 : length(),charAt(인덱스),
		 */
		
		Scanner sc = new Scanner(System.in);
		String s;
		int upper=0, lower = 0, num = 0;
		System.out.print("문자열을 입력하세요: ");
		s = sc.nextLine();
		int n = s.length();
		
		for(int i = 0; i<n; i++) {
			if(s.charAt(i)>=65 && s.charAt(i)<=90) {
				upper ++;
			}
			else if(s.charAt(i)>=97 && s.charAt(i)<=122) {
				lower ++;
			}
			else if(s.charAt(i)>=48 &&s.charAt(i)<=57) {
				num++;
			}
			else
				continue;
			
		}
		System.out.println("대문자:"+upper);
		System.out.println("소문자:"+lower);
		System.out.println("숫자:"+num);
	}

}
