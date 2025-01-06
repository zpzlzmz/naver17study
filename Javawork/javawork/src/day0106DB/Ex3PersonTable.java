package day0106DB;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ex3PersonTable extends JFrame {
	
	JTextField tfName, tfAge,tfBlood,tfHp;
	JButton btnAdd,btnDel;
	DefaultTableModel tableModel;
	JTable table;
	//처음 시작시 table에 person 데이터 출력 
	//(출력 컬럼:num,name,age,hp,blood);
	
	//상단 이름, 나이,혈액형 핸드폰, [직원 추가] 버튼 클릭시 db에 추가 후 다시 전체 출력 하기
	//테이블의 데이터 클릭후 [직원 삭제]버튼 클릭시 db에서 해당 직원 삭제 후 다시 전체 출력하기.
	
	PersonModel personModel = new PersonModel();
	
	public Ex3PersonTable() {
		// TODO Auto-generated constructor stub
		super("Person 관리");
		this.setBounds(300,100,500,400);
		this.initDesign();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void initDesign() {
		JPanel p1 =new JPanel();
		
		tfName = new JTextField(6);
		tfAge = new JTextField(3);
		tfBlood = new JTextField(2);
		tfHp = new JTextField(15);
		p1.add(new JLabel("이름"));
		p1.add(tfName);
		p1.add(new JLabel("나이"));
		p1.add(tfAge);
		p1.add(new JLabel("혈액형"));
		p1.add(tfBlood);
		p1.add(new JLabel("핸드폰"));
		p1.add(tfHp);
		this.add("North",p1);
		
		String []title = {"Num","이름","나이","혈액형","핸드폰"};
		tableModel = new DefaultTableModel(title,0);
		table = new JTable(tableModel);
		this.add("Center",new JScrollPane(table));
		
		this.rowSelect();
		
		
		btnAdd= new JButton("직원추가");
		btnDel = new JButton("직원삭제");
		
		JPanel p2 = new JPanel();
		p2.add(btnAdd);
		p2.add(btnDel);
		this.add("South",p2);
		
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = tfName.getText();
				if(name.length()==0) {
					JOptionPane.showMessageDialog(Ex3PersonTable.this, "이름을 입력해주세요");
					return;
				}
				String Text_age = tfAge.getText();
				int age = 0;
				if(Text_age.length() == 0) {
					JOptionPane.showMessageDialog(Ex3PersonTable.this, "나이를 입력해주세요");
					return;
				}else {
					age = Integer.parseInt(Text_age);
				}
				String blood = tfBlood.getText();
				if(blood.length() == 0) {
					JOptionPane.showMessageDialog(Ex3PersonTable.this, "혈액형을 입력해주세요");
					return;
				}
				String hp = tfHp.getText();
				if(hp.length()==0) {
					JOptionPane.showMessageDialog(Ex3PersonTable.this, "핸드폰번호를 입력해주세요");
					return;
				}
				
				personModel.insertPerson(new PersonDto(name,age,blood,hp));
				
				rowSelect();
				
				tfName.setText("");
				tfAge.setText("");
				tfBlood.setText("");
				tfHp.setText("");
			}
		});
		
		
		btnDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row= table.getSelectedRow();
				
				if(row == -1) {
					JOptionPane.showMessageDialog(Ex3PersonTable.this,"삭제할 행을 먼저 선택해주세요");
					return;
				}
				int num = Integer.parseInt((String)table.getValueAt(row, 0));
				personModel.deletePerson(num);
				rowSelect();
			}
		});
		
	}
	
	
	
	
	
	
	
	public void rowSelect() {
		tableModel.setRowCount(0);
		List<Vector<String>> list = personModel.getAllDatas();
		for(Vector<String> data:list) {
			tableModel.addRow(data);
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex3PersonTable ex3 = new Ex3PersonTable();
	}
	

}
