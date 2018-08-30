import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class MySqlCheck {

	 	Connection con = null;
	 	 Statement stmt;
		 MySqlCheck()throws Exception{
		
		Class.forName("com.mysql.jdbc.Driver");  
		 con=DriverManager.getConnection("jdbc:mysql:///test","root","ajay"); 
		  stmt =con.createStatement();
			
		 }
		
		 void create(String act_id, String password,String amt,String email,String phone,String sex,String act_type) throws SQLException{
			 try { 
					PreparedStatement ps =con.prepareStatement("insert into MySqlBankTable values(?,?,?,?,?,?,?)");
					ps.setString(1, act_id);
					ps.setString(2, password);
					ps.setString(3, amt);
					ps.setString(4, email);
					ps.setString(5, phone);
					ps.setString(6, sex);
					ps.setString(7, act_type);
					ps.execute();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					
			stmt.execute("create table MySqlBankTable(account_id varchar(20),password varchar(12),balance varchar(10),email varchar(40),"
					+ "phone varchar(12),sex char(3),act_type char(25))");
				PreparedStatement ps =con.prepareStatement("insert into MySqlBankTable values(?,?,?,?,?,?,?)");
				ps.setString(1, act_id);
				ps.setString(2, password);
				ps.setString(3, amt);
				ps.setString(4, email);
				ps.setString(5, phone);
				ps.setString(6, sex);
				ps.setString(7, act_type);
				ps.execute();
					
				}		
			}
		 
		
		 int checkLogin(String id, String passValue )throws Exception {
			// TODO Auto-generated constructor stub
			 	String query = "select account_id,password from MySqlBankTable where password='"+passValue+"'";
				ResultSet rs = stmt.executeQuery(query);
			
				int j=1;
				while(rs.next()) {
					String user = rs.getString("account_id");
					if(user.equals(id)){
						int userId = Integer.parseInt(user);
						Home home = new Home(userId);
						home.setVisible(true);
								
						 j=0;
					}	
				}
				return j;
			}
		
		 
		 void deposit(String id, String passValue ,int amt)throws Exception {
				// TODO Auto-generated constructor stub
				
					String query = "select balance from MySqlBankTable where password='"+passValue+"'AND account_id='"+id+"'";
					ResultSet rs = stmt.executeQuery(query);
					int bal=0;
					while(rs.next()) {
					 bal = Integer.parseInt(rs.getString("balance"));}
					String update = "UPDATE MySqlBankTable SET balance='"+(bal+amt)+"' where password='"+
					passValue+"'AND account_id='"+id+"'";
					
					stmt.executeUpdate(update);
					
					
					JOptionPane.showMessageDialog(null,
						    "Transaction Successful.",
						    "Deposit Complete",
						    JOptionPane.INFORMATION_MESSAGE);
				
				}
			 
		 void widraw(String id, String passValue ,int amt)throws Exception {
				// TODO Auto-generated constructor stub

					String query = "select balance from MySqlBankTable where password='"+passValue+"'AND account_id='"+id+"'";
					ResultSet rs = stmt.executeQuery(query);
					int bal=0;
					while(rs.next()) {
					 bal = Integer.parseInt(rs.getString("balance"));}
						if(bal>=amt){
					String update = "UPDATE MySqlBankTable SET balance='"+(bal-amt)+"' where password='"+
					passValue+"'AND account_id='"+id+"'";
						stmt.executeUpdate(update);
						JOptionPane.showMessageDialog(null,
							    "Transaction Successful.",
							    "Widraw Complete",
							    JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null,
								    "Insufficient balance...",
								    "Transaction Error",
								    JOptionPane.ERROR_MESSAGE);
						}
				}
			 
		 ResultSet checkBalance(String id)throws Exception {
				// TODO Auto-generated constructor stub
				 
					String query = "select account_id,balance from MySqlBankTable where account_id='"+id+"'";
					ResultSet rs = stmt.executeQuery(query);
						
					return rs;
				} 
		 
		 
		 
		 
}

