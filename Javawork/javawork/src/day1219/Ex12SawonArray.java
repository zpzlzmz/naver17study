package day1219;

import java.text.NumberFormat;
import java.util.Scanner;

public class Ex12SawonArray {
	
	
	public static void showTitle() {
		System.out.println("사원명\t직급\t가족수\t기본급\t수당\t가족수당\t세금\t실수령액");
		System.out.println("=".repeat(100));
	}
	public static void writeMySawon(Sawon mySawon) {
		NumberFormat nf = NumberFormat.getInstance();
		System.out.println(mySawon.getSawonName()+"\t"+mySawon.getPosition()+"\t"+mySawon.getFamSu()+"\t"+nf.format(mySawon.getGibonPay((mySawon.getPosition())))
		+"\t"+nf.format(mySawon.getSudang(mySawon.getPosition()))+"\t"+nf.format(mySawon.getFamSudang(mySawon.getFamSu()))
		+"\t"+nf.format(mySawon.getTax())+"\t"+nf.format(mySawon.getNetPay()));
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int inwon;
		
		/*
		 * 인원수를 입력후 인원수 만큼 배열 메모리 할당
		 */
		System.out.println("등록할 직원 수:");
		inwon = Integer.parseInt(sc.nextLine());
		Sawon mySawon[] = new Sawon[inwon];
		
		
		/*
		 * 배열에 데이터 입력 후 생성자 통해서 데이터 저장
		 */
		
		for(int i =0 ; i<mySawon.length; i++) {
			System.out.println("사원명:");
			String sawonName = sc.nextLine();
			System.out.println("직급명:");
			String position = sc.nextLine();
			System.out.println("가족수:");
			int famSu = Integer.parseInt(sc.nextLine());
			
			mySawon[i] = new Sawon(sawonName, position, famSu);
			System.out.println();
		}
		
		/*
		 * 제목 출력
		 * 
		 */
			
		showTitle();
		for(Sawon a:mySawon) {
			writeMySawon(a);
		}
		
		/*
		 * 반복문 통해 데이터 출력 메서드 호출
		 */
	}

}
