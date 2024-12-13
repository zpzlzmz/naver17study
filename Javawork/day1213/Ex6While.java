package day1213;

public class Ex6While {

	public static void main(String[] args) {
		// TODO Auto-generated ;
		int a = 65;
//		while(a<=90) {
//			
//			//System.out.printf("%c",a++);
//			System.out.print((char)a++);
//		}
		System.out.println();
		char b = 'a';
		do {
			System.out.print(b);
			b++;
		}while(b<='z');
	
		System.out.println();
		int n = 0;
		while(n<=10) { 
			n++;
			if(n%2==0)
				continue;
			System.out.printf("%3d",n++);
		}
		
	
	}
	

}


