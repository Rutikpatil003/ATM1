

import java.util.Scanner;

class Bankaccount 
{
	
	String name;
	String username;
	String Password;
	String Account;
	float balance = 100000f;
	int Transactions = 0;
	String TransactionHistory = "";
	
	public void register() 
	{
		System.out.println("##########################################");
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter  Name - ");
		this.name = sc.nextLine();
		System.out.print("\nEnter  Username - ");
		this.username = sc.nextLine();
		System.out.print("\nEnter Password - ");
		this.Password = sc.nextLine();
		System.out.print("\nEnter  Account Number - ");
		this.Account = sc.nextLine();
		System.out.println("##########################################");
		System.out.println("\nRegistration Successfully Completed.....");
		System.out.println("##########################################");
	}
	
	public boolean login() 
	{
		boolean isLogin = false;
		Scanner sc = new Scanner(System.in);
		while ( !isLogin ) 
		{
			System.out.print("\nEnter  Username - ");
			String Username = sc.nextLine();
			if ( Username.equals(username) ) 
			{
				while ( !isLogin ) 
				{
					System.out.print("\nEnter  Password - ");
					String Password = sc.nextLine();
					if ( Password.equals(Password) ) 
					{
						System.out.println("##########################################");
						System.out.print("\nYou Logined Successfully.....");
						System.out.println("##########################################");
						isLogin = true;
					}
					else 
					{
						System.out.println("\n InValid Password......");
					}
				}
			}
			else 
			{
				System.out.println("\nUsername Invalid or Not Found.....");
			}
		}
		return isLogin;
	}
	
	public void withdraw() 
	{
		
		System.out.print("\nEnter Amount for Withdrawal :- ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		try 
		{
			
			if ( balance >= amount ) 
			{
				Transactions++;
				balance -= amount;
				System.out.println("##########################################");
				System.out.println("\nMoney Withdrawn Successfully");
				System.out.println("##########################################");
				String str = amount + " Rs Withdrawed\n";
				TransactionHistory = TransactionHistory.concat(str);
				
			}
			else 
			{
				System.out.println("\nInsufficient Balance in Account");
			}
		}
		catch ( Exception e) 
		{
			System.out.println(e);
		}
	}
	
	public void deposit() 
	{
		
		System.out.print("\nEnter amount to deposit - ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		
		try 
		{
			if ( amount <= 100000f ) 
			{
				Transactions++;
				balance += amount;
				System.out.println("##########################################");
				System.out.println("\nMoney Successfully Deposited");
				System.out.println("##########################################");
				String str = amount + " Rs deposited\n";
				TransactionHistory = TransactionHistory.concat(str);
			}
			else 
			{
				System.out.println("\nLimit is 100000");
			}
			
		}
		catch ( Exception e) 
		{
			System.out.println(e);
		}
	}
	
	public void transfer() 
	{
		
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Receiver's Name :- ");
		String receipent = sc.nextLine();
		System.out.print("\nEnter Amount  Transfer :- ");
		float amount = sc.nextFloat();
		
		try 
		{
			if ( balance >= amount ) 
			{
				if ( amount <= 50000f ) 
				{
					Transactions++;
					balance -= amount;
					System.out.println("##########################################");
					System.out.println("\nMoney Successfully Transfered to  " + receipent);
					System.out.println("##########################################");
					String str = amount + " Rs transfered to " + receipent + "\n";
					TransactionHistory = TransactionHistory.concat(str);
				}
				else 
				{
					System.out.println("\nLimit is 50000.00");
				}
			}
			else 
			{
				System.out.println("\nInsufficient Balance in Account....");
			}
		}
		catch ( Exception e) 
		{
			System.out.println(e);
		}
	}
	
	public void checkBalance() 
	{
		System.out.println("\n" + balance + " Rs");
	}
	public void transHistory() 
	{
		if ( Transactions == 0 ) 
		{
			System.out.println("\nempty");
		}
		else 
		{
			System.out.println("\n" + TransactionHistory);
		}
	}
}


public class Atminterface 
{	
	public static int takeIntegerInput(int limit) 
	{
		int input = 0;
		boolean flag = false;
		
		while ( !flag ) 
		{
			try 
			{
				Scanner sc = new Scanner(System.in);
				input = sc.nextInt();
				flag = true;
				
				if ( flag && input > limit || input < 1 ) 
				{
					System.out.println("Select Number 1 to " + limit);
					flag = false;
				}
			}
			catch ( Exception e ) 
			{
				System.out.println("only integer value Allowed ");
				flag = false;
			}
		};
		return input;
	}
	
	
	public static void main(String[] args) 
	{
		System.out.println("##########################################");
		System.out.println("\nWelcome ATM Machine\n");
		System.out.println("##########################################");
		System.out.println("1.Register \n2.Exit");
		System.out.print("Enter Your Choice - ");
		int choice = takeIntegerInput(2);
		
		if ( choice == 1 ) {
			Bankaccount b = new Bankaccount();
			b.register();
			while(true) {
				System.out.println("\n1.Login \n2.Exit");
				System.out.print("Enter Valid Choice - ");
				int ch = takeIntegerInput(2);
				if ( ch == 1 ) {
					if (b.login()) {
						System.out.println("\n\n**********You are Welcome Back " + b.name + " **********\n");
						boolean isFinished = false;
						while (!isFinished) {
							System.out.println("##########################################");
							System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
							System.out.println("##########################################");
							System.out.print("\nEnter Your Choice - ");
							int c = takeIntegerInput(6);
							switch(c) {
								case 1:
								{
									b.withdraw();
								    break;
								}
								case 2:
								{
									b.deposit();
									break;
								}
								case 3:
								{
									b.transfer();
									break;
								}
								case 4:
								{
									b.checkBalance();
									break;
								}
								case 5:
								{
									b.transHistory();
									break;
								}
								case 6:
								{
									isFinished = true;
									break;
								}
							}
						}
					}
				}
				else 
				{
					System.exit(0);
				}
			}
		}
		else 
		{
			System.exit(0);
		}
	}
}	