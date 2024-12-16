package day1216;

import java.util.Scanner;

public class Ex2Random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 1부터 100까지의 임의의 수 rnd 를 발생후 숫자 알아 맞추기 
		 */
		int a= 0;
		int rnd = (int)(Math.random()*100)+1;
		Scanner sc = new Scanner(System.in);
		System.out.println(rnd);
		
		while(true) {
			System.out.print("숫자를 입력하세요:");
			a = sc.nextInt();
			
			if(a>rnd) {
				System.out.printf("%d보다 작습니다\n",a);
			}
			else if(a<rnd) {
				System.out.printf("%d보다 큽니다.\n",a);
			}
			else{
				System.out.println("정답입니다");
				break;
			}

		}  
		
	}

}
