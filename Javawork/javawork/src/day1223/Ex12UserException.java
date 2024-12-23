package day1223;


class UserException extends Exception{
	public UserException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
}

/////////////////////////

public class Ex12UserException {
	
	public static void inputName(String name) throws UserException{
		if(name.equals("김태희")|| name.equals("송혜교"))
			throw new UserException("거짓 이름을 말하고 있네요"); // Exception 강제 발생.
		else
			System.out.println("내 이름은 "+name+" 입니다.");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			inputName("성시경");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			inputName("김태희");
		} catch (UserException e) {
			// TODO Auto-generated catch block
			System.out.println("오류메세지: "+e.getMessage());
		}
		System.out.println("** 정상 종료 **");
	}

}
