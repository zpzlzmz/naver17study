package day1217;

import java.net.MulticastSocket;

public class Ex2Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] ch;
		ch = new char[4];
		System.out.println("배열크기:"+ch.length);
		ch[0] = 'h';
		ch[1] = 65;
		ch[2] = 122;
		ch[3] = 't';
		
		for(int i = 0; i<ch.length; i++) {
			System.out.println("ch["+i+"]="+ch[i]);
		}
		System.out.println();
		//다른 출력 방법
		for(char a:ch)
			System.out.println(a);
		
		System.out.println("=".repeat(50));
		char []ch2 = new char[5];
		ch2 = new char[] {'a','n','x','y','u'};
		for(int i = 0 ; i <ch2.length; i++) {
			System.out.println("ch2["+i+"]="+ch2[i]);
		}
		 System.out.println("=".repeat(50));
		 char []ch3 = {'s','r','t','v','i'};
		 for(char a:ch3)
			 System.out.println(a);
	}

}
