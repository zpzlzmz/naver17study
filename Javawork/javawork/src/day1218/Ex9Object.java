package day1218;


class Car{
	static String carCompony ="현대";
	
	private String carName;
	private int carPrice;
	
	public static void setCarCompony(String carComnpony) {
		//static 메서드에서는 static 변수만이 접근 가능하다.
		Car.carCompony = carComnpony;
	}
	public void setCarName(String carName){
		this.carName = carName;
	}
	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}
//	public void carDisplay(){
//		System.out.println(carName);
//		System.out.println(carPrice);
//	}
	//getter method의 규칙 
	public String getCarName() {
		return carName;
	}
	public int getCarPrice() {
		
		return carPrice;
	}
	public void setData(String carName, int carPrice) {
		this.setCarName(carName);
		this.setCarPrice(carPrice);
	}
}

public class Ex9Object {
	
	
	public static void writeCarInfo(Car myCar) {
		System.out.println("=".repeat(30));
		System.out.println("자동차명: "+myCar.getCarName());
		System.out.println("가격: "+myCar.getCarPrice());
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("현재 자동차 회사명:"+Car.carCompony);
		Car.setCarCompony("삼성");
		System.out.println("변경된 자동차 회사명:"+Car.carCompony);
		
		Car car1 = new Car();
		car1.setCarName("그랜져");
		car1.setCarPrice(3900);
		
		Car car2 = new Car();
		car2.setData("소나타", 3200);
		
		Car car3=new Car();
		car3.setData("mini",6000);
		
		System.out.println("car1 자동차명:" +car1.getCarName());
		System.out.println("car1 자동차 가격:" +car1.getCarPrice());
		System.out.println("car2 자동차명:" +car2.getCarName());
		System.out.println("car2 자동차 가격:" +car2.getCarPrice());
		
		
//		cars.setCarName("제네시스");
//		cars.setCarPrice(100000000);
////		cars.carDisplay();
//		cars.getCarName();
//		cars.getCarPrice();
		writeCarInfo(car1);
		writeCarInfo(car2);
		writeCarInfo(car3);
		
		
	}
	

}
