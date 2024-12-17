package day1217;

import java.util.Scanner;

public class Ex9ArrayAge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int datas[] = {12,34,54,20,33,19,59,41,44,27,21};
		/*
		 * 위의 데이터를 분석해 10대부터 50대 까지의 인원수를 구하시오 
		 * 배열변수 age[]를 이용해 구하시오
		 0번지는 10대 인원수
		 출력 양식 
		 10대: n명
		 20대: n명
		 30대: n명
		 */
		Scanner sc = new Scanner(System.in);
		int age[]= new int[5];
		
		for(int i =0; i<datas.length; i++) {
			age[((datas[i]/10)-1)]++;//숫자를 datas의 값을 10으로 나눴을때 나오는 몫의 배열 값으로 들어간다 ?  
			//데이터로 for문을 돌리면 배열 범위를 넘는다 .- >? 따로 해야하나 ? 아니 for문을 돌리긴 해야함 
		}
		
		
		for(int i =0; i<age.length;i++) {
			System.out.printf("%d대:%d명\n",((i+1)*10),age[i]);
		}
		
		
		
		
	}

}
