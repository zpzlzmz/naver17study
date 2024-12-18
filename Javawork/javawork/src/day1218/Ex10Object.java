package day1218;

import java.text.NumberFormat;

public class Ex10Object {
	
	public static void showTitle() {
		System.out.println("번호\t자동차명\t가격");
		System.out.println("=".repeat(50));
	}
	public static void writeCar(int num,Car myCar) {
		NumberFormat nf=NumberFormat.getInstance();
		System.out.println(num+"\t"+myCar.getCarName()+"\t"+nf.format(myCar.getCarPrice())+"만원");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//객체 배열 
		Car cars[]=new Car[5];//배열 메모리 할당시 객체는 생성된 값이 들어가는게 아니라 무조건 초기값이 NULL -> 매서드 호출을 하려고하면 에러가 발생(Null point inception)
		//배열 5개의 각 Car객체는 따로 생성해줘야함 위에문은 그냥 배열 메모리 5개 할당 선언하는거
		for(int i =0; i<cars.length; i++) {
			cars[i] = new Car();
		}//이렇게 해야 메서드 호출이 가능함.
		
		cars[0].setData("그랜져",5600);
		cars[1].setData("제네시스",7600);
		cars[2].setData("Soul",3600);
		cars[3].setData("K5",3600);
		cars[4].setData("아우디",6600);
		//제목부터 출력
		showTitle();
		//내용 출력
		for(int i =0;i<cars.length;i++) {
			writeCar(i+1,cars[i]);
		}
	
	//다른방밥
	System.out.println();
	int n = 0;
	for(Car car:cars) {
		writeCar(++n,car);
	}
	
	
	}

}
