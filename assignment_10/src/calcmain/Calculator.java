package calcmain;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame {
	  
	private JPanel panel;
	private JTextField tField;
	private JButton[] buttons;
	private String[] labels = { 
			"Backspace", "", "", "CE", "C",
			"7", "8", "9", "/", "sqrt",
			"4", "5", "6", "x", "%",
			"1", "2", "3", "-", "1/x",
			"0", "+/-", ".", "+", "=",
	};
	private String mainStr = "";
	private String tmpStr = "";
	private String interStr = "";
	private String tmpOper = "";
	
	public Calculator() {
		tField = new JTextField(35);
		panel = new JPanel();
		tField.setText("0.");
		tField.setEnabled(false);	// false = cannot respond to an event
  
		panel.setLayout(new GridLayout(0, 5, 3, 3));
		buttons = new JButton[25];
		int index = 0;
		for (int rows = 0; rows < 5; rows++) {
			for (int cols = 0; cols < 5; cols++) {
				buttons[index] = new JButton(labels[index]);
				if( cols >= 3 )
					buttons[index].setForeground(Color.red);
				else 
					buttons[index].setForeground(Color.blue);
				buttons[index].setBackground(Color.yellow);
				panel.add(buttons[index]);
				
				//Number actions and ".", "+/-" actions.
				if((cols <= 2 && rows >= 1) && index != 21) {
					buttons[index].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							tField.setText("");
							JButton b = (JButton) e.getSource();
							tmpStr += b.getText();
							tField.setText(tmpStr);
						}
					});
				} else if(index == 21) {
					buttons[index].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(tmpStr.startsWith("-", 0) == false) {
								tmpStr = "-" + tmpStr;
								tField.setText(tmpStr);
							} else if(tmpStr.startsWith("-") == true) {
								tmpStr = tmpStr.replace(String.valueOf(tmpStr.charAt(0)), "");
								tField.setText(tmpStr);
							}
						}
					});
				}
				
				//Backspace action
				if(index == 0) {
					buttons[index].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(tmpStr.length() > 1) {
								if(tmpStr.charAt(tmpStr.length() - 2) != 46) {
									tmpStr = tmpStr.substring(0, tmpStr.length() - 1);
									tField.setText(tmpStr);
								} else if(tmpStr.charAt(tmpStr.length() - 2) == 46) {
									tmpStr = tmpStr.substring(0, tmpStr.length() - 2);
									tField.setText(tmpStr);
								}
							}
							else if(tmpStr.length() == 1) {
								tmpStr = "";
								tField.setText("");
							}
						}
					});
				}
				
				//Operand actions and a result action.
				if(index == 8 || index == 13 || index == 18 || index == 23 || index == 24) {
					final int i = index;
					buttons[index].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(i == 8) { //Division
								tmpOper = "/";
								interStr = tmpStr;
								if(interStr != "" && mainStr != "") {
									interStr = mainStr;
								}
								tmpStr = "";
								tField.setText("");
							}
							if(i == 13) { //Multiplication
								tmpOper = "*";
								interStr = tmpStr;
								if(interStr != "" && mainStr != "") {
									interStr = mainStr;
								}
								tmpStr = "";
								tField.setText(mainStr);
								
							}
							if(i == 18) { //Deduction
								tmpOper = "-";
								interStr = tmpStr;
								if(interStr != "" && mainStr != "") {
									interStr = mainStr;
								}
								tmpStr = "";
								tField.setText(mainStr);
							}
							if(i == 23) { //Addition
								tmpOper = "+";
								interStr = tmpStr;
								if(interStr != "" && mainStr != "") {
									interStr = mainStr;
								}
								tmpStr = "";
								tField.setText(mainStr);
							}
							if(i == 24) {
								if(tmpOper == "/") {
										double tmpnum = 0;
										tmpnum = div(Double.parseDouble(interStr), Double.parseDouble(tmpStr));	
										mainStr = String.valueOf(tmpnum);
										tmpStr = mainStr;
										tField.setText(tmpStr);
									} 
								if (tmpOper == "*" ) {
										double tmpnum = 0;
										tmpnum = mul(Double.parseDouble(interStr), Double.parseDouble(tmpStr));	
										mainStr = String.valueOf(tmpnum);
										tmpStr = mainStr;
										tField.setText(tmpStr);
									}
								if (tmpOper == "+") {
										double tmpnum = 0;
										tmpnum = add(Double.parseDouble(interStr), Double.parseDouble(tmpStr));	
										mainStr = String.valueOf(tmpnum);
										tmpStr = mainStr;
										tField.setText(tmpStr);
									}
								if (tmpOper == "-") {
										double tmpnum = 0;
										tmpnum = ded(Double.parseDouble(interStr), Double.parseDouble(tmpStr));	
										mainStr = String.valueOf(tmpnum);
										tmpStr = mainStr;
										tField.setText(tmpStr);
									}
							}
						}
					});
				}		
				//CE and C
				if(index == 3 || index == 4) {
					final int i = index;
					buttons[index].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(i == 3) {
								mainStr = ""; interStr = ""; tmpStr = "";
								tField.setText("");
							}
							if(i == 4) {
								tmpStr = "";
								tField.setText("");
							}
						}
					});
				}
				
				//Square Root, Leftover, and 1/x
				if (index == 9 || index == 14 || index == 19) {
					final int i = index;
					buttons[index].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(i == 9) {
								double tmpnum = Double.parseDouble(tmpStr);
								tmpnum = Math.pow(tmpnum, (1.d/2.d));
								tmpStr = String.valueOf(tmpnum);
								tField.setText(tmpStr);
							}
							if(i == 14) {
								double tmpnum = Double.parseDouble(tmpStr);
								tmpnum = tmpnum / 10.d;
								tmpStr = String.valueOf(tmpnum);
								tField.setText(tmpStr);
							}
							
							if(i == 19) {
								double tmpnum = Double.parseDouble(tmpStr);
								tmpnum = 1.d / tmpnum;
								tmpStr = String.valueOf(tmpnum);
								tField.setText(tmpStr);
							}
						}
					});
				}
				index++;
			}
		}

		add(tField, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pack();
	}
	public double div(double x, double y) {
		return x / y;
	}
	public double mul(double x, double y) {
		return x * y;
	}
	public double add(double x, double y) {
		return x + y;
	}
	public double ded(double x, double y) {
		return x - y;
	}
  
	public static void main(String args[]) {
		Calculator s = new Calculator();
	}
}

