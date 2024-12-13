package day1212;

import java.util.Scanner;

public class Ex15If {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String sang;
		int su,dan,total;
		double detotal;
		System.out.println("상품명을 입력해주세요");
		sang = sc.nextLine();
		System.out.println("수량을 입력하세요");
		su = sc.nextInt();
		System.out.println("단가를 입력하세여");
		dan = sc.nextInt();
		
		total = su*dan;
		detotal = total*0.9;
		
		System.out.println("상품명:"+sang);
		System.out.println("수량:"+su);
		System.out.println("단가:"+dan);
		System.out.println("총금액:"+total);
		if(su>=5) 
			System.out.println("10프로 DC된 금액은 "+(int)detotal+" 입니다.");
		
		
	}

}
