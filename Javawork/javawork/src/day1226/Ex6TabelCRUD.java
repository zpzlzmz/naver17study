package day1226;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ex6TabelCRUD extends JFrame{

	
	static final String FILENAME="d:/naver1210/student.txt";
	List<Student> list = new ArrayList<Student>();
	JTable table;
	DefaultTableModel tableModel;//추가,삭제 등의 메서드를 갖고있는 클래스모델
	JTextField tfName,tfKor,tfEng;
	JButton btnAdd;
	
	
	
	public Ex6TabelCRUD() {
		super("학생관리");
		this.setBounds(300, 100, 400, 400);
		
		this.initDesign();
		
		this.setVisible(true);
		
		
		//윈도우 x버튼 클릭시 이벤트 발생해 파일을 저장
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				saveFile();
				
				System.exit(0);
				
				super.windowClosing(e);
			}
				//익명 내부 클래스 
			
		}
		);
		
	}
	public void initDesign() {
		
		
		//파일을 읽어온다
		this.studentFileRead();
		//테이블을 생성해 Center에 추가
		String []title = {"이름","국어","영어","총점","평균"};
		tableModel = new DefaultTableModel(title,0);
		table = new JTable(tableModel);
		
		//frame에 추가
		
		this.add("Center",new JScrollPane(table));
		
		//입력부분 디자인
		JPanel panel = new JPanel();
		tfName=new JTextField(5);
		tfKor = new JTextField(4);
		tfEng = new JTextField(4);
		
		btnAdd = new JButton("추가");
		
		
		//panel 에 각 컴포넌트들 추가
		panel.add(new JLabel("이름"));
		panel.add(tfName);
		panel.add(new JLabel("국어"));
		panel.add(tfKor);
		panel.add(new JLabel("영어"));
		panel.add(tfEng);
		panel.add(btnAdd);
		
		//Frame에 panel 을 상단에 추가하자 
		this.add("North",panel);
		
		
		
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
	
	public void saveFile() {
	//리스트의 내용을 파일에 저장
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex6TabelCRUD();
	}

}
