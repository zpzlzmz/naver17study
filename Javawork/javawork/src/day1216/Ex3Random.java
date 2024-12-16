package day1216;

import java.util.Scanner;

public class Ex3Random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 임의의 난수를 구한 후 숫자 알아맞추기
		 * 맞췄을 경우
		 * 계속 하시겠슴니까 ?  Y
		 * 			누르면 새로운 난수 발생, 카운트 변수 0으로 초기화
		 * y가 아닐경우 프로그램 종료 
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		int su,rnd,count;
		Exit: // 레이블은 대소문자 상관없이 임의로 지정
		while(true) {
			rnd = (int)(Math.random()*100)+1;
			count = 0;
			while(true) {
				System.out.print(++count+"회 : ");
				//su = sc.nextInt();
				su = Integer.parseInt(sc.nextLine());
				if(su>rnd)
					System.out.printf("%d보다 작습니다\n",su);
				else if(su<rnd)
					System.out.printf("%d보다 큽니다.\n",su);
				else {
					System.out.println("정답입니다");
					System.out.println("숫자맞추기 게임을 계속하려면 y, 그만하려면 n");
					char ch = sc.nextLine().charAt(0);
					if(ch== 'y'||ch=='Y') {
						System.out.println("새로운 난수를 발생합니다");
						continue Exit; //바깥쪽 반복문의 조건식으로 이동 (lable 을 이럴때 사용)
						//break; 현재 속한 While문만 빠져나감
					}
					else {
						break Exit;
					}
				}
			}
		}
	}
}
