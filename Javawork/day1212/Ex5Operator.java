package day1212;

public class Ex5Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x,y,max;
		x=13;
		y=13;
		max = x>y?x:y;
		System.out.println("max="+max);
		
		int z = 10;
		
		max = x>y&&x>z?x:y>x&&y>z?y:z;
		System.out.println("max="+max);
		
		int score = 89;
		char grade;
		grade = score>=90?'A':score>=80?'B':score>=70?'C':score>=60?'D':'F';
		System.out.println(score+"점은 "+grade+"학점 입니다.");
		 
		
		System.out.println(score+"점수는 "+(score>=90?"good":"try"));
		
	}
	
}

