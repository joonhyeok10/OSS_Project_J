import javax.swing.*;
import java.awt.*;


public class Button extends JFrame {
	public Button() {
		setTitle("ContentPane�� JFrame"); // ������ ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ������ �����츦 ������ ���α׷��� �����ϵ��� ����

		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		contentPane.add(new JButton("�Է�")); //��ư ����
		contentPane.add(new JButton("����")); //��ư ����
		
		
		setSize(300, 600); 
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Button();
	}
}
