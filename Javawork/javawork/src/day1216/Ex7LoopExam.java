package day1216;

import java.util.Scanner;
import java.lang.Math;
public class Ex7LoopExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 1.지수승 구하기 2.팩토리얼 구하기 3. 원의 넓이 구하기
		 * while 반복문에서 위의 메뉴ㅜ가 노ㅇ면 번호를 입력하고 해당 데이타를 입력후 결과값 출력
		 * 1번 : 두수 x,y를 입력후 x의 y승(for문)
		 * 2번 : x를 받고 그 수 의 팩토리얼
		 * 3번 : 반지름 x를 받으면 그 수를 제곱 *math.pi
		 * 그 이외의 값이 들어오면 "종료합니다 " 출력 후 프로그램을 종료하시오 
		 */
		Scanner sc = new Scanner(System.in);
		int x,y;//1번 필요한 변수 
		int n,fact = 1;
		int r ;
		double area;
		int menu;// 임력 받을 변수
		Loop:
		while(true) {
			System.out.print("1.지수승 구하기 \n2.Factorial 구하기 \n3.원의 넓이 구하기 \n4.종료:");
			menu = sc.nextInt();
			switch(menu) {
			case 1:
				int result=1;
				System.out.print("x를 입력해주세요:");
				x = sc.nextInt();
				System.out.print("y를 입력해주세요:");
				y = sc.nextInt();
				for(int i = 0; i<y; i++) {
					result*=x;
				}
				System.out.printf("%d의 %d승은 %d 입니다.\n",x,y,result);
				break;
			case 2:
				fact = 1;
				System.out.print("수를 입력하세요:");
				n = sc.nextInt();
				for(int i = 1; i<=n; i++) {
					fact*=i;
				}
				System.out.printf("%d의 Factorial 은 %d 입니다.\n",n,fact);
				break;
			case 3:
				System.out.print("원의 반지름을 입력하세요:");
				r = sc.nextInt();
				area = (Math.PI * Math.pow(r, 2));
				System.out.printf("원의 넓이는 %.2f 입니다.\n",area);
				break;
			default:
				System.out.println("프로그램을 종료합니다");
				break Loop; 
				
			}
			
		}
	}

}
