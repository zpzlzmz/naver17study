package day1223;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

class MyFrame extends JFrame{
	
	//멤버 변수로 버튼 생성 
	
	JButton btn1 = new JButton("One Button");
	public MyFrame() {
		// TODO Auto-generated constructor stub
		//super();
		super("");//Frame 제목
		
		//x,y,width,height
		this.setBounds(300,100,300,300);
		//버튼 레리아웃 없애기
		this.setLayout(null);
		//버튼 위치 지정
		btn1.setBounds(30,30,100,30);
		//버튼 이벤트
		btn1.addActionListener(new ActionListener() {
			
			private Component MyFrame;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Component MyFrame;
				JOptionPane.showMessageDialog(this.MyFrame,"버튼이벤트입니다.");
			}
		});
		
		
		//
		
		this.setVisible(true); // 프레임 보임
		//아래 메서드가 없을경우 x를 눌러서 Frame 을 닫으면 그냥 프레임 숨김만 됨 (계속 실행중)
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
public class Ex6JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame my=new MyFrame();
	}

}