package day1226;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex5TableStudent extends JFrame {
	
	
	
	
	static final String FILENAME="d:/naver1210/student.txt";
	List<Student> list = new ArrayList<Student>();
	
	
	
	public Ex5TableStudent() {
		super("학생성적관리");
		this.setBounds(300, 100, 400, 300);
		this.initDesign();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	public void studentFileRead() {
		//파일을 읽어서 list 변수에 담는다
		//list의 데이터를 읽어 테이블에 출력후 
		//프레임에 출력
		//제목은 이름,국어,영어,총점,평균
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			
			
			while(true) {
				String studentInfo = br.readLine();
				if(studentInfo == null)
					break;
				String s[] = studentInfo.split("\\|");
				Student student = new Student();
				student.setName(s[0]);
				student.setKor(Integer.parseInt(s[1]));
				student.setEng(Integer.parseInt(s[2]));
				
			
				//s[4] = (Double.parseDouble(s[3]))/2.0; ???
				list.add(student);	 
			}
			System.out.println("총 학생 수는 "+list.size()+"명 입니다.");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public void initDesign() {
		this.studentFileRead();
		
		String title[] = {"이름","국어","영어","총점","평균"};
		String data[][] = new String[list.size()][5];
		int i = 0;
		
		for(Student s:list) {
			data[i][0] = s.getName();
			data[i][1] = String.valueOf(s.getKor());
			data[i][2] = String.valueOf(s.getEng());
			data[i][3] = String.valueOf(s.getEng()+s.getKor());//배열안에 있는 int를 쓰기 위해서는 옆의
			//문장과 같이 String.valueOf(변수.메서드 롤 써야함)
			data[i][4] = String.valueOf(((s.getEng()+s.getKor())/2.0));
			i++;
			
		}
		JTable table = new JTable(data,title);
		this.add("Center",new JScrollPane(table));
	
	}
		
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex5TableStudent();
	}

}
