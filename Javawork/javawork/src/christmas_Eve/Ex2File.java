package christmas_Eve;

import java.io.File;

public class Ex2File {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file1=new File("d:/naver1210/score.txt");
		File file2 = new File("d:/naver1210");
		System.out.println(file1.length()); //글자길이
		System.out.println(file1.canExecute());
		System.out.println(file1.canRead());
		System.out.println(file1.canWrite());

		
		System.out.println(file1.exists());//파일이 존재하면 truee
		System.out.println(file1.isDirectory());//false , 디렉토리인가? -> 파일이기 때문에 false
		System.out.println(file2.isDirectory());//ture , 디렉토리가 맞음
		System.out.println(file1.isFile());//true -> 파일이 맞기 떄문
		System.out.println(file2.isFile());//false -> 경로이ㅣ때문
		
		//file1이 디렉토리면 목록을 출력해라
		if(file1.isDirectory()) {
			String []list = file1.list();
			for(String s:list)
				System.out.println(s);
		}else {
			System.out.println("File1 은 파일입니다.");
		}
		if(file2.isDirectory()) {
			System.out.println("** File2의 파일목록 **");
			String []list = file2.list();
			for(String s:list)
				System.out.println(s);
		}else {
			System.out.println("File2 은 파일입니다.");
		}
		System.out.println("=".repeat(30));
		System.out.println(file1.getAbsolutePath());//d:/naver1210/score.txt
		System.out.println(file1.getName());//score.txt
		System.out.println(file1.getPath());//d:/naver1210/score.txt
		
	}

}
