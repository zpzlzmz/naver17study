package day1223;


interface InterA{
	public void study();
}

//인터페이스끼리의 상속은 Extends 
interface InterB extends InterA{
	public void play();
}
///클래스가 인터페이스를 구현 시 implements 를 사용해야함
class MyInter implements InterB{
	@Override
	public void play(){
		System.out.println("그룹 모임을 합니다.");
	}
	
	@Override
	public void study(){
		System.out.println("그룹 스터디를 합니다.");
	}
	
	public void job() {
		System.out.println("밀린 일 처리를 합니다.");
	}
}

public class Ex1InterfacInherit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InterA interA = new MyInter();
		interA.study();
		((MyInter) interA).job();
		System.out.println("=".repeat(30));
		InterB interB = new MyInter();
		interB.play();
		interB.study();
		//다운 캐스팅을 사용해 interB에서 Job을 호출할려고 함
		((MyInter) interB).job();
		System.out.println("=".repeat(30));
		MyInter myInter = new MyInter();
		myInter.play();
		myInter.study();
		myInter.job();

	}

}
