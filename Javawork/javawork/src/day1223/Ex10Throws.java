package day1223;

import java.util.Scanner;

public class Ex10Throws {
	public static void sum(String a,String b) throws NumberFormatException{
		int su1 = Integer.parseInt(a);
		int su2 = Integer.parseInt(b);
		int sum=su1+su2;
		System.out.println(a+"+"+b+"="+sum);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 1 입력");
		String su1 = sc.nextLine();
		System.out.println("숫자 2 입력");
		String su2 = sc.nextLine();
		
		try {
		sum(su1,su2);
		}catch(NumberFormatException e) {
			System.out.println("오류발생:"+e.getMessage());
		}finally {
			System.out.println("Hello");
		}
		System.out.println("** 정상종료 **");
	}

}
