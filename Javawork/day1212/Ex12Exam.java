package day1212;

import java.util.Scanner;

public class Ex12Exam {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String name,grade;
		int java,html,spring,sum;
		double avg;
		
		System.out.println("이름을 입력하세요");
		name = sc.nextLine();
		System.out.println("java점수를 입력하세요");
		java = sc.nextInt();
		System.out.println("html점수를 입력하세요");
		html = sc.nextInt();
		System.out.println("spring의 점수를 입력하세요");
		spring = sc.nextInt();
		
		sum = java+html+spring;
		avg = (sum/3.0);
		grade = (avg>=90?"우등장학생":avg>=80?"50프로 장학금":"노력");
		
		System.out.println("**** "+name+"님의 점수입니다 *****");
		System.out.println("이름:"+name);
		System.out.println("java점수:"+java);
		System.out.println("html점수:"+html);
		System.out.println("spring점수:"+spring);
		System.out.println("총점:"+sum);
		
		System.out.printf("평균:%.1f\n",avg);
		System.out.println("등급은 "+grade+" 입니다.");
		System.out.println("합격여부:"+(java>=50&&html>=50&&spring>=50&&avg>=70?"합격입니다":"불합격입니다."));
		
	}
}
