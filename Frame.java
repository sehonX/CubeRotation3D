package Skladanie;
import javax.swing.*;
import java.awt.*;
public class Frame extends JFrame{
	public Frame(){
		Container contentPane = getContentPane();
		Panel panel = new Panel();
		contentPane.add(panel);
		setBounds(0,0,800,800);
		
	}
}
