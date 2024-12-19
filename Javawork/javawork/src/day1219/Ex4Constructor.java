package day1219;



class Orange {
	private String name;
	private String color;
	private int age;
	//생성자
	
	Orange(){
//		this.name ="이말자";
//		this.color ="Yello";
//		this.age =30;
		//생성자에서 생성자를 호출할 때 this() 를 사용함
		this("이말자","노랑");//인자가 맞는 생성자가 호출
	}
	
	Orange(String name,String color){
		this.name = name;
		this.color =color;
		this.age = 20;
	}
	public void writeMember() {
		System.out.println("name = "+name+",color = "+color+",age= "+age);
	}
	
	public void writeMember(int n) {//method overloading (매서드 이름은 같고 인자가 다른것)
		if(n==1) {
			System.out.println("이름 : "+name);
			System.out.println("좋아하는 생상: "+color);
			System.out.println("나이 : "+age);
			System.out.println("=".repeat(30));
		}
		else if(n == 2) {
			System.out.println(name+"님은 "+color+" 색상을 좋아합니다");
		}else {
			System.out.println("1 또는 2 만 가능합니다.");
		}
	}
	
	
}

public class Ex4Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Orange a1 = new Orange();
		a1.writeMember();//생성자로 생성하면 default 로 생성은 다 됨.
		Orange a2 = new Orange("고민시","파랑");
		a2.writeMember();
		a2.writeMember(1);
		a2.writeMember(2);
		a2.writeMember(3);
	}

}
