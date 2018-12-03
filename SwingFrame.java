package Package09_prac08;

import java.awt.*;
import javax.swing.*;

public class SwingFrame extends JFrame {

	public SwingFrame() {
		setTitle("여러 개의 패널을 가진 프레임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		
		c.add(new SouthPanel(),BorderLayout.SOUTH);
		c.add(new CenterPanel(),BorderLayout.CENTER);
		c.add(new NorthPanel(),BorderLayout.NORTH);
		
		setSize(500,500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new SwingFrame();
	}
}

class SouthPanel extends JPanel{
	public SouthPanel() {
		setBackground(Color.YELLOW);
		setOpaque(true);
		setLayout(new FlowLayout(FlowLayout.LEFT)); 
		add(new JButton("열기"));
		add(new JButton("닫기"));
		add(new JButton("나가기"));
	}
}

class CenterPanel extends JPanel{
	public CenterPanel() {
		setBackground(Color.WHITE);
		
	}
	
}

class NorthPanel extends JPanel{
	public NorthPanel() {
		setBackground(Color.LIGHT_GRAY);
		setOpaque(true);
		setLayout(new FlowLayout()); // JPanel이 디폴트로 FlowLayout이지만, 확실히 하기 위해		
		add(new JLabel("Word Input"));
		add(new JTextField(16));
	}

}
