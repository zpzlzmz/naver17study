package day1213;

import java.util.Scanner;

public class Ex7While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int score, total=0,count=0;
		double avg;
		while(true) {
		System.out.print("점수를 입력하세요(종료시 0):");
		score = sc.nextInt();
		if(score == 0)
			break;
		if(score>100 ||score<0) {
			System.out.println("\t잘못 입력된 점수입니다.");
			continue;
		}
		count++;
		total += score;
		
		}
		avg = (double)total/count;
		System.out.println("총 입력한 점수 갯수:"+count);
		System.out.println("점수의 총 합계:"+total);
		System.out.printf("점수의 평균 %.1f",avg);
		
	}

}