package day1216;

public class Ex4ForLabel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Loop:
			for(int i =1; i<=3; i++) {
				for(int j = 1; j<=4; j++) {
					//if(i==2)
						//continue Loop;
					//if(j==3)
						//continue Loop;
					if(j==3)
						break;
					System.out.println("i="+i+",j="+j);
				}
			}
	}

}
