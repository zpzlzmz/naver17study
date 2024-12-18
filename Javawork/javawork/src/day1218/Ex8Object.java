package day1218;

class Orange{
	public static final String MESSAGE = "Happy";
	private String name;
	private int age;
	
	public void showData() {
		//일반 멤버 메서드는 this 라는 인스턴스 변수를 가지고 있다 -> 그래서 this.name 이런식으로 접근 가능 (this 는 경우에 따라 생략가능)
		//static 멤버 메서드에는 이른 this가 없음.
		System.out.println("이름은:"+this.name);
		System.out.println("나이는:"+this.age);
	}
	//값을 변경하기 위한 Setter Method 를 만들어 보자 
	
	public void setName(String name) {//setter 메서드의 기본 규칙
		//같은 구역에 멤버와 같은 이름의 변수가 있을경우 멤버변수 앞에 반드시 this 를 붙인다 
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
}




public class Ex8Object {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(Orange.MESSAGE);
		Orange orange = new Orange();
		
		//System.out.println(a.name);// private 변수는 직접 접근 불가 -> 오류 발생
		orange.showData();
		orange.setName("김태희");
		orange.setAge(30);
		orange.showData();
		
		
	}
}
