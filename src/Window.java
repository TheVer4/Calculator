import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class Window extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bp,bm,bdiv,bmu,be,bdot, bclear;
	JTextField tf;
	JLabel flabel, slabel;
	
	String buffer = "";
	final int PLUS = 0, MINUS = 1, DIVISION = 2, MULTIPLICATION = 3;
	int event;
	double first, second, end;
	
	eventListner l = new eventListner();
	
	static float inp1, inp2, ret;
	
	public Window(String title) {
		super(title);
		setLayout(new FlowLayout());
		
		b0 = new JButton("0");
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		bdot = new JButton(".");
		
		bp = new JButton("+");
		bm = new JButton("-");
		bdiv = new JButton("/");
		bmu = new JButton("*");
		be = new JButton("=");
		
		bclear = new JButton("C");
		bclear.setPreferredSize(new Dimension(185, 30));
		
		tf = new JTextField(16);
		tf.setText("0");
		tf.setEditable(false);
		
		flabel = new JLabel("FIRST: 0");
		slabel = new JLabel("SECOND: 0");
		
		add(flabel);
		add(slabel);
		
		add(tf);
		
		add(b7);
		add(b8);
		add(b9);
		add(bmu);
		add(b4);
		add(b5);
		add(b6);
		add(bdiv);
		add(b1);
		add(b2);
		add(b3);
		add(bm);
		add(b0);
		add(bdot);
		add(be);
		add(bp);
		add(bclear);
				
		b0.addActionListener(l);
		b1.addActionListener(l);
		b2.addActionListener(l);
		b3.addActionListener(l);
		b4.addActionListener(l);
		b5.addActionListener(l);
		b6.addActionListener(l);
		b7.addActionListener(l);
		b8.addActionListener(l);
		b9.addActionListener(l);
		bdot.addActionListener(l);
		
		bp.addActionListener(l);
		bm.addActionListener(l);
		bdiv.addActionListener(l);
		bmu.addActionListener(l);
		
		be.addActionListener(l);
		bclear.addActionListener(l);
	}
	
	public class eventListner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == b0) {
				buffer += "0";
			}
			if (e.getSource() == b1) {
				buffer += "1";
			}
			if (e.getSource() == b2) {
				buffer += "2";
			}
			if (e.getSource() == b3) {
				buffer += "3";
			}
			if (e.getSource() == b4) {
				buffer += "4";
			}
			if (e.getSource() == b5) {
				buffer += "5";
			}
			if (e.getSource() == b6) {
				buffer += "6";
			}
			if (e.getSource() == b7) {
				buffer += "7";
			}
			if (e.getSource() == b8) {
				buffer += "8";
			}
			if (e.getSource() == b9) {
				buffer += "9";
			}
			if (e.getSource() == bdot && !buffer.contains(".")) {
				if (buffer.equals("")) {
					buffer += "0.";
				}
				else buffer += ".";
			}
			
			if (e.getSource() == bp) { /* + */
				first = Double.parseDouble(buffer);
				flabel.setText("FIRST: " + first);
				buffer = "";
				event = PLUS;
			}
			if (e.getSource() == bm) { /* - */
				first = Double.parseDouble(buffer);
				flabel.setText("FIRST: " + first);
				buffer = "";
				event = MINUS;
			}
			if (e.getSource() == bdiv) { /* / */
				first = Double.parseDouble(buffer);
				flabel.setText("FIRST: " + first);
				buffer = "";
				event = DIVISION;
			}
			if (e.getSource() == bmu) { /* * */
				first = Double.parseDouble(buffer);
				flabel.setText("FIRST: " + first);
				buffer = "";
				event = MULTIPLICATION;
			}
			
			if (e.getSource() == be) { /* = */
				second = Double.parseDouble(buffer);
				slabel.setText("SECOND: " + second);
				switch (event) {
				case PLUS:
					end = plus(first, second);
					break;
				case MINUS:
					end = minus(first, second);
					break;
				case DIVISION:
					double cache = division(first, second);
					if (cache != 0) end = cache;
					else clear();
					buffer = "Division by zero!";
					break;
				case MULTIPLICATION:
					end = multiplication(first, second);
					break;
				}
				buffer = Double.toString(end);
			}
			
			if (e.getSource() == bclear) {
				clear();
			}
			
			tf.setText(buffer);
			
		}
		
	}

	public void clear() {
		first = 0;
		second = 0;
		end = 0;
		flabel.setText("FIRST: 0");
		slabel.setText("SECOND: 0");
		buffer = "";
	}
	public double plus(double a, double b) {
		return a + b;
	}
	public double minus(double a, double b) {
		return a - b;
	}
	public double division(double a, double b) {
		if (b != 0) return a / b;
		else return 0;
	}
	public double multiplication(double a, double b) {
		return a * b;
	}
}
