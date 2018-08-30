import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Home extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public Home(final int actNo) {
		// TODO Auto-generated constructor stub
		ImageIcon icon = new ImageIcon("G:\\WORKSPACE CODES\\newWorkspace\\BankGUI\\src\\logo.jpg");
		ImageIcon bg = new ImageIcon("G:\\WORKSPACE CODES\\newWorkspace\\BankGUI\\src\\bg.png");
		//ImageIcon atm = new ImageIcon("C:\\Users\\Aksh\\Desktop\\HTML\\Complete\\src\\atm.jpg");
		
		setTitle("Home");
		setSize(430, 735);
		setLayout(null);
		setIconImage(icon.getImage());
		setContentPane(new JLabel(bg));
		setResizable(false);
		Container pane = getContentPane();
		
		////////////////////////////////////////////Tab Creation////////////////////////////////////////////
		JTabbedPane TabbedPane = new JTabbedPane();
		pane.add(TabbedPane).setBounds(0,0,430,735);
		
		
		
		////////////////////////////////////////////Tab1///////////////////////////////////////////////////
		JPanel tab1 = new JPanel();
		TabbedPane.addTab("Banking", tab1);
		tab1.setLayout(new BorderLayout());
		final JLabel bg1=new JLabel(bg);
		tab1.add(bg1).setBounds(0,0,430,735);
		final JButton back = new JButton("Back");
		bg1.add(back).setFocusable(false);
		back.setVisible(false);
		back.setBounds(210,0,100,20);
		JButton logout = new JButton("Logout");
		bg1.add(logout).setBounds(311,0,100,20);		
		
		final JLabel transaction = new JLabel("<html><u>Transaction</u></html>");
				bg1.add(transaction).setBounds(120,65,180,100);
				transaction.setFont(new Font("Forte", Font.BOLD | Font.ITALIC, 30));
				transaction.setForeground(Color.white);
				
				final JLabel balEnquary = new JLabel("<html><u>Balance Enuqiry</u></html>");
				bg1.add(balEnquary).setBounds(120,65,180,100);
				balEnquary.setFont(new Font("Forte", Font.BOLD | Font.ITALIC, 30));
				balEnquary.setForeground(Color.white);	
				balEnquary.setVisible(false);
				
				final JButton widraw =new JButton("Widraw");
				bg1.add(widraw).setBounds(90,200,200,50);	
				final JButton deposit = new JButton("Deposit");
				bg1.add(deposit).setBounds(90,280,200,50);
				final JButton enquiry = new JButton("Enquiry");
				bg1.add(enquiry).setBounds(90,360,200,50);
				enquiry.setFocusable(false);
				widraw.setFocusable(false);
				deposit.setFocusable(false);
				
				
				
				final JLabel idLabel = new JLabel("Account");
				final JLabel passLabel = new JLabel("Password");
				final JLabel amountWidraw = new JLabel("Widraw Amount");
				final JLabel amountDeposit = new JLabel("Deposit Amount");
				final JButton submitWidraw = new JButton("Submit");
				final JButton submitDiposit = new JButton("Submit");
				final JButton submitEnquiry = new JButton("Submit");
				final JTextField textId = new JTextField();
				final JPasswordField textPass = new JPasswordField();
				final JTextField textWidraw = new JTextField();
				final JTextField textDeposit = new JTextField();
				bg1.add(amountWidraw);
				bg1.add(amountDeposit);
				bg1.add(submitDiposit);
				bg1.add(submitWidraw);
				bg1.add(submitEnquiry);
				bg1.add(textWidraw);
				bg1.add(textDeposit);
				bg1.add(idLabel);
				bg1.add(passLabel);
				bg1.add(textId);
				bg1.add(textPass);
				final JTextArea slip = new JTextArea();
				bg1.add(slip).setBounds(90,200,250,200);
				slip.setBackground(Color.cyan);
				
				
				idLabel.setBounds(75, 170, 100, 25);
				passLabel.setBounds(75,200, 100, 25);
				textId.setBounds(170,170,180,25);
				textPass.setBounds(170, 200, 180, 25);
				
				amountWidraw.setBounds(75,230, 100, 25);
				textWidraw.setBounds(170, 230,180, 25);
				submitWidraw.setBounds(250, 280, 100, 30);
				submitEnquiry.setBounds(250, 250, 100, 30);
				amountDeposit.setBounds(75,230, 100, 25);
				textDeposit.setBounds(170, 230,180, 25);
				submitDiposit.setBounds(250, 280, 100, 30);
				
				textId.setVisible(false);
				textPass.setVisible(false);
				idLabel.setVisible(false);
				passLabel.setVisible(false);
				amountDeposit.setVisible(false);
				amountWidraw.setVisible(false);
				textDeposit.setVisible(false);
				submitDiposit.setVisible(false);
				textWidraw.setVisible(false);
				submitWidraw.setVisible(false);
				submitEnquiry.setVisible(false);
				slip.setVisible(false);
				
			///////////////////////////////tab1 Listeners/////////////////////////////////////////
				
				widraw.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						widraw.setVisible(false);
						deposit.setVisible(false);
						enquiry.setVisible(false);
						idLabel.setVisible(true);
						passLabel.setVisible(true);
						textId.setVisible(true);
						textPass.setVisible(true);
						amountWidraw.setVisible(true);
						textWidraw.setVisible(true);
						submitWidraw.setVisible(true);
						back.setVisible(true);
					}
				});
				
				
				deposit.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						widraw.setVisible(false);
						deposit.setVisible(false);
						enquiry.setVisible(false);
						idLabel.setVisible(true);
						passLabel.setVisible(true);
						textId.setVisible(true);
						textPass.setVisible(true);
						amountDeposit.setVisible(true);
						textDeposit.setVisible(true);
						submitDiposit.setVisible(true);
						back.setVisible(true);
					}
				});
		
				enquiry.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						widraw.setVisible(false);
						deposit.setVisible(false);
						enquiry.setVisible(false);
						idLabel.setVisible(true);
						textId.setVisible(true);
						submitEnquiry.setVisible(true);
						back.setVisible(true);
						balEnquary.setVisible(true);
						transaction.setVisible(false);
					
					}
				});
								
				back.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						amountDeposit.setVisible(false);
						amountWidraw.setVisible(false);
						textDeposit.setVisible(false);
						submitDiposit.setVisible(false);
						textWidraw.setVisible(false);
						submitWidraw.setVisible(false);
						idLabel.setVisible(false);
						passLabel.setVisible(false);
						textId.setVisible(false);
						textPass.setVisible(false);
						submitEnquiry.setVisible(false);
						widraw.setVisible(true);
						deposit.setVisible(true);
						enquiry.setVisible(true);
						slip.setVisible(false);
						back.setVisible(false);
						balEnquary.setVisible(false);
						transaction.setVisible(true);
					}
				});
				
				logout.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						JOptionPane.showMessageDialog(null,
							    "Logout Successful",
							    "Logout",
							    JOptionPane.INFORMATION_MESSAGE);
						dispose();
						new StartMain().setVisible(true);
					}
				});
				
				////////////////////////////tab1 Submit Buttons Listeners///////////////////////////////////////////
				submitDiposit.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						String id = textId.getText();
						String passString = textPass.getText();
						int amt = Integer.parseInt(textDeposit.getText());
						
						 try {
						 MySqlCheck trans = new MySqlCheck();
							trans.deposit(id, passString, amt);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				
					}
				});
				
				submitWidraw.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						String id = textId.getText();
						String passString = textPass.getText();
						int amt = Integer.parseInt(textWidraw.getText());
						
						 try {
						 MySqlCheck trans = new MySqlCheck();
							trans.widraw(id, passString, amt);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				
					}
				});
						
				submitEnquiry.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						
						String id = textId.getText();
					
						try {
							MySqlCheck enquiry = new MySqlCheck();
							ResultSet r =enquiry.checkBalance(id);
							String enqId="",enqBal="";
							while (r.next()) {
								 enqId = r.getString("account_id");
								 enqBal= r.getString("balance");
							}
							slip.setText("Account Id \t\t Ammount\n------------------------------------------------------------------\n  "+enqId+"\t\t    Rs."+enqBal);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						slip.setVisible(true);
						idLabel.setVisible(false);
						textId.setVisible(false);
						submitEnquiry.setVisible(false);
					}
				});
				
				
				
				
				
				
				
				
				
					
				
		
	}
}
