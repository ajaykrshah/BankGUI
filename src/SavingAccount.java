

public class SavingAccount extends BankAccount{
	public SavingAccount(int actno, int balance) {
		super(actno, balance);
		// TODO Auto-generated constructor stub
	}
	
	
		
	public SavingAccount (String act_id, String password,String amt,String email,String phone,String sex,String act_type) throws Throwable{
		super(0, 0);
		// TODO Auto-generated constructor stub
			
		MySqlCheck obj= new MySqlCheck();
		 obj.create(act_id, password, "0", email, phone, sex, act_type);
		 System.out.println("Saving Account object created");
	}
	
}
