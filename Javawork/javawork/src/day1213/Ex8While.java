package day1213;

import java.util.Scanner;

public class Ex8While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		/*
		 * 숫자n을 입력하면 1부터 n 까지의 합계 sum을 구해서 출력 
		 * 
		 */
		
		
		int n,sum=0,i=1;
		
		System.out.print("숫자를 입력하시오:");
		n = sc.nextInt();
		while(true) {
			sum += i;
			i++;
			if (i>n)
				break;
			
		}
		System.out.printf("1부터 %d까지의 합계는 %d입니다.",n,sum);
	}

}