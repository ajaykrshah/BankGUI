import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class StartMain extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public StartMain() {
		// TODO Auto-generated constructor stub
		ImageIcon icon = new ImageIcon("G:\\WORKSPACE CODES\\newWorkspace\\BankGUI\\src\\logo.jpg");
		ImageIcon bg = new ImageIcon("G:\\WORKSPACE CODES\\newWorkspace\\BankGUI\\src\\bg.png");
		
			setTitle("Youth Bank");
			setSize(430, 735);
			setLayout(null);
			setIconImage(icon.getImage());
			setContentPane(new JLabel(bg));
			setResizable(false);
			Container pane = this.getContentPane();
		
			//////////////////////////////////View Addings//////////////////////////////////////////
			
			JLabel label = new JLabel("<html><u>Login</u></html>");
			label.setForeground(Color.white);
			final JTextField id = new JTextField();
			final JPasswordField password = new JPasswordField();
			JButton login = new JButton("Login");
			JButton create = new JButton("Create");
			
			
			pane.add(label).setBounds(170,65,80,100);
			pane.add(new JLabel("Account Id:")).setBounds(20, 200, 80, 30);
			pane.add(id).setBounds(100,200,220,25);
			pane.add(new JLabel("Password: ")).setBounds(20, 255,80, 30);
			pane.add(password).setBounds(100,255,220,25);
			pane.add(login).setBounds(100, 350, 100,30);
			pane.add(create).setBounds(220,350,100,30);
			
			
			
			id.setHorizontalAlignment(JTextField.CENTER);
			password.setHorizontalAlignment(JPasswordField.CENTER);
			id.setToolTipText("Insert Account Id");
			password.setToolTipText("Insert password");
		
			login.setFocusable(false);
			create.setFocusable(false);
		
			label.setFont(new Font("Forte", Font.BOLD | Font.ITALIC, 30));
			login.setFont(new Font("Forte", Font.BOLD, 20));
			create.setFont(new Font("Forte", Font.BOLD, 20));
			
			
			
	///////////////////////////////////Listeners/////////////////////////////////////////////
			 create.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
					CreateAccount createAccount = new CreateAccount();
					createAccount.setVisible(true);
					dispose();
					
				}
			});	
	  
			 login.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					String user = id.getText();
					String pass = new String(password.getPassword());
					try {
						MySqlCheck login =new MySqlCheck();
						int a =login.checkLogin(user, pass);
						if(a==0){
							setVisible(false);
						}
						else {
							getToolkit().beep();
							JOptionPane.showMessageDialog(null,
								    "Wrong Account Id or Password...",
								    "Login Error",
								    JOptionPane.ERROR_MESSAGE);
							setVisible(true);
							
						}
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						getToolkit().beep();
						JOptionPane.showMessageDialog(null,
							    "Wrong Account Id or Password...",
							    "Login Error",
							    JOptionPane.ERROR_MESSAGE);
						//setVisible(true);
					}
						
				}
			});}
	//////////////////////////////////Main Function//////////////////////////////////////////	
	
	
}
