package day1217;

import java.util.Scanner;

public class Ex11ArraySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String member[] = {"강호동","김태희","손병희","이진아","송중기","김준호","전종원","김재정","박재정","신선일"};
		String searchName;
		boolean find;
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			find = false;
			System.out.print("검색할 이름은?(종료):");
			searchName = sc.nextLine();
			
			if(searchName.equals("종료")) {
				System.out.println("시스템을 종료합니다.");
				break;
			}
			for(int i =0; i<member.length; i++) {
				if(member[i].equals(searchName)) {
					find = true;
					System.err.println(i+1+"번째에 있습니다.");
					break;
				}
				
			}
			if(!find) {
				System.out.println("해당 이름은 시스템에 존재하지 않습니다.");
			}
		}
	}

}
