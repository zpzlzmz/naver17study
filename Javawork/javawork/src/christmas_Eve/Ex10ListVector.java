package christmas_Eve;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Ex10ListVector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list1= new Vector<String>();
		List<String> list2= new Vector<String>(5,3);
		
		
		list2.add("A");
		list2.add("A");
		list2.add("A");
		list2.add("A");
		list2.add("A");
		list2.add("A");
		
		
		
		System.out.println("List1의 데이터 갯수:"+list1.size()+"\n할당 갯수:"+((Vector<String>)list1).capacity()); // capacity()메서드는 Vector 의 메서드 (not Override)
		//Vector의 것이기 때문에 다운 캐스팅이 필요  
		System.out.println("List1의 데이터 갯수:"+list2.size()+"\n할당 갯수:"+((Vector<String>)list2).capacity()); // capacity()메서드는 Vector 의 메서드 (not Override)
		//기본 default 10개 if 10개를 넘어가게 된다면 10개 단위로 자동으로 늘어남 

		System.out.println("출력 방법 1");
		for(String s:list2)
			System.out.print(s+" ");
		System.out.println();
		System.out.println("출력 방법 2");
		for(int i=0; i<list2.size(); i++) 
			System.out.print(i+1+":"+list2.get(i)+" ");
		System.out.println();
		
		System.out.println("출력 방법 3");
		Iterator<String> iter = list2.iterator();
		while(iter.hasNext()){
			System.out.print(iter.next()+" ");
		}
		System.out.println();
		
		System.out.println("출력 방법 4");
		Object []ob= list2.toArray();
		for(Object s:ob)
			System.out.print(s+" ");
		
	}
	

}
