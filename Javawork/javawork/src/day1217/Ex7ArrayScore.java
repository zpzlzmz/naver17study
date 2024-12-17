package day1217;

import java.util.Scanner;

public class Ex7ArrayScore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 인원수를 입력후 그 인원수 만큼 이름과 점수를 입력하고 
		 * 등수와 총점과 평균을 구하여 출력하시오
		
		 */
		int inwon;
		String name[];
		int [] score,rank;
		int total = 0;
		double avg = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("인원수를 입력하시오:");
		inwon = Integer.parseInt(sc.nextLine());
		//인원수 만큼 배열 할당
		score = new int[inwon];
		rank = new int[inwon];
		name = new String[inwon];
		
		for (int i = 0; i<inwon; i++) {
			System.out.print((i+1)+"번째 이름을 입력하세요:");
			name[i] = sc.nextLine();
			
			System.out.print((i+1)+"번째 점수를 입력하세요:");
			score[i] = Integer.parseInt(sc.nextLine());
			
			total +=score[i];
		}
		avg = (double)total / inwon;
		//등수 구하기
		
		for(int i= 0 ; i<inwon; i++) {
			for(int j =0; j<inwon; j++) {
				if(score[i]<score[j])
					rank[i]++;
			}
		}
		
		//출력
		System.out.println("번호\t이름\t점수\t등수");
		System.out.println("=".repeat(50));
		for(int i=0; i<inwon; i++) {
			System.out.println(i+1+"\t"+name[i]+"\t"+score[i]+"\t"+(rank[i]+1));
		}
		System.out.println("=".repeat(50));
		System.out.println("총점:"+total+"\t평균:"+avg);
		
		
		
	}

}
