package day1213;

import java.util.Scanner;

public class Ex12For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 문제1 숫자 n을 입력하면 1부터 n까지 합계
		 * 
		 * 
		 */
		
		Scanner sc = new Scanner(System.in);
		int n = 0, sum = 0;
		System.out.print("숫자를 입력하세요:");
		n = sc.nextInt();
		for(int i = 0; i<=n; i++) {
			sum +=i;
		}
		
		System.out.printf("1부터 %d까지의 합은 %d 입니다.",n,sum);
	}

}

