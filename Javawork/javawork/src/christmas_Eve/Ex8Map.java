package christmas_Eve;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Ex8Map {
	public static void main(String[] args) {
		//Map타입은 Key와 Value 의 쌍으로 데이터를 추가
		//이때 Key값은 Set타입이다. 즉 중복허용 하지않고 비 순차적
		Map<String, String> map = new HashMap<String, String>();
		//Map에 데이터 추가
		map.put("name", "송혜교");
		map.put("age","34");
		map.put("blood","AB");
		map.put("name", "이영자");
		
		System.out.println("map의 사이즈:"+map.size());
		System.out.println("map 에서 Key값으로 value값 꺼내기");
		System.out.println("이름:"+map.get("name"));
		System.out.println("나이:"+map.get("age"));
		System.out.println("혈액형:"+map.get("blood"));
		System.out.println("핸드폰:"+map.get("hp"));//없을경우 Null이 반환됨 
		System.out.println();
		System.out.println("Key값들을 자동으로 얻은 후 value 값들 얻기");
		Set<String> KeySets = map.keySet();
		
		for(String key:KeySets) {
			String v=map.get(key);
			 System.out.println(key+"=>"+v);
		}
		
 		
	}
}
