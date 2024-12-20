package day1220;

import day1220_2.Apple;

class Orange extends Apple{
	
	public void play() 
	{
		this.job();//public
		this.study();//protected
		this.process();//현재 클래스의 오버라이드 메서드가 출력됨(Override 가 되면 부모 메서드가 숨겨짐)
		//this.draw();//패키지가 다를경우 상속관계라 하더라도 접근 불가( 
	}
	@Override
	protected void process() { // Override 받을때 protected 로 받았으면 접근자는 동일한 접근자나 더 넗은 접근자만 허용함(default 나 private는 사용불가)
		// TODO Auto-generated method stub
		super.process();
		System.out.println("Oracle,MySql 공부를 더 깊게 합니다.");
	}
	
}



public class Ex4Inherit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Orange or=new Orange();
		or.play();
	}

}
