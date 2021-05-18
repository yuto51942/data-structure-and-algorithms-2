// 例6-7
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
interface Constant {
    int WIDTH = 300;
    int HEIGHT = 200;
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
    public static void main(String[] arg) throws IOException {
	final MyFrame frame = new MyFrame();
	final Container contentPane = frame.getContentPane();
	final MyLabel label = new MyLabel();
	final ActionListener listener = label.getActionListener();
	contentPane.add(label,BorderLayout.CENTER);
	frame.setVisible(true);
	final BufferedReader br
           = new BufferedReader(new InputStreamReader(System.in));
	String line;
	while((line=br.readLine())!=null){
		ActionEvent e = new ActionEvent(br,
                     ActionEvent.ACTION_PERFORMED,line);
		listener.actionPerformed(e);
	}
	frame.dispose();
    }
}
