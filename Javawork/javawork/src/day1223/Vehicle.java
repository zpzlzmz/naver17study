package day1223;

public class Vehicle {
	public void run() {
		System.out.println("차량이 달립니다.");
	}
}

class Bus extends Vehicle{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("버스가 달립니다.");
	}
}

class Taxi extends Vehicle{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("택시가 달립니다.");
	}
}

class Driver{
	public void drive(Vehicle vehicle) {
		vehicle.run();
	}
}