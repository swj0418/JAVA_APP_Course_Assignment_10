package monteCarloNumbers;
import javax.swing.*;
import java.awt.*;

class MyFrameF extends JFrame {
	JPanel p = new JPanel();
	JLabel[] labels = new JLabel[500];
  
public MyFrameF() {
		p.setLayout(null);
		p.setBackground(Color.YELLOW);
		for (int i = 0; i < 500; i++) {
			labels[i] = new JLabel("" + i);
			int x = (int) (500 * Math.random());
			int y = (int) (200 * Math.random());
			labels[i].setForeground(Color.MAGENTA);
			labels[i].setLocation(x, y);
			labels[i].setSize(20, 20);
			p.add(labels[i]);
		}
		setSize(500, 300);
		add(p);
		setVisible(true); // 프레임을 화면에 표시한다.
	}
}

public class MyFrame {
	public static void main(String args[]) {
		MyFrameF f = new MyFrameF();
	}
}
