package christmas_Eve;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class Ex12FileList {
	static final String FILENAME="d:/naver1210/sawon.txt";
	
	List<String> sawonList= new Vector<String>();
	
	
	public Ex12FileList() {
		//파일에서 이름을 읽어서 SawonList에 추가하세요
		FileReader fr = null;
		BufferedReader br = null;
		
		
		try {
			fr = new FileReader("d:/naver1210/sawon.txt");
			br = new BufferedReader(fr);
			
			while(true) {
				String s= br.readLine();
				if(s==null)
					break;
				sawonList.add(s);
				
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		
	}
	
	public void sawonMemberList() {
		//사원 이름을 번호와 함께 출력해주세요.
		System.out.println("사원번호\t사원이름");
		System.out.println("=".repeat(30));
		for(int i =0; i<sawonList.size(); i++) {
			System.out.println(+i+1+"\t"+sawonList.get(i));
		
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex12FileList ex12 = new Ex12FileList();
		List<String> sawonList2 = ex12.sawonList;
		ex12.sawonMemberList();
	}

}
