

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("unused")
public class SplashGUI extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SplashGUI() {
		// TODO Auto-generated constructor stub
		ImageIcon bg = new ImageIcon("G:\\WORKSPACE CODES\\newWorkspace\\BankGUI\\src\\splash.jpg");
		ImageIcon icon = new ImageIcon("G:\\WORKSPACE CODES\\newWorkspace\\BankGUI\\src\\splash.jpg");
		setIconImage(icon.getImage());
		setResizable(false);
		setTitle("Splash");
		setSize(430, 735);
		setLayout(null);
		setContentPane(new JLabel(bg));
		
	
	} 
		
	} 


