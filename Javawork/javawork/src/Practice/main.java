package Practice;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		long n = 12345;
		int arr[] = {};
		while(n<0) {
			arr[count] = (int)n%10;
			n/=10;
			count ++;
			
		}
	
		for(int i =0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}

}

