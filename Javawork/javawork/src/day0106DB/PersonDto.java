package day0106DB;

public class PersonDto {
	private int num;
	private String name;
	private String blood;
	private int age;
	private String hp;

	public PersonDto() {
		// TODO Auto-generated constructor stub
	}

	public PersonDto( String name, int age, String blood, String hp) {
		super();
		this.name = name;
		this.age = age;
		this.blood = blood;
		this.hp = hp;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBlood() {
		return blood;
	}

	public void setBlood(String blood) {
		this.blood = blood;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}
	
	
	
}


