package day1223;




public class CarExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car myCar = new Car();
		
		myCar.tire = new Tire();
		myCar.run();
		System.out.println();
		myCar.tire = new HankookTire();
		myCar.run();
		System.out.println( );
		myCar.tire = new KumhoTire();
		myCar.run();
		
	
	
	}

}
