package day1217;

import java.util.Scanner;

public class Ex8Alpha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 * 영어 문장을 입력하면 알파벳을 분석해서 각 알파벳의 갯수를 구하시오 (대소문자 상관없이)
 */
		Scanner sc = new Scanner(System.in);
		String message;
		int alpha[] = new int[26];
		
		System.out.print("영어 문장을 입력하세요:");
		message = sc.nextLine();
		
		for(int i = 0; i<message.length(); i++) {
			char ch=message.charAt(i);
			//대문자인경우'A'를 뺀 번지수를 1증가
			if(ch>='A' && ch<='Z')
				alpha[ch-'A']++;
			else if(ch>='a'&&ch<='z')
				alpha[ch-'a']++;
			
		}
		
		for(int i =0; i<alpha.length;i++) {
			//System.out.printf("%c:%d개\t",'A'+i,alpha[i]);
			System.out.print((char)(('A')+i)+":"+alpha[i]+"\t");
			if((i+1)%4==0)
				System.out.println();
		}
		
		
		
		
		
		
		
		
		
	} 

}
