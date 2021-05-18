// 例6-6
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
class ButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e){//プログラムが長いので
	System.out.println(e.getActionCommand());//ラムダ式を使わず
	System.out.println(e.getModifiers());
	System.out.println(e.getWhen());
	System.out.println(e.paramString());
    }
}
class Rei {
    public static void main(String[] arg){
	final MyFrame frame = new MyFrame();
	Container contentPane = frame.getContentPane();
	JPanel panel = new JPanel();
	ActionListener listener = new ButtonListener();
	for(String title : Constant.titles){
	    JButton button = new JButton(title);
	    button.addActionListener(listener);
	    panel.add(button);
	}
	contentPane.add(panel);
	frame.setVisible(true);
    }
}
