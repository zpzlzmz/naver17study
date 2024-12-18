package day1217;

public class Ex14StringSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String names[]= {"Dennis","박남정","공만","김씨","이씨","손씨","Adams"};
		//이름을 오름차순으로 출력
		for(int i=0;i<names.length; i++) {
			for(int j=i+1; j<names.length; j++) {
			if(names[i].compareTo(names[j])>0) {//해당 부등호를 바꾸면 오름,내림차순을 마음대로 할 수 있다.
				String temp=names[i];
				names[i]=names[j];
				names[j] =temp;
				}
			}
		}
		for(int i =0;i<names.length; i++) {
			System.out.println(i+":"+names[i]);
		}
		
	}

}
