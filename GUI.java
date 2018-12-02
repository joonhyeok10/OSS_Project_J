package test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import com.sun.net.httpserver.Authenticator.Failure;

class test
{
	static JFrame frm=new JFrame("������� ���� �ý���");
	static JPanel panel2=new JPanel();
	static List NewProducts = new List(14, true); // ������ ���� ��ǰ ���
	static List Oldproducts = new List(14, true); // ������ ��ǰ ���


	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		//______________________________________________________________________�߰� ��ư �������� GUI
		class Insert {

			private Frame insertFrame;
			private Label headerLabel;
			private Label statusLabel;
			private Panel controlPanel, buttonPanel;

			public Insert() {
				Insert();	
			}

			public void Insert() {


				JFrame frm2=new JFrame("��ǰ �߰�");
				frm2.setBounds(860, 420, 300, 130);
				frm2.setLayout(new BorderLayout());

				JButton btm1=new JButton("�߰�");
				JButton btm3=new JButton("���");
				JLabel Name2=new JLabel("��ǰ��");
				JTextField Name=new JTextField("");
				JLabel btm8=new JLabel("������� (xxxx-xx-xx)");
				JTextField Date1=new JTextField("");

				JPanel panel12=new JPanel();
				panel12.setLayout(new GridLayout(2, 2, 2, 2));
				panel12.add(Name2); panel12.add(Name); 
				panel12.add(btm8); 
				panel12.add(Date1);  

				JPanel panel1=new JPanel();
				panel1.setLayout(new FlowLayout());
				panel1.add(btm1); 
				panel1.add(btm3); 

				frm2.add(panel1, BorderLayout.CENTER);
				frm2.add(panel12, BorderLayout.NORTH);

				frm2.setVisible(true);

				btm1.addActionListener(new ActionListener() { // �߰� ��ư ������ ���� ���
					public void actionPerformed(ActionEvent e) {
						if(Name.getText()!=null&&Date1.getText()!=null) {
							Product p = new Product();
							foodDataDAO food = new foodDataDAO(); 
							p.setName(Name.getText());
							String DD = Date1.getText();
							java.sql.Date d=java.sql.Date.valueOf(DD);
							p.setExpdate(d);
							try {
								food.insertProduct(p);
								food.moveProduct();
								food.afterMove();
							} catch (ClassNotFoundException | SQLException e1) {
								e1.printStackTrace();
							}
							
						}
						foodDataDAO food = new foodDataDAO();
						String[] arr = null;
						try {
							arr = food.showProduct();
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						NewProducts.removeAll();
						Oldproducts.removeAll();
						int j = 0;
						while(arr[j] != null) {
							NewProducts.add(arr[j].substring(2));
							j++;
						}
						String[] arr2 = null;
						try {
							arr2 = food.showEproduct();
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						int k = 0;
						while(arr2[k] != null) {
							Oldproducts.add(arr2[k].substring(2));
							k++;
						}
						frm2.setVisible(false);
					}
				});

				btm3.addActionListener(new ActionListener() { // ��� ��ư ������ ���� ���
					public void actionPerformed(ActionEvent e) {
						frm2.setVisible(false);
					}
				});
			}
		}
		//_____________________________________________________________________________________�߰� ��ư �������� GUI


		//_________________________________________________________________________________ MAIN GUI 

		frm.setBounds(830, 330, 350, 330);
		frm.setLayout(new BorderLayout());

		JLabel title=new JLabel("������ ���� �ִ� ��ǰ<<<>>>���� �ؾ� �� ��ǰ");

		foodDataDAO food = new foodDataDAO();
		String[] arr = food.showProduct();

		int j = 0;
		while(arr[j] != null) {
			NewProducts.add(arr[j].substring(2));
			j++;
		}

		String[] arr2 = food.showEproduct();
		int k = 0;
		while(arr2[k] != null) {
			Oldproducts.add(arr2[k].substring(2));
			k++;
		}

		JPanel panel1=new JPanel();
		panel1.setLayout(new FlowLayout());
		panel1.add(title); 

		panel2.setLayout(new FlowLayout());
		panel2.add(NewProducts); 
		panel2.add(Oldproducts); 
		JPanel panel3=new JPanel();
		panel3.setLayout(new FlowLayout());
		Button insertButton = new Button("�߰�");	 // �߰��� �� ��ư
		Button Re = new Button("���ΰ�ħ");
		Button deleteButton = new Button("����"); // ������ �� ��ư

		panel3.add(insertButton); 
		panel3.add(deleteButton); 

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

				if(NewProducts.getSelectedIndex()!=-1) {
					Product p = new Product();
					foodDataDAO food = new foodDataDAO(); 
					String[] NewID=arr[NewProducts.getSelectedIndex()].split(" ");
					int NewID2 = Integer.parseInt(NewID[0]);
					System.out.println(NewID2);
					try {
						food.deleteProduct(NewID2);
						food.moveProduct();
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}
				//System.out.println(Oldproducts.getSelectedIndex());
				if(Oldproducts.getSelectedIndex()!=-1) {
					Product p = new Product();
					foodDataDAO food = new foodDataDAO(); 
					String[] OldID=arr2[Oldproducts.getSelectedIndex()].split(" ");
					int OldID2 = Integer.parseInt(OldID[0]);
					System.out.println(OldID2);
					try {
						food.deleteEproduct(OldID2);
						food.moveProduct();
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}

				if(NewProducts.getSelectedIndex()!=-1) {
					NewProducts.remove(NewProducts.getSelectedIndex());
				}
				if(Oldproducts.getSelectedIndex()!=-1) {
					Oldproducts.remove(Oldproducts.getSelectedIndex());
				}
			}
		});
		frm.add(panel1, BorderLayout.NORTH);
		frm.add(panel2, BorderLayout.CENTER);
		frm.add(panel3, BorderLayout.SOUTH);

		frm.setVisible(true);
		//_____________________________________________________________________________________________
	}
}

/*
package test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import com.sun.net.httpserver.Authenticator.Failure;

class test
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		//______________________________________________________________________�߰� ��ư �������� GUI
		class Insert {
			private Frame insertFrame;
			private Label headerLabel;
			private Label statusLabel;
			private Panel controlPanel, buttonPanel;

			public Insert() {
				Insert();	
			}

			public void Insert() {


				JFrame frm=new JFrame("��ǰ �߰�");
				frm.setBounds(860, 420, 300, 130);
				frm.setLayout(new BorderLayout());

				JButton btm1=new JButton("�߰�");
				JButton btm3=new JButton("���");
				JLabel Name2=new JLabel("��ǰ��");
				JTextField Name=new JTextField("");
				JLabel btm8=new JLabel("������� (xxxx-xx-xx)");
				JTextField Date1=new JTextField("");

				JPanel panel2=new JPanel();
				panel2.setLayout(new GridLayout(2, 2, 2, 2));
				panel2.add(Name2); panel2.add(Name); 
				panel2.add(btm8); 
				panel2.add(Date1);  

				JPanel panel1=new JPanel();
				panel1.setLayout(new FlowLayout());
				panel1.add(btm1); 
				panel1.add(btm3); 

				frm.add(panel1, BorderLayout.CENTER);
				frm.add(panel2, BorderLayout.NORTH);

				frm.setVisible(true);

				btm1.addActionListener(new ActionListener() { // �߰� ��ư ������ ���� ���
					public void actionPerformed(ActionEvent e) {
						if(Name.getText()!=null&&Date1.getText()!=null) {
							Product p = new Product();
							foodDataDAO food = new foodDataDAO(); 
							p.setName(Name.getText());
							String DD = Date1.getText();
							java.sql.Date d=java.sql.Date.valueOf(DD);

							p.setExpdate(d);
							try {
								food.insertProduct(p);
								food.moveProduct();
								food.afterMove();
							} catch (ClassNotFoundException | SQLException e1) {
								e1.printStackTrace();
							}
						}

						//frm.setVisible(false);
					}
				});

				btm3.addActionListener(new ActionListener() { // ��� ��ư ������ ���� ���
					public void actionPerformed(ActionEvent e) {

						frm.setVisible(false);
					}
				});
			}
		}
		//_____________________________________________________________________________________�߰� ��ư �������� GUI


		//_________________________________________________________________________________ MAIN GUI 

		JFrame frm=new JFrame("������� ���� �ý���");
		frm.setBounds(830, 330, 350, 330);
		frm.setLayout(new BorderLayout());

		JLabel title=new JLabel("������ ���� �ִ� ��ǰ<<<>>>���� �ؾ� �� ��ǰ");

		final List NewProducts = new List(14, true); // ������ ���� ��ǰ ���
		foodDataDAO food = new foodDataDAO();
		String[] arr = food.showProduct();

		int j = 0;
		while(arr[j] != null) {
			NewProducts.add(arr[j].substring(2));
			j++;
		}

		final List Oldproducts = new List(14, true); // ������ ��ǰ ���
		String[] arr2 = food.showEproduct();
		int k = 0;
		while(arr2[k] != null) {
			Oldproducts.add(arr2[k].substring(2));
			k++;
		}


		JPanel panel1=new JPanel();
		panel1.setLayout(new FlowLayout());
		panel1.add(title); 

		JPanel panel2=new JPanel();
		panel2.setLayout(new FlowLayout());
		panel2.add(NewProducts); 
		panel2.add(Oldproducts); 

		JPanel panel3=new JPanel();
		panel3.setLayout(new FlowLayout());
		Button insertButton = new Button("�߰�");	 // �߰��� �� ��ư
		Button deleteButton = new Button("����"); // ������ �� ��ư

		panel3.add(insertButton); 
		panel3.add(deleteButton); 

		insertButton.addActionListener(new ActionListener() { // �߰� ��ư ������ ���� ���
			public void actionPerformed(ActionEvent e) {
				// �߰���ư

				Insert Insert = new Insert();
			}
		});
		deleteButton.addActionListener(new ActionListener() { // ���� ��ư ������ ���� ���
			public void actionPerformed(ActionEvent e) {
				Product p = new Product();
				foodDataDAO food = new foodDataDAO(); 

				// ������ư
				// ���� ����Ʈ ����

				if(NewProducts.getSelectedIndex()!=-1) {
					String[] NewID=arr[NewProducts.getSelectedIndex()].split(" ");
					int NewID2 = Integer.parseInt(NewID[0]);
					try {
						food.deleteProduct(NewID2);
						food.moveProduct();
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}
				if(Oldproducts.getSelectedIndex()!=-1) {
					String[] OldID=arr2[Oldproducts.getSelectedIndex()].split(" ");
					int OldID2 = Integer.parseInt(OldID[0]);
					try {
						food.deleteEproduct(OldID2);
						food.moveProduct();
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}

				if(NewProducts.getSelectedIndex()!=-1) {
					NewProducts.remove(NewProducts.getSelectedIndex());
				}
				if(Oldproducts.getSelectedIndex()!=-1) {
					Oldproducts.remove(Oldproducts.getSelectedIndex());
				}
			}
		});
		frm.add(panel1, BorderLayout.NORTH);
		frm.add(panel2, BorderLayout.CENTER);
		frm.add(panel3, BorderLayout.SOUTH);

		frm.setVisible(true);
		//_____________________________________________________________________________________________
	}
}
*/ 