package day1220;

import java.util.Scanner;

/*
 * comnmand 라는 인터페이스에 process() 추상메서드 추가
 * 인터페이스 Command 를 구현하는 List(출력),insert,delete,update(수정) 클래스를 구현하시오
 * 
 * 메인에서 While 문을 통해 다음과 같이 메뉴가 나오면
 * 1.추가 2.출력 3.삭제 4.수정 5.종료
 * 
 * 1번을 누르면 데이터가 추가되었씁니다
 * 2번을 누르면 데이터를 출력합니다
 * 3번을 누르면 데이터가 삭제되었습니다.
 * 4번을 누르면 데이터가 수정되었습니다
 * 5번을 누르면 프로그램을 종료합니다( default 나 else로 주면됨)
 * '
 * 호출하는 method는 public static void dbProcess(Command comm)
 * {comm.process();}<- 이부분이 다형성 처리가 되도록.
 * 
 * 
 * 
 */


interface Command{
	int n = 0;
	public void process();
	
}

class Comm implements Command{
	
	int pushNum = n;

	@Override
	public void process() {
		// TODO Auto-generated method stub
		
	}
	
}

class List implements Command{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("데이터가 출력됩니다.");
	}
}

class Insert implements Command{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("데이터가 추가됩니다.");
	}
	
}

class Delete implements Command {
	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("데이터가 삭제됩니다.");
	}
}

class Update implements Command {
	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("데이터가 수정되었습니다.");
	}
}

public class Ex11InterfaceMunje {
	
	public static void dbProcess(Command comm) {
		comm.process();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = 0;
		
		while(true) {
			System.out.println("1. 추가\t2. 출력\t3. 삭제\t4. 수정\t5.종료");
			n = sc.nextInt();
			if(n == 1)
				dbProcess(new Insert());
			else if(n==2)
				dbProcess(new List());
			else if (n == 3)
				dbProcess(new Delete());
			else if (n == 4)
				dbProcess(new Update());
			else {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
		}
		

	}

}
