package day1220;


class SuperObj2{
	private String schoolName;
	
	
	public SuperObj2() {
		// TODO Auto-generated constructor stub
		schoolName = "청담고등학교";
		
	}
	
	SuperObj2(String schoolName){
		this.schoolName = schoolName;
	}
	
	public void write() {
		System.out.println("학교명: "+schoolName);
	}
}

class SubObj2 extends SuperObj2{
	
	private String studentName;
	
	public SubObj2(){
		studentName = "이름없음";
		
	}
	@Override
	public void write() {
		// TODO Auto-generated method stub
		super.write();//부모가 처리한 로직을 싱행 -> 호출 위치는 상관없음 꼭 처음이 아니여도됨   
		System.out.println("학생명:"+studentName);
	}
	
	SubObj2(String schoolName, String studentName){
		super(schoolName);
		this.studentName = studentName;
		
	}
	
}



class SubObj22 extends SuperObj2{
	private String teacherName;
	
	public SubObj22() {
		teacherName = "이름없음";
	}
	
	SubObj22(String SchoolName, String teacherName){
		super(SchoolName);
		this.teacherName = teacherName;
	}
	@Override
	public void write() {
		// TODO Auto-generated method stub
		super.write();
		System.out.println("선생명:"+teacherName);
	}
	
}
////////////////////////////////////////////////////////////////////////////



public class Ex2Inherit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubObj2 sa1 = new SubObj2();
		SubObj2 sa2 = new SubObj2("강남고등학교","성동일");
		SubObj22 sa3 = new SubObj22("코코고등학교","김재남");
		sa2.write();
		System.out.println();
		sa3.write();
	}

}
