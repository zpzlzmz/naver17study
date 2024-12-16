package day1216;

public class Ex10gugudan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 2; i<=9; i++) {
			System.out.printf("[%d단]	",i);
		}
		System.out.println();
		System.out.println("=".repeat(70));
		
		for(int i = 1; i<=9; i++) {
			for(int j = 2; j<=9; j++) {
				System.out.printf("%dx%d=%d	",j,i,i*j);
			}
			System.out.println();
		}
	}
}