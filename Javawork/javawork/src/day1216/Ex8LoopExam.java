package day1216;

import java.util.Scanner;

public class Ex8LoopExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 입력을 입력하면 그중 
		 * "김" 씨 성을 가진 사람의 인원 수 
		 * "이"씨 성을 가진 사람의 인원수 
		 * 그 이외의 인원 수를 각각 구하여 출력하시오 
		 * startswith, equals
		 */
		String name;
		int kimCount=0,leeCount=0,otherCount=0;
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("이름을 입력하세요:");
			name = sc.nextLine();
			if(name.equals("끝")) {
				break;
			}
			
			if(name.startsWith("김")) {
				kimCount++;
				
			}
			else if(name.startsWith("이")) {
				leeCount++;
			}
			else
				otherCount++;
			
			
		}
		System.out.println("\"김\"의 성을 가진 사람의 수:"+kimCount+"\n\"이\"씨의 성을 가진 사람의 수:"+leeCount+"\n그 이외의 성을 가진 사람의 수:"+otherCount);
		
	}

}
