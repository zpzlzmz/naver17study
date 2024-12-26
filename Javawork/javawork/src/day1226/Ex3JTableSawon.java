package day1226;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex3JTableSawon extends JFrame {
	JTable table;
	List<Sawon> sawonList = new Vector<Sawon>();
	static final String SAWONFILE="d:/naver1210/mysawon.txt";
	
	public Ex3JTableSawon() {
		super("사원 파일 읽기");
		this.setBounds(300, 100, 300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initDesign();
		this.setVisible(true);
	}
	
	public void initDesign() {
		//파일 정보 읽어오기
		this.sawonFileRead();
		
		Vector<String> title = new Vector<String>();
		title.add("사원명");
		title.add("나이");
		title.add("핸드폰");
		title.add("주소");
		
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		
		
		for(Sawon s:sawonList) {
			Vector<String> sawon = new Vector<String>();
			sawon.add(s.getSawonName());
			sawon.add(String.valueOf(s.getAge()));
			sawon.add(s.getHp());
			sawon.add(s.getAddress());
			
			data.add(sawon);
		}
		
		table = new JTable(data,title);
		this.add("Center",new JScrollPane(table));
		
	}
	
	
	
	
	
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex3JTableSawon();
	}

}
