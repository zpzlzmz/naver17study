package day1219;

public class Ex6VarArgs {
	public static void writeColor(String color1) {
		System.out.println("color1 ="+color1);
	}
	public static void writeColor(String color1,String color2) {
		System.out.println("color1 ="+color1+", color2 ="+color2);
	}
	public static void writeColor(String color1,String color2, String color3) {
		System.out.println("color1 ="+color1+", color2 ="+color2+", color3="+color3);	}
	
	public static void writrName(String ... name) {///은 배열타입으로 전달을 받기 때문에
		System.out.println("name 의 length : "+ name.length);
		if(name.length == 0) {
			System.out.println("멤버가 없습니다");
		}else{
			
			System.out.println("멤버 목록");
			System.out.println("=".repeat(20));
			for(String aa:name) {
				System.out.println(aa+" ");
			}
		}
	} 
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		writeColor("red");
		writeColor("Yello","Black");
		writeColor("Pink","Black","cocoablue");
		//writeColor("Pink","Black","cocoablue","magenta");// 오류 발생 - 해당 오버로딩 메서드 존재 x
		System.out.println();
		System.out.println("Variable Arguments기능을 이용해 인자로 여러 문자열을 보내보자");
		
		writrName("박상범","코준민","김제균","바보똥개","개똥벌래","중식이밴드");
		
		
	}

}
