package day1213;

public class Ex5While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1;
		while(a<10) {
			System.out.println("while loop");
			a++;
	
		}
	//do while 은 일단 한번 실행ㄹ후 조건을 비교하므로 조건이 맞지 안하도 쵯 ㅗ한번은 문장이 실행된다
		do {
			
			System.out.println("do-while loop");
			
		}while(a<10);
	
		a = 1;
		while(a<=10) {
			System.out.printf("%3d",a++);
		}
		
		System.out.println();
		a = 1;
		while(true)
		{
			System.out.printf("%3d",a++);
			if(a>10)
				break;
			
		}
		System.out.println();
		a =0;
		while(a<10) {
			System.out.printf("%3d",++a);
			
		}
		System.out.println();
		a = 1;
		do {System.out.printf("%3d",a++);}while(a<=10);
	
	}
	

}