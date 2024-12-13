
package day1213;
import java.util.Scanner;

public class Ex13For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 5명의 나이를 입력후 
		 * 40세 이상과 40세 미만이 각각 몇명인지 출력하고 
		 * 평균 나이도 같이 출력하시오 ~ 
		 * for 문 사용인데 
		 * 
		 */
		
		Scanner sc = new Scanner(System.in);
		int age = 0,upper = 0, total = 0,i=0;
		double avg;
		for(i=0; i<=4; i++) {
			System.out.print("나이를 입력하세요 :");
			age = sc.nextInt();
			
			if(age>=40)
				upper +=1;
			
			total += age;	
		}
		avg = (double)total/i;
		
		System.out.println("40세 이상 :"+upper);
		System.out.println("40세 미만 :"+(i-upper));
		System.out.printf("평균 나이: %.1f",avg);
		
		
	}

}
