package christmas_Eve;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
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
		System.out.println("총"+sawonList.size()+"명의 사원이 있습니다.\n");
		//사원 이름을 번호와 함께 출력해주세요.
		System.out.println("사원번호\t사원이름");
		System.out.println("=".repeat(30));
		for(int i =0; i<sawonList.size(); i++) {
			System.out.println(+i+1+"\t"+sawonList.get(i));
		
		}
		
	}
	//해당 이름이 몇번 인덱스에 있는지 리턴(없으면 -1 리턴
	public int getSearchName(String name) {
		int idx = -1;
		for(int i=0; i<sawonList.size(); i++) {
			String listName = sawonList.get(i);
			if(listName.equals(name)) {
				idx = i;
				break;
			}
		}
		return idx;
	}
	
	
	//이름 입력시 삭제하는 메서드
	public void deleteSawon(String name) {
		
		int idx = getSearchName(name);
		if(idx == -1)
			System.out.println(name+"님은 사원 명단에 없습니다.\n");
		else {
			sawonList.remove(idx);
			System.out.println(name+"님을 사원 명단에서 제거하였습니다.\n");
		}
	}
	
	//이름 조회
	public void searchName(String name) {
		int idx = this.getSearchName(name);
		if(idx == -1)
			System.out.println(name+"님은 명단에 없습니다.\n");
		else {
			System.out.println(name + "님은"+(idx+1)+" 번째에 있습니다.\n");
		}
	}
	
	public void sawonFileSave() {
		FileWriter fw = null;
		try {
			fw=new FileWriter(FILENAME);
			for(String name:sawonList) {
				fw.write(name+"\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	public void addSawon(String name) {
		int idx = this.getSearchName(name);
		if(idx!=-1)
			System.out.println(name+" 님은 이미 존재합니다\n");
		else {
			sawonList.add(name);
			System.out.println("추가되었습니다.\n");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex12FileList ex12 = new Ex12FileList();
		List<String> sawonList2 = ex12.sawonList;
		Scanner sc = new Scanner(System.in);
		int menu=0;
		
		while(true) {
			System.out.println("1.사원추가\t\t2.사원삭제\t\t3.사원검색\t\t4.전체 목록 갱신\t\t5.저장후 종료");
			System.out.println("=".repeat(90));
			try {
				menu = Integer.parseInt(sc.nextLine());
			}catch(NumberFormatException e) {
				menu = 4;
			}
			
			
			switch(menu) {
			case 1->{
			System.out.print("추가할 사원명을 입력하세요:");
			String name = sc.nextLine();
			ex12.addSawon(FILENAME);
			}
			case 2->{
				System.out.print("삭제할 사원명을 입력하세요:");
				String name = sc.nextLine();
				ex12.deleteSawon(name);
			}
			case 3->{
				System.out.print("탐색할 사원명을 입력하세요:");
				String name = sc.nextLine();
				ex12.searchName(name);
			}
			case 4->{
				System.out.print("사원 목록을 갱신합니다.");
				ex12.sawonMemberList();
			}
			case 5->{
				System.out.print("** 저장 후 종료 합니다. **");
				ex12.sawonFileSave();
				System.exit(0);
			}default ->{
				System.out.print("사원 목록을 갱신합니다.");
				ex12.sawonMemberList();
			}
			}
			
			
		}
	}

}
