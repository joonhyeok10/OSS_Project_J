package Package09_prac06;

import java.awt.*;
import java.util.*;

import javax.swing.*;

public class RandomLabels extends JFrame {

	public RandomLabels() {
		super("Random Labels");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		
		for(int i=0; i<20; i++) {
			JLabel label=new JLabel(Integer.toString(i));
			label.setOpaque(true);
			label.setBackground(Color.WHITE);
			int x=(int)(Math.random()*200)+50;
			int y=(int)(Math.random()*200)+50;
			label.setLocation(x,y);
			label.setSize(20,20);
			c.add(label);
		}
		setSize(300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new RandomLabels();
	}

}
