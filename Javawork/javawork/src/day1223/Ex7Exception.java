package day1223;

import java.util.Date;

public class Ex7Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr = {4,5,6,7,12};
		for(int i =0 ; i<=arr.length; i++) {
			try {
			System.out.println(arr[i]);
			//}catch(ArrayIndexOutOfBoundsException e) { // 에러가 발생했을때 어떤 에러가 발생했는지 알기위해서 e.getmessage를 씀.
				//또한 try catch 를 쓰면 에러가 발생해도 끝까지 실행 가능
			}catch(Exception e) {
				
				System.out.println("오류메세지: "+e.getMessage());
				e.printStackTrace(); //오류 추적을 해서 행번호도 표시 해줌
			}
		}
		
		
		System.out.println();
		Date date=null;
		try {
			int age = date.getYear()+1900-1989;
			System.out.println("age = "+age);
		}catch(NullPointerException e){
			System.out.println("오류메세지 "+e.getMessage());
		}
		
		
		System.out.println("정상종료");
		
		
	}

}
