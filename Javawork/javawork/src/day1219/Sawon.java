package day1219;




public class Sawon {
	/*
	 * 멤버 변수 사원명 sawonName, 지급 position, 가족 수 famSu private 으로 선언 
	 */
	private String sawonName;
	private String position;
	private int famSu;
	
	
	
	/*
	 * 디폴트 생성자 () 줄게 없어도 기본적으로 만들어 두는게 좋음 
	 */
	public Sawon() {
		System.out.println("입력된 정보가 없습니다. 제대로 실행 하시오");
	}
	
	
	/* 사원명 ,직급, 가족수 를 인자로 받는 생성자()
	 */
	public Sawon(String sawonName, String position, int famSu) {
		this.sawonName = sawonName;
		this.position = position;
		this.famSu = famSu;
	}
	
	/*
	 * setter &getter method - 다만들기
	 */
	

	public String getSawonName() {
		return sawonName;
	}


	public void setSawonName(String sawonName) {
		this.sawonName = sawonName;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public int getFamSu() {
		return famSu;
	}


	public void setFamSu(int famSu) {
		this.famSu = famSu;
	}
	

	
	
	/* 직급에 따라 기본급을 구하는데 부장-450, 과장-300, 대리 -250, 사원 - 150
	 * getGibonPay() -로 만드쇼 
	 *  
	 */
	public int getGibonPay(String position) {
		int gibonPay = switch(position) {
		case "부장" ->450;
		case "과장" ->300;
		case "대리" ->250;
		case "사원" ->150;
		default ->0;
		};
		
		return gibonPay;
	}
	
	/*
	 * 직급에 따라 수당을 구함 부장,과장 -> 70 대리->50
	 * getSudang ()
	 */
	public int getSudang(String position) {
		int sudang = switch(position) {
		case "부장","과장" -> 70;
		case "대리" -> 50;
		default ->0;
		};
		return sudang;
	}
	
	/*
	 * getGibonPay()값을 반환 받아서 세금 5%를 구해서 반환하는 getTax();
	 * 다 메서드로 구현하기 
	 */
	
	public int getTax() {
		double Tax = (getGibonPay(position)*0.05);
		return (int)Tax;
	}
	
	
	/*
	 * 가족수가 5인 이상이면 30반환 
	 * 5인 미만은 2인 이상은 10반환 나머지는 0
	 * getFamSudang
	 */
	public int getFamSudang(int famSu) {
		int FamSudang;
		if (famSu>=5)
			FamSudang = 30;
		else if(famSu>=2 && famSu<5)
			FamSudang = 10;
		else
			FamSudang = 0;
		 
		return FamSudang;
		}
	
	
	
	/*
	 * 실수령 액을 구해서 반환하는 메서드 기본급+수당-세금 +가족수당
	 * getNetPay
	 */
	public int getNetPay() {
		int total = (int) (this.getGibonPay(position)+this.getSudang(position)+this.getFamSudang(famSu)-this.getTax());
		
		return total;
	}
}

//이거 다 겟터에 받을수 있는지 ? 
