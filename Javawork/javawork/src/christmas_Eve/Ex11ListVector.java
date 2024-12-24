package christmas_Eve;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Ex11ListVector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list1=Arrays.asList("장미꽃","안개꽃","국화꽃","다알리아","무궁화");
		System.out.println("list의 크기:"+list1.size());
		
		List<Integer> list2=Arrays.asList(56,2,100,90,80);
		System.out.println("list2의 크기:"+list2.size());
		
		System.out.println("list1 출력");
		for(String s:list1)
			System.out.print(s+" ");
		System.out.println("\nlist2 출력");
		Iterator<Integer> iter = list2.iterator();
		while(iter.hasNext())
			System.out.print(iter.next()+" ");
	}

}
