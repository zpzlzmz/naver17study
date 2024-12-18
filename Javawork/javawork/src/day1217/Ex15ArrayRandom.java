package day1217;

import java.nio.channels.MembershipKey;

public class Ex15ArrayRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numbers[]=new int[20];
		/*
		 * 배열에 1~50개 사이의 난수 20개를 구하여 넣고 
		 * 오름차순으로 정렬해서 출력을 함 (중복 없어야함)
		 */
		Loop:
		for(int i = 0; i< numbers.length;i++) {
			numbers[i]=(int)(Math.random()*50)+1;
			//중복 제거 하기 
			for(int j=0;j<i; j++) { 
				if(numbers[i] == numbers[j]) {
					System.out.println("중복이 발생함");
					i--;
					//break;//방법 1
					continue Loop; //방법 2
				}
			}
		}
		
		
		
		for(int i=0;i<numbers.length-1;i++) {
			for(int j=i+1;j<numbers.length;j++) {
				if(numbers[i]>numbers[j]) {
				int temp = numbers[i];
				numbers[i]=numbers[j];
				numbers[j]=temp;
			}
		}
	}
		
		//출력 - 한줄에 5개씩 
		for(int i = 0; i<numbers.length;i++) {
			System.out.print(i+":"+numbers[i]+"\t");
			if((i+1)%5==0) {
				System.out.println();
			}
		}
		
		
	}
}
