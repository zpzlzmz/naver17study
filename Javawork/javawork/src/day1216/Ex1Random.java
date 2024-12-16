package day1216;

import java.util.Random;

public class Ex1Random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		1. math.random();
		2. Random
		 * 난수를 구하는 방법이 2가지.
		 */
		
		System.out.println("Math.random() 은 0.0보다 크거나 같고 1.0보다 작은 난수 발생");
		for(int i =1; i<=5; i++) {
			System.out.println(Math.random());
		}
		System.out.println("0부터 9사이의 난수를 구하는 방법");
		for(int i=1; i<=5; i++) {
			int n = (int)(Math.random()*10);
			System.out.print(n+" ");
		}
		System.out.println();
		System.out.println("0부터 99사이의 난수를 구하는 방법");
		for(int i=1; i<=5; i++) {
			int n = (int)(Math.random()*100);
			System.out.print(n+" ");
		}
		System.out.println();
		System.out.println("1부터 10사이의 난수를 구하는 방법");
		for(int i=1; i<=5; i++) {
			int n = (int)(Math.random()*10);
			System.out.print((n+1)+" ");
		}
		System.out.println("Random  클래스를 이용해 난수 구하기");
		Random r = new Random();
		System.out.println("0~9까지의 난수 구하기");
		for(int i = 1; i<=5; i++) {
			int n=r.nextInt(10);
			System.out.print(n +" ");
		}
	
		System.out.println();
		
		System.out.println("1~10까지의 난수 구하기");
		for(int i = 1; i<=5; i++) {
			int n=r.nextInt(10);
			System.out.print(n+1 +" ");
		}
		System.out.println();
		System.out.println("A~Z(65~90)까지의 랜덤 알파벳 구하기");
		for(int i = 1; i<=5; i++) {
			int m=r.nextInt(65,91);
			char b = (char)m;
			System.out.print(b +" ");
		}
		System.out.println();
	}

}
