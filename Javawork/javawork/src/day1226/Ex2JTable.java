package day1226;

import java.util.Arrays;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex2JTable extends JFrame{
	JTable table;
	public Ex2JTable() {
	super("JTable공부");
	this.setBounds(300,100,300,300);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.initDesign();
	this.setVisible(true);
	}
	
	public void initDesign() {
		//기본 레이아웃은 VorderLayout인데
		//이 레이아웃은 동서남북 센터로 위치를 정하는 레이아웃
		//방법1
//		String []title = {"이름","혈액형","나이"};
//		String [][]data = {
//				{"이미자","A","23"},
//				{"손기자","AB","34"},
//				{"박기자","O","44"}
//		};
		//방버2
		Vector<String> title = new Vector<String>();

		title.add("이름");
		title.add("혈액형");
		title.add("나이");
		

		Vector<String> data1 = new Vector<String>();
		data1.add("박민영");
		data1.add("A");
		data1.add("23");
		
		
		
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		data.add(data1); 
		
		//JTable 생성
		table = new JTable(data,title);
		
		
		//North에 JLabel을 추가해보자
		this.add("North",new JLabel("테이터 출력 테이블",JLabel.CENTER));
		
		//Frame의 center에 추가
		//this.add("Center",table);//제목이 안나오고 데이터가 많을경우 스크롤도 안됨 .
		this.add("Center",new JScrollPane(table));//JScroll pane으로 생성해서 넣어야 
		//제목,스클롤 등이 생겨남(나타남)

	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2JTable ex2 = new Ex2JTable();
		
	}

}
