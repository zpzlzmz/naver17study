package day1217;

public class Ex4Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1[];
		str1 = new String[5];//객체인 경우 Null롤 들어감 ㅋㅋ 
		str1[0] = "Hello";
		str1[1] = "Sweet";
		str1[2] = "Kitty";
		for(int i=0;i<str1.length; i++) {
			System.out.println("str1["+i+"] = "+str1[i]);
		}
		
		System.out.println("=".repeat(50));
		
		String str2[];
		str2 = new String[] {"green","pink","red","yellow"};
		for(String s:str2)
			System.out.println(s);
	
		System.out.println("=".repeat(50));
		
		String str3[] = {"김미나","안지영","홍길동","강한나"};
		
		for(String s:str3)
			System.out.println(s);
	
	
	}
	 

}
