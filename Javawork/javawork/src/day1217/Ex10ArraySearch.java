package day1217;

import java.util.Scanner;

public class Ex10ArraySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int datas[]= {12,55,6,7,8,15,36,12,9,71};
		System.out.println("갯수:"+datas.length);
		int searchNum;
		boolean find;
		Scanner sc = new Scanner(System.in);
		/*
		 * 숫자를 입력하면 그 숫 자가 몇번째 있는지 출력 -> 없으면 해당 숫자가 없습니다 라고 출력.
		 * 0입력시 검색 종료
		 */
		while(true) {
			find = false; //입력값을 찾았을 경우 true로 변경 
			System.out.print("검색할 숫자는?(종료:0)");
			searchNum = sc.nextInt();
			if(searchNum == 0) {
				System.out.println("프로그램 종료");
				break;
			}
			for(int i =0; i<datas.length; i++) {
				if(searchNum == datas[i]) {
					find = true;
					System.out.println((i+1)+"번째에 있습니다");
					break;
				}
				
			}
			if(!find) {
				System.out.println("해당 숫자는 없습니다.");
			}
		}
		
		
		
		
	}

}
