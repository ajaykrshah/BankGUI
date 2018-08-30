import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class CreateAccount extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CreateAccount() {
		// TODO Auto-generated constructor stub
		    
		///////////////////////////////////BAsic View///////////////////////////////////////////////
			ImageIcon icon = new ImageIcon("G:\\WORKSPACE CODES\\newWorkspace\\BankGUI\\src\\logo.jpg");
			ImageIcon bg = new ImageIcon("G:\\WORKSPACE CODES\\newWorkspace\\BankGUI\\src\\bg.png");
			
			setTitle("Create Account");
			setSize(430, 735);
			setLayout(null);
			setIconImage(icon.getImage());
			setContentPane(new JLabel(bg));
			setResizable(false);
		////////////////////////////////////Adding Into View/////////////////////////////////////////////////////////	
			Container pane = getContentPane();
			JLabel label = new JLabel("<html><u>Create Account</u></html>");
			label.setForeground(Color.white);
			final JTextField act_id = new JTextField();	
			final JPasswordField pass = new JPasswordField();	
			final JTextField emailId = new JTextField();	
			final JTextField  phoneNo =new JTextField();
			
			final JComboBox<String> actType = new JComboBox<String>();
			actType.addItem("Checking Account");
			actType.addItem("Saving Account");
			
			
			JLabel gender = new JLabel("Sex:");
			ButtonGroup sex = new ButtonGroup();
			final JCheckBox male = new JCheckBox();
			final JCheckBox female = new JCheckBox();
			sex.add(male);
			sex.add(female);
			
			JButton create = new JButton("Create");
			JButton Back = new JButton("Back");
			
			pane.add(label).setBounds(120,65,200,100);
			
			pane.add(act_id).setBounds(100,220,220,25);
			pane.add(new JLabel("Account Id")).setBounds(20,220,220,25);
			
			pane.add(create).setBounds(220,650,100,30);
			pane.add(Back).setBounds(100,650,100,30);
			pane.add(emailId).setBounds(100,250,220,25);
			pane.add(new JLabel("Email Id :")).setBounds(20,250,220,25);
			
			pane.add(pass).setBounds(100,280,220,25);
			pane.add(new JLabel("Password :")).setBounds(20,280,220,25);
			
			pane.add(gender).setBounds(20,305,220,25);
			pane.add(male).setBounds(100,310,20,20);
			pane.add(new JLabel("M")).setBounds(130,310,20,20);
			pane.add(female).setBounds(160,310,20,20);
			pane.add(new JLabel("F")).setBounds(190,310,20,20);
			
			pane.add(new JLabel("Phone No.")).setBounds(20,335,60,25);
			pane.add(phoneNo).setBounds(100,335,220,25);
			pane.add(new JLabel("Account Type:")).setBounds(20,365,90,25);
			pane.add(actType).setBounds(100, 365, 130, 30);;
			
//////////////////////////////////////////VIEW SETUP///////////////////////////////////////////////	
			
			
			act_id.setHorizontalAlignment(JTextField.CENTER);
			act_id.setToolTipText("Enter Account No. for allotment.");
			pass.setHorizontalAlignment(JTextField.CENTER);
			pass.setToolTipText("Set a password");
			emailId.setHorizontalAlignment(JTextField.CENTER);
			emailId.setToolTipText("A valid email Id");
			phoneNo.setHorizontalAlignment(JTextField.CENTER);
			phoneNo.setToolTipText("Your Phone No.");
			
			
			
			
			create.setFocusable(false);
			Back.setFocusable(false);
		
			label.setFont(new Font("Forte", Font.BOLD | Font.ITALIC, 25));
			create.setFont(new Font("Forte", Font.BOLD, 20));
			Back.setFont(new Font("Forte", Font.BOLD, 20));
			male.setSelected(true);
			
//////////////////////////////////////////Listener SETUP///////////////////////////////////////////////	
			
			
			
			create.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
						String name = act_id.getText();
						String password = new String(pass.getPassword());
						String emailString = emailId.getText();
						String contactNo = phoneNo.getText();
						String act_type = (String) actType.getSelectedItem();
						
						String sexType="";
							if (male.isSelected()) {
								sexType = "M";
							} else if(female.isSelected()) {
								sexType = "F";
							}
						
					if(name.isEmpty()|| password.isEmpty()|| emailString.isEmpty()){
						getToolkit().beep();
							JOptionPane.showMessageDialog(null,
								    "Properly Fill the entries first",
								    "SignUp Error",
								    JOptionPane.ERROR_MESSAGE);
						}
						else{	
						
							getToolkit().beep();
							if (act_type.equalsIgnoreCase("Saving Account")) {
								try {
									new SavingAccount(name,password,"0",emailString,contactNo,sexType,act_type);
								} catch (Throwable e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
							} else if (act_type.equalsIgnoreCase("Checking Account")){
								try {
									new CheckingAccount(name,password,"0",emailString,contactNo,sexType,act_type);
								} catch (Throwable e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							
						}
							 JOptionPane.showMessageDialog(null,
									 "Successfuly Signup");
							dispose();
							new StartMain().setVisible(true);
						
						
					}	
			
				}
			});
				
			Back.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
						new StartMain().setVisible(true);
						dispose();
				}
			});
			
			act_id.addKeyListener(new KeyAdapter() {
				
			
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					  if (!Character.isDigit(e.getKeyChar())){
						  getToolkit().beep();
							JOptionPane.showMessageDialog(null,
								    "Only Numbers are allowed",
								    "Error",
								    JOptionPane.ERROR_MESSAGE);
						 
								act_id.setText("");
						
				      }
				}
			});
			
			phoneNo.addKeyListener(new KeyAdapter() {
				
				
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					getToolkit().beep();
					  if (!Character.isDigit(e.getKeyChar())){
							JOptionPane.showMessageDialog(null,
								    "Phone No. should be Numeric",
								    "Error",
								    JOptionPane.ERROR_MESSAGE);
						 phoneNo.setText("");
				      }
					  
				
				}
			});
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	}
}
