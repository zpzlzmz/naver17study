package day1217;

import java.util.Scanner;

public class Ex12ArraySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String member[] = {"강호동","김태희","손병희","이진아","송중기","김준호","전종원","김재정","박재정","신선일"};
		String searchName;
		
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			System.out.println("검색할 성씨는?(종료:exit)");
			searchName = sc.nextLine();
			int count=0;
			if(searchName.equalsIgnoreCase("exit"))
				break;
			
			for(int i =0; i<member.length; i++) {
				if(member[i].startsWith(searchName)) {
					count +=1;
					System.out.println(member[i]);
					System.out.println("총 "+count+"명 검색 완료");
				}
				
			}
			if(count == 0) {
				 System.out.println("\""+searchName+"\"씨 성을 가진 사람은 없습니다");
			}
		}
	}

}

