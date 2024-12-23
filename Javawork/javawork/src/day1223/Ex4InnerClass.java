package day1223;

abstract class AbstSawon{
	abstract public void addSawon();
	abstract public void removeSawon();
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
interface InnerSales{
	public void insertSangpum();
	public void selectSangpum();
	
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//위의 클래스와 인터페이스를 익명 내부 클래스 형태로 구현후 메인에서 호출하시오.






public class Ex4InnerClass {
	
	
	AbstSawon sawon1 = new AbstSawon() {
		
		@Override
		public void removeSawon() {
			// TODO Auto-generated method stub
			System.out.println("DB에 존재하는 직원을 삭제합니다.");
			
		}
		
		@Override
		public void addSawon() {
			// TODO Auto-generated method stub
			System.out.println("DB에 새로운 직원을 추가합니다.");
		}
	};
	
	InnerSales Inner = new InnerSales() {
		
		@Override
		public void selectSangpum() {
			// TODO Auto-generated method stub
			System.out.println("입력한 상품을 고릅니다.");
			
		}
		
		@Override
		public void insertSangpum() {
			// TODO Auto-generated method stub
			System.out.println("입력한 상품을 추가합니다.");
			
		}
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Ex4InnerClass ex4 = new Ex4InnerClass();
		ex4.sawon1.addSawon();
		ex4.sawon1.removeSawon();
		System.out.println();
		ex4.Inner.insertSangpum();
		ex4.Inner.selectSangpum();

	}

}
