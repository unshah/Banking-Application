import java.lang.*; //including Java packages used by this program
import java.sql.*;
import javax.swing.*;
import java.util.*;
import com.ntu.*;

public class DepositControl
{

	private String AccountType;
		private String AccountNumber;
		private String Name;
		private String UName;
		private String Balance;

	    public DepositControl(String AccountType, String  AccountNumber, String  Name, String  UName, float Balance) {
			this.AccountType =AccountType;
			this.AccountNumber = AccountNumber;
			this.Name = Name;
			this.UName =UName;
			this.Balance = Float.toString(Balance);

		}

		public float DepositToAccount(){
			float Bal = -1;
	        System.out.println("coltroller"+Balance);
			if (AccountType.equals("Checking")) {
						System.out.println(AccountType);

						CheckingAccount CA = new CheckingAccount();

						System.out.println("ACcount NUmber "+ CA.getCheckingAcctNumber(UName)+"--- USername "+UName);
						String AccountNb =  CA.getCheckingAcctNumber(UName);
						 CA = new CheckingAccount(AccountNb, Name, UName, Balance);
						System.out.println(AccountNumber);
						Bal=Float.parseFloat(Balance);
						Bal=CA.addDeposit(AccountNb,Bal);
						System.out.println(Bal);
						if(Bal!=-1){
							Transactions TC= new Transactions("Deposit",AccountNb,"0",UName,Balance);
			            	TC.saveTransaction();
						}
				   }
				   else if (AccountType.equals("Savings")) {
					        System.out.println(AccountType);
					        SavingsAccount SA = new SavingsAccount();
					        System.out.println("ACcount NUmber "+ SA.getSavingsAcctNumber(UName)+"--- USername "+UName);
					        String AccountNb =  SA.getSavingsAcctNumber(UName);
				   		     SA = new SavingsAccount(AccountNb, Name, UName, Balance);
				   		    System.out.println(AccountNb);
				   			Bal=Float.parseFloat(Balance);
				   			Bal=SA.addDeposit(AccountNb,Bal);
				   			System.out.println(Bal);
				   			if(Bal!=-1){
				               	Transactions TS= new Transactions("Deposit",AccountNb,"0",UName,Balance);
				               	TS.saveTransaction();
				             }
					}

					return Bal;

		}

}