package christmas_Eve;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex3FileReadWrite {
	static final String FILENAME = "d:naver1210/member.txt";
	
	public static void fileRead() throws IOException{
		FileReader fr =null;
		BufferedReader br = null;
		
		try {
		fr = new FileReader(FILENAME);
		br = new BufferedReader(fr);
		//제목
		System.out.println("\t전체 멤버 명단");
		System.out.println();
		System.out.println("번호\t이름\t나이\t주거지");
		System.out.println("=".repeat(30));
		int n = 0;
		while(true) {
			String line=br.readLine(); //데이터 "이름,나이,주거지" 이런 모양으로 줄예정
			if(line==null)
				break;
			//,로 분리하기
			String []m=line.split(",");
			System.out.println(++n+"\t"+m[0]+"\t"+m[1]+"세\t"+m[2]);
		}
		System.out.println( );
		
		}catch(FileNotFoundException e) {
			System.out.println("** 해당 파일을 찾을 수 없습니다 **");
		}finally {
			if(br!=null) br.close();
			if(fr!=null) fr.close();
		}
		
		
	} 
	public static void fileSave() throws IOException{
		FileWriter fw = null;
		Scanner sc = new Scanner(System.in);
		String name,age,addr;
		
		fw = new FileWriter(FILENAME, true);//추가모드로 생성
		//추가 할 데이터를 입력
		System.out.println("추가할 이름은?");
		name=sc.nextLine();
		System.out.println("추가할 나이는?");
		age=sc.nextLine();
		System.out.println("추가할 주거지는?");
		addr = sc.nextLine();
		
		//파일에 추가
		fw.write(name+","+age+","+addr+"\n");
		
		//파일 닫기
		if(fw!=null) fw.close();
		System.out.println();
		
	}
	public static void fileDelete() {
		
	}
	
	public static int getmenu() {
		int menu=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("1.멤버 추가  2.전체출력  3.전체 멤버 삭제  4.종료");
		try {
			menu =Integer.parseInt(sc.nextLine());
		}catch(NumberFormatException e) {
			menu=2;//메뉴에 문자가 들어올 경우 그냥 2번 전체 출력을 디폴틀 준다.
		}
		return menu; 
	}
		
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Loop:
		while(true) {
			switch(getmenu()) { 
			case 1->fileSave();
			case 2->fileRead();
			case 3->fileDelete();
			default ->{
				System.out.println("프로그램을 종료 합니다.");
				//break Loop;
				System.exit(0);//시스템 정상종료(어디에 있던 프로그램 종료)
			}
			}
		}

	}

}
