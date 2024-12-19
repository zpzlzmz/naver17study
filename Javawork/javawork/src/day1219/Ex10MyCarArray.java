package day1219;

public class Ex10MyCarArray {

	public static void showTitle() {
		System.out.println("자동차명\t가격\t색상\t구입일");
		System.out.println("=".repeat(50));
	}
	public static void writeMyCar(MyCar MyCar) {
		System.out.println(MyCar.getCarName()+"\t"+MyCar.getCarPrice()+"\t"+MyCar.getCarColor()+"\t"+MyCar.getGuipDay());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyCar my1=new MyCar();
		System.out.println(my1);//toString 이 있을경우 자동 호출(to String 이 없으면 주소가 나옴) 
		
		MyCar my2= new MyCar("소나타",3900,"진주색");
		System.out.println(my2);
		//생성자를 이용해보기 (setter getter)
		System.out.println("객체 배열 생성");
		
		//방법1
//		MyCar carArray[] = {
//				new MyCar(),
//				new MyCar("그랜져",5600,"검은색"),
//				new MyCar("BMW",6800,"흰색")
//		};
	
		//방법 2
		MyCar carArray[] = new MyCar[3];
		carArray[0] = new MyCar();
		carArray[1] = new MyCar("그랜져",5600,"검은색");
		carArray[2] = new MyCar("BMW",6800,"흰색");
		//제목출력 
		
		showTitle();
		//for문으로 데이터 출력 꼭 타입이 아니라 해당 클래스 등이 들어갈 수 있음.
//		for(MyCar my:carArray ) {
//			writeMyCar(my);
//			
//		}
		for(int i =0; i<carArray.length; i++) {
			writeMyCar(carArray[i]);
		}
	}
	
}
	


