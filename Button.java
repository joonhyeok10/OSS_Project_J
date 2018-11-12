import javax.swing.*;
import java.awt.*;


public class Button extends JFrame {
	public Button() {
		setTitle("ContentPane과 JFrame"); // 프레임 제목
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 윈도우를 닫으면 프로그램을 종료하도록 설정

		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		contentPane.add(new JButton("입력")); //버튼 생성
		contentPane.add(new JButton("삭제")); //버튼 생성
		
		
		setSize(300, 600); 
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Button();
	}
}
