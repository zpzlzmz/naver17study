package day1219;

public class Ex7VarArgs {
	
	public static int calcNum(int ... n) {
		int sum = 0;
		System.out.println("총 "+n.length+"개의 점수");
		for(int score:n) {
			System.out.print(score+" ");
			sum += score;
		}
		System.out.println();
		return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s1 = calcNum(90,80);
		System.out.println("합계는:"+s1);
		int s2 = calcNum(60,100,80,70,50,30,20,34,50,66);
		System.out.println("합계는:"+s2);
	}

}
