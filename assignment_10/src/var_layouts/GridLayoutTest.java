package var_layouts;
import java.awt.*;
import javax.swing.*;
 
class GridLayoutTest extends JFrame {
       public GridLayoutTest() {
 
             setTitle("GridLayoutTest");
             setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
             setLayout(new GridLayout(0, 3));	// 3���� ���� �ʿ��� ��ŭ�� ��
 
             add(new JButton("Button1"));
             add(new JButton("Button2"));
             add(new JButton("Button3"));
             add(new JButton("B4"));
             add(new JButton("Long Button5"));
 
             pack();
             setVisible(true);
       }
       public static void main(String[] ar) {
    	   new GridLayoutTest();
       }
}
 
