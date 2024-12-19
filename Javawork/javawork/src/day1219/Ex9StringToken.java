package day1219;

import java.util.StringTokenizer;

public class Ex9StringToken {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String msg="red,green,yellow,white,black";
		String msg="red|green|yellow|white|black";
//		// | 로 분리
//		String arr[] = msg.split(",");// 이거 잘 안됨 ㅋㅋ 
//		
//		for(String a:arr) {
//			System.out.print(a+" ");
//		}
		StringTokenizer st = new StringTokenizer(msg,"|");
		System.out.println("분리할 총 토큰수 : "+st.countTokens());
		
		//countTokens는 토큰의 읽을때마다 갯수가 줄어듬(남은 토큰수라고 생각하면 됨)
		//이런식으로 반복문을 돌리면 3번만 반복 
//		for(int i =0; i<st.countTokens(); i++) {(안됨)
//			System.out.println(st.nextToken());//nextToken element는 Object 타입이라 String 으로 형 변환을 한번 더 해야함
//		}
//			
		//방법 1 token의 갯수를 미리 저장해 for문 범위에 적용
		int count = st.countTokens();
		for(int i=0;i<count ; i++) {
			System.out.println(st.nextToken());
		}
		
		System.out.println("=".repeat(50));
		StringTokenizer st2 = new StringTokenizer(msg,"|");
		//방법2 
		while(st2.hasMoreTokens()) { //토큰은 사용하면 사라짐 . 즉)토큰이 있는동안 계속 돌며, 다 돌고 토큰이 안남으면 자동으로 false
			System.out.println(st2.nextToken());
		}
		
		System.out.println();
		
		String arr2[] = msg.split("|");
		System.out.println("총 "+arr2.length+"개");
		
		String arr3[] = msg.split("\\|");
		System.out.println("총 "+arr3.length+"개");
		
		for(String a:arr3) {
			System.out.print(a+" ");
		}
		
		System.out.println();
		
		//아래 데이터를 .으로 분리 하여 출력
		
		String msg2 = "이미자.손태영.강호동.이영자.박진아";
		String arr4[] = msg2.split("\\.");
		System.out.println("총 "+arr4.length+"개");
		System.out.println("=".repeat(50));
		for(String a:arr4) {
			System.out.print(a+" ");
		}
		
	}

}
