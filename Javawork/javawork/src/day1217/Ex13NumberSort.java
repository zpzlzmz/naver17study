package day1217;

public class Ex13NumberSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data[]= {1,6,2,5,4,3};
		//selection sort

		
		for(int i=0; i<data.length-1; i++)
		{
			for(int j=i+1; j<data.length; j++) {
				//if(data[i]>data[j]) {//오름차순
				if(data[i]<data[j]) { //내림차순
					int temp=data[i];
					data[i]=data[j];
					data[j] = temp;
				}
			}
		}
		
		for(int i=0;i<data.length;i++) {
			System.out.println(i+":"+data[i]);
		}
	}

}
