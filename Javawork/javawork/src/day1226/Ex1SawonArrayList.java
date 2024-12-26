package day1226;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex1SawonArrayList {
	
	List<Sawon> sawonList = new ArrayList<Sawon>();
	static final String SAWONFILE = "d:/naver1210/mysawon.txt";
	
	
	public Ex1SawonArrayList() {
		this.sawonFileRead();
	}
	
	//파일에서 읽어서 sawonList에 넣기
	public void sawonFileRead() {
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(SAWONFILE);
			br = new BufferedReader(fr);
			
			while(true) {
				String sawonInfo = br.readLine();
				if(sawonInfo == null)
					break;
				String []s = sawonInfo.split("\\|");
				Sawon sawon = new Sawon();
				sawon.setSawonName(s[0]);
				sawon.setAge(Integer.parseInt(s[1]));
				sawon.setHp(s[2]);
				sawon.setAddress(s[3]);
				
				sawonList.add(sawon);
				
			}
			System.out.println("총 "+sawonList.size()+"명 읽음");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("저장된 사원정보가 없습니다");
		}finally {
			try {
				br.close();
				fr.close();
			} catch (IOException|NullPointerException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
	}
	
	//파일 저장
	public void sawonFileSave() {
		//사원 리스트의 정보를 파일에 저장 하기.
		FileWriter fw = null;
		try {
			fw = new FileWriter(SAWONFILE);
			
			for(Sawon sawon:sawonList) {
				String s=sawon.getSawonName()+"|"+sawon.getAge()+"|"+sawon.getHp()+"|"+
			sawon.getAddress()+"\n";
				fw.write(s);
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
	
	//사원 추가
	
	public void addSawon(Sawon sawon) {
		//list 에 추가만 하면 됨
		sawonList.add(sawon);
		System.out.println(sawon.getSawonName()+"님의 정보를 추가했습니다.");
	}
	
	
	//이름 입력시 인덱스 반환 
	public int getSearchName(String name) {
		int idx =-1;
		for(int i =0; i<sawonList.size(); i++) {
			Sawon sawon = sawonList.get(i);
			if(sawon.getSawonName().equals(name)) {
				idx = i;
				break;
			}
		}
		
		return idx;
	}
	//사원 삭제
	public void deleteSawon(String name) {
		int idx = this.getSearchName(name);
		if(idx == -1)
			System.out.println(name+" 사원은 존재하지 않습니다.");
		else {
			System.out.println(name+" 사원의 정보를 삭제하겠습니다.");
			sawonList.remove(idx);
		}
	}
	//사원 검색
	public void searchSawon(String name) {
		/*
		 * 없을 경우 " 이영자님은 사원명단에 없습니다.
		 * 있을경우
		 * ** 이영자님의 개인정보 **
		 * 나이:
		 * 핸드폰:
		 * 주소:
		 * 
		 */
		
		int idx = this.getSearchName(name);
		if(idx == -1)
			System.out.println(name+"님은 사원명단에 없습니다.");
		else {
			
			System.out.println("** "+name+"님의 개인정보 **");
			Sawon sawon = sawonList.get(idx);//index 번지에 해당하는 사원 정보를 넣음
			System.out.println("이름:"+sawon.getSawonName());
			System.out.println("나이:"+sawon.getAge());
			System.err.println("핸드폰:"+sawon.getHp());
			System.out.println("주소:"+sawon.getAddress());
		}
		
		
		
	}
	//사원 목록 출력
	public void writeSawonList() {
		System.out.println("\t\t[전체 dp사원 정보]\n");
		System.out.println("번호\t사원명\t나이\t핸드폰\t\t주소");
		System.out.println("=".repeat(60));
		
		int n =0;
		for(Sawon s:sawonList) {
			System.out.println(++n+"\t"+s.getSawonName()+"\t"+s.getAge()+"세\t"+
		s.getHp()+"\t"+s.getAddress());
		}
		
	}
	
	
	public static void main(String[] args) {
		Ex1SawonArrayList ex1 = new Ex1SawonArrayList();
		Scanner sc = new Scanner(System.in);
		
		int menu = 0;
		
		while(true) {
			System.out.println(" *** 쇼원 관리 메뉴 *** ");
			System.out.println("1. 사원 정보 추가");
			System.out.println("2. 사원 정보 검색");
			System.out.println("3. 사원 삭제");
			System.out.println("4. 전체 사원 출력");
			System.out.println("5. 저장 후 종료");
			System.out.print("번호를 입력하세요:");
			
			try {
				menu = Integer.parseInt(sc.nextLine());
				
			}catch(NumberFormatException e) {
				menu = 4;
			}
			
			switch(menu) {
			case 1->{
				//사원 추가 
				System.out.println("추가할 사원의 이름을 입력하세요:");
				String name = sc.nextLine();
				System.out.println("나이를 입력하세요:");
				int age = Integer.parseInt(sc.nextLine());
				System.out.println("핸드폰 번호를 입력하세요:");
				String hp = sc.nextLine();
				System.out.println("주소를 입력하세요:");
				String address = sc.nextLine();
				
				Sawon sawon = new Sawon(name,age,hp,address);
				
				ex1.addSawon(sawon);
				
				
			}
			case 2->{
				System.out.println("검색할 사원의 이름을 입력하세요:");
				String name = sc.nextLine();
				ex1.getSearchName(name);
				
			}
			case 3->{
				System.out.println("삭제할 사원의 이름을 입력하세요:");
				String name = sc.nextLine();
				ex1.deleteSawon(name);
				
			}
			case 4->{
				ex1.writeSawonList();
			}
			default ->{
				ex1.sawonFileSave();
				System.out.println("사원 정보를 파일에 저장 후 종료합니다.");
				System.exit(0);
			}
			}
			System.out.println("=".repeat(40));
		
		}
		
		
	}

}

