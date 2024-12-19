package day1219;

/*
 * CallByValue : 값만 전달(기본형, String);
 * CallByReference : 주소가 전달(모든 객체, 배열타입)
 */

class Test{
	String message;
	int code;
	
}
///////////////////////////////////////////////////

public class Ex5Callby {
	
	public static void changeInt(int n) {//주소가 다르게 새로 생성
		n = 200;
	}
	
	public static void changeString(String s) {
		s = "Apple";
				
	}
	public static void changeTest(Test t) {
		t.message = "Happy";
		t.code = 100;
	}

	
	public static void changeArray(int arr[]) {
		arr[1] = 20;
	}
	public static int changeScore(int score) {//기본형을 callbyreference 로 하기 위해서는 void 대신 해당 값의 타입으로 return 을 받아야함(여기서는 int)
		if(score >=80)
			return score;
		else
			return 90;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n =100;
		String s = "Orange";
		changeInt(n);
		System.out.println("n="+n);//값만 전달이 되기때문 Call by value (주소값이 다르기 때문에 n에 200이 들어가지않음)
		changeString(s);//값만 전달
		System.out.println("s="+s);//마찬가지로 값만 전달 
		Test t = new Test();
		System.out.println("message = "+t.message+",code = "+t.code);
		changeTest(t);//주소가 전달
		System.out.println("message = "+t.message+",code = "+t.code);
		int a[] = {5,8,11};
		changeArray(a);//주소가 전달 
		for(int aa:a) {
			System.out.println(aa+ " ");
			System.out.println();
		}
		
		int score1 = 80;
		int score2 = 40;
		score1 = changeScore(score1);
		score2 = changeScore(score2);
		System.out.println(score1);
		System.out.println(score2);
		//값 만 전달되는 경우는 메서드에서 변경된 값을 받으려면 return 으로 받아와야함 .
		
	}

}
