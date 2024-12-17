package day1217;

public class Ex5ArrayExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data[] = {23,100,-52,49,20,77,10,3,101,1};
		int max=data[0];
		int min = data[0];
		for(int i=0; i<data.length; i++) {
			if(max<data[i])
				max = data[i];
			
			if(min>data[i])
				min = data[i];
			
		}
		System.out.println(max);
		System.out.println(min);
	}

}
