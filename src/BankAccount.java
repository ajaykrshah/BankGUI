




public class BankAccount {
	int accountNumber;
	protected int balance;
	BankAccount(int actNo)
	{
		
	}

	public BankAccount(int actno, int balance) {
		this.accountNumber= actno;
		this.balance=balance;
	}
	
	void deposite(int amount){
		this.balance+=amount;
	}

	void withdraw(int amount){
	//	this.balance=this.balance-amount;
	}

	void printBalance(){
		//System.out.println("Acctount no.");
	}
	
	int getBalance(){
		return balance;
	}
	
	void setBalance(int amount){
		balance= amount;
	}
	

}
