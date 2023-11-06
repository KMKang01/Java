package codeErorrDetector;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

class Mainpage extends JFrame {
	String data;
	DotJava dot = new DotJava();
	sendCmd send = new sendCmd();
	JTextArea comments = new JTextArea("하고 싶은 말을 적으세요.", 10, 50);
	public Mainpage() {
		
		setTitle("getCode");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c=getContentPane();
		setLayout(new FlowLayout());

		JButton darkModeButton = new JButton("다크 모드");
		Boolean isTextareaDark = false;



		JButton b = new JButton("확인");
		c.add(comments);
		b.addActionListener(new MyActionListener());
		c.add(b);
		c.add(darkModeButton);

		setSize(600, 400);
		comments.selectAll();
		setVisible(true);
	}
	private class MyActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			data = comments.getText(); // 텍스트 읽어옴
			try {
			String name = dot.saveAsDotJava(data);// 자바파일로 변경
			send.getCmd(name);//변경된 파일의 이름을 넘겨서 컴파일
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Mainpage();
	}
	
}
