package day1216;

public class Ex5String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("String 클래스의 멤버 메소드에 대한 공부");
		String str1 = "Apple";
		String str2 = "Have a nice Day";
		String str3 = "Orange";
		String str4 = new String("Apple");
		
		System.out.println("str1 = "+str1);
		System.out.println("str2 = "+str2);
		System.out.println("str3 = "+str3);
		
		System.out.println("str2 의 길이:"+str2.length());
		System.out.println("Str1의 0번글자:"+str1.charAt(0));
		System.out.println("Str1의 3번글자:"+str1.charAt(3));
		System.out.println();
		System.out.println("str1에서 l의 위치는 "+str1.indexOf('l'));
		System.out.println("str2에서 a의 위치는 "+str2.indexOf('a'));//첫번째 a의 위치 = 1
		System.out.println("str2에서 마지막a의 위치는 "+str2.lastIndexOf('a'));//첫번째 a의 위치 = 1
		System.out.println();
		System.out.println("str3에서 x의 위치는:"+str3.indexOf('x'));//해당 값이 없으면 -1을 반환 
		System.out.println();
		//객체타입에서는 == 동등 연산자가 주소를 비교하는 연산자가 됨 
		System.out.println(str1=="Apple");
		System.out.println(str3 == "Orange");
		System.out.println(str1 == "apple");
		System.out.println(str1 == str4);
		
		//문자열을 정확하게 비교하기 위해서는 Equals 를 사용해야함 .
		System.out.println(str1.equals(str4));
		System.out.println(str1.equalsIgnoreCase("apple"));
		System.out.println("문자열 비교 - compareTo");
		int n=str1.compareTo("Apple");
		int nm = str1.compareTo("apple");
		System.out.println(n);
		System.out.println(nm);
		n=str1.compareTo("Banana");
		System.out.println(n);//-% 는 그냥 알파벳 차이 . 문자열 1이 문자열 2보다 작을 경우 마이너스 값이 나옴. -1:알파벳 'a'하고 'b'하고 비교. 
		n=str3.compareTo(str1);
		System.out.println(n);
		System.out.println();
		System.out.println("str2 를 모두 대문자로 변환: "+str2.toUpperCase());
		System.out.println("str2 를 모두 소문자로 변환: "+str2.toLowerCase());
		System.out.println();
		
		System.out.println("str2 가 Have로 시작하면 True: "+str2.startsWith("Have"));
		System.out.println("str2 가 Have로 시작하면 True: "+str2.startsWith("have"));//대문자 소문자 구분도 해야함 
		System.out.println("str2가 Day로 마치면 true:"+str2.endsWith("Day!"));
		
		System.out.println("=".repeat(50));
		System.out.println(str1.repeat(5));
		System.out.println(str2.replace("a","*"));
		System.out.println(str2.replace("nice","Happy"));
		System.out.println("=".repeat(40));
		System.out.println();
		System.out.println(str2.substring(7));//7번 인덱스 부터 추출 
		System.out.println(str2.substring(7,10));// 7번 인덱스 부터 10번 인덱스 전까지 즉 7,8,9 인덱스 추출.
	}
	

}
