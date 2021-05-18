// 例6-8
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
interface Constant {
    int WIDTH = 300;
    int HEIGHT = 200;
    String[] titles = new String[]{ "abc", "def", "ghi" };
}
class MyFrame extends JFrame {
    public MyFrame(){
        super();
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(Constant.WIDTH,Constant.HEIGHT);
    }
}
class MyLabel extends JLabel {
    public ActionListener getActionListener(){
	return (e)->setText(e.getActionCommand());
    }
}
class Rei {
    public static void main(String[] arg) {
	final MyFrame frame = new MyFrame();
	final Container contentPane = frame.getContentPane();
	final JPanel panel = new JPanel();
	final MyLabel label = new MyLabel();
	final ActionListener listener = label.getActionListener();
	for(String title : Constant.titles){
	    JButton button = new JButton(title);
	    button.addActionListener(listener);
	    panel.add(button);
	}
	contentPane.add(label,BorderLayout.CENTER);
	contentPane.add(panel,BorderLayout.SOUTH);
	frame.setVisible(true);
    }
}
