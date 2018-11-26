import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Main {
	private Frame insertFrame;
	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel, buttonPanel;

	public Main() {
		FULLGUI();	
	}

	public class Insert {
		private Frame insertFrame;
		private Label headerLabel;
		private Label statusLabel;
		private Panel controlPanel, buttonPanel;

		public Insert() {
			Insert();	
		}

		public void Insert() {
			JFrame frm=new JFrame("��ǰ �Է�");	
			frm.setBounds(120, 120, 250, 270);
			frm.setLayout(new FlowLayout());

			JTextArea textArea=new JTextArea(10,20);
			textArea.setText("����)���ڼ�/2018/12/12\n");

			textArea.setLineWrap(true);
			textArea.setWrapStyleWord(true);


			JButton btn=new JButton("�߰�");

			btn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					System.out.println(textArea.getText());
					frm.setVisible(false);		
				}
			});

			JScrollPane simpleScroll=new JScrollPane(textArea);
			frm.add(simpleScroll); frm.add(btn);

			frm.setDefaultCloseOperation(
					WindowConstants.DISPOSE_ON_CLOSE);

			frm.setVisible(true);	
		}
	}

	void FULLGUI() {
		mainFrame = new Frame("������� ���� �ý���");
		mainFrame.setSize(500, 800);
		mainFrame.setLayout(new GridLayout(4, 1));
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});


		headerLabel = new Label();
		headerLabel.setAlignment(Label.CENTER);
		headerLabel.setText("������ ���� �ִ� ��ǰ<<<>>>���� �ؾ� �� ��ǰ");

		controlPanel = new Panel();
		controlPanel.setLayout(new FlowLayout());

		buttonPanel = new Panel();
		buttonPanel.setLayout(new FlowLayout());

		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(buttonPanel);
		mainFrame.setVisible(true);
	}

	public void showList() {
		
		List LatestProducts = new List(10, true); // ������ ���� ��ǰ ���
			LatestProducts.add("����");
		

		List Oldproducts = new List(10, true); // ������ ��ǰ ���
		

		//JTextField Insertproducts = new JTextField();

		Button insertButton = new Button("�߰�");	 // �߰��� �� ��ư
		Button deleteButton = new Button("����"); // ������ �� ��ư

		insertButton.addActionListener(new ActionListener() { // �߰� ��ư ������ ���� ���
			public void actionPerformed(ActionEvent e) {
				// �߰���ư
				Insert Insert = new Insert();
			}
		});

		deleteButton.addActionListener(new ActionListener() { // ���� ��ư ������ ���� ���
			public void actionPerformed(ActionEvent e) {
				// ������ư
				// ���� ����Ʈ ����
				if(LatestProducts.getSelectedIndex()!=-1)
					LatestProducts.remove(LatestProducts.getSelectedIndex());

				if(Oldproducts.getSelectedIndex()!=-1)
					Oldproducts.remove(Oldproducts.getSelectedIndex());
			}
		});

		controlPanel.add(LatestProducts); 	// ���ο� ��ǰ ���
		controlPanel.add(Oldproducts); 		// ������ ��ǰ ���
		buttonPanel.add(insertButton); 		// �߰��� �� ��ư
		buttonPanel.add(deleteButton); 		// ������ �� ��ư
	}

	public static void main(String[] args) {
		Main exe = new Main();
		exe.showList();
	}
}
