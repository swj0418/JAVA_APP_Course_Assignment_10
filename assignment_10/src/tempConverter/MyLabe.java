package tempConverter;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyLabe {

	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		JPanel panel = new JPanel();
		f.add(panel);
  
		JLabel label1 = new JLabel("ȭ�� �µ�");
		JLabel label2 = new JLabel("���� �µ�");
		JTextField field1 = new JTextField(15);
		JTextField field2 = new JTextField(15);
		JButton button = new JButton("Convert");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float fa = 0.f; float ce = 0.f;
				fa = Float.parseFloat(field1.getText());
				ce = (fa - 32.f) * (5.f/9.f);
				field2.setText("" + ce);
			}
		});
   		panel.add(label1);
		panel.add(field1);
		panel.add(label2);
		panel.add(field2);
		panel.add(button);
  		f.setSize(300, 150);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("�µ���ȯ��");
		f.setVisible(true);
	}
}


