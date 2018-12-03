package Package09_prac07;

import java.awt.*;
import javax.swing.*;

public class CalculatorFrame extends JFrame {

	public CalculatorFrame() {
		setTitle("�Խ��� ������");
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
		new CalculatorFrame();
	}
}

class SouthPanel extends JPanel{
	public SouthPanel() {
		setBackground(Color.YELLOW);
		setOpaque(true);
		setLayout(new FlowLayout(FlowLayout.LEFT)); 
		add(new JLabel("��� ���"));
		add(new JTextField(15));
	}

}

class CenterPanel extends JPanel {
	JButton b [] = { new JButton("+"), new JButton("-"), new JButton("x"), new JButton("/") };
	public CenterPanel() {
		setBackground(Color.WHITE);
		setLayout(new GridLayout(4,4,5,5)); // GridLayout ��ġ������
		for(int i=0; i<10; i++) {
			JButton b = new JButton(Integer.toString(i));
			add(b);
		}
		add(new JButton("CE"));
		add(new JButton("���"));
		
		for(int i=0; i<b.length; i++) {
			b[i].setBackground(Color.CYAN);
			add(b[i]);
		}
	}
}


class NorthPanel extends JPanel{
	public NorthPanel() {
		setBackground(Color.LIGHT_GRAY);
		setOpaque(true);
		setLayout(new FlowLayout()); // JPanel�� ����Ʈ�� FlowLayout������, Ȯ���� �ϱ� ����		
		add(new JLabel("�����Է�"));
		add(new JTextField(16));
	}

}
