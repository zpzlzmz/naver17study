package day1216;

public class Ex9LoopExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		System.out.println("다중 For문을 이용해 * 찍어보기");
		for(int i =1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				System.out.print("*");
			}
			System.out.println();
			
		}
		System.out.println("=".repeat(15));
	
		for(int i =1;i<=5;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
			
		}
		System.out.println("=".repeat(15));
	
		for(int i=1;i<=5;i++) {
			for(int j=5;j>=i;j--) {
				System.out.print("*");
			}
			System.out.println();
			
		}
		System.out.println("=".repeat(15));
		
		for(int i =1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				System.out.print("*");
			}
			System.out.println();
			
		}
		System.out.println("=".repeat(15));
		
	}

}
