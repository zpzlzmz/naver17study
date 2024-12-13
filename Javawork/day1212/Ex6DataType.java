package day1212;

public class Ex6DataType {
	public static void main(String []agrs) {
		String str1="Hello";
		String str2 = new String("Happy!");
		System.out.println(str1);
		System.out.println(str2);
		System.out.println("\t\t"+str1);
		
		//printf 에서 문자열의 변환기호는 %s.
		System.out.printf("%s\n",str1);
		System.out.printf("%30s\n",str1);
		System.out.printf("%40s\n",str1);
		System.out.printf("**%-30s**\n",str1); 
		
		//문자열에서 + 연산자는 나열을 의미.
		System.out.println(str1+str2);
	}

}
