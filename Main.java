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
			JFrame frm=new JFrame("제품 입력");	
			frm.setBounds(120, 120, 250, 270);
			frm.setLayout(new FlowLayout());

			JTextArea textArea=new JTextArea(10,20);
			textArea.setText("예시)초코송/2018/12/12\n");

			textArea.setLineWrap(true);
			textArea.setWrapStyleWord(true);


			JButton btn=new JButton("추가");

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
		mainFrame = new Frame("유통기한 관리 시스템");
		mainFrame.setSize(500, 800);
		mainFrame.setLayout(new GridLayout(4, 1));
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});


		headerLabel = new Label();
		headerLabel.setAlignment(Label.CENTER);
		headerLabel.setText("기한이 남아 있는 제품<<<>>>정리 해야 할 제품");

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
		
		List LatestProducts = new List(10, true); // 기한이 남은 제품 목록
			LatestProducts.add("감자");
		

		List Oldproducts = new List(10, true); // 오래된 제품 목록
		

		//JTextField Insertproducts = new JTextField();

		Button insertButton = new Button("추가");	 // 추가할 때 버튼
		Button deleteButton = new Button("삭제"); // 삭제할 때 버튼

		insertButton.addActionListener(new ActionListener() { // 추가 버튼 눌렀을 때의 명령
			public void actionPerformed(ActionEvent e) {
				// 추가버튼
				Insert Insert = new Insert();
			}
		});

		deleteButton.addActionListener(new ActionListener() { // 삭제 버튼 눌렀을 때의 명령
			public void actionPerformed(ActionEvent e) {
				// 삭제버튼
				// 단일 리스트 삭제
				if(LatestProducts.getSelectedIndex()!=-1)
					LatestProducts.remove(LatestProducts.getSelectedIndex());

				if(Oldproducts.getSelectedIndex()!=-1)
					Oldproducts.remove(Oldproducts.getSelectedIndex());
			}
		});

		controlPanel.add(LatestProducts); 	// 새로운 제품 목록
		controlPanel.add(Oldproducts); 		// 오래된 제품 목록
		buttonPanel.add(insertButton); 		// 추가할 때 버튼
		buttonPanel.add(deleteButton); 		// 삭제할 때 버튼
	}

	public static void main(String[] args) {
		Main exe = new Main();
		exe.showList();
	}
}
