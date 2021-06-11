import java.lang.*; //including Java packages used by this program
import java.sql.*;
import javax.swing.*;
import java.util.*;
import com.ntu.*;

public class AccountOControl
{
    private String FromAccountType;
	private String Name;
	private String UName;
	private String Balance;
	private String FromAccountNumber;


	public AccountOControl (String FromAccountType, String  FromAccountNumber, String  Name, String  UName, float Balance )
		{
			this.FromAccountType = FromAccountType;
	        this.FromAccountNumber = FromAccountNumber;
			this.Name = Name;
			this.UName =UName;
			this.Balance = Float.toString(Balance);
    }
    public float ViewMethod()
    {
       float Bal = -1;
      if (FromAccountType.equals("Checking")) {



	  						CheckingAccount CA = new CheckingAccount();
	  						System.out.println("ACcount NUmber "+ CA.getCheckingAcctNumber(UName)+"--- USername "+UName);
	  						String AccountNb =  CA.getCheckingAcctNumber(UName);
							CA = new CheckingAccount(AccountNb, Name, UName, Balance);
							System.out.println(AccountNb);
					        Bal=Float.parseFloat(Balance);

	  						Bal=CA.getBalance();

	  						System.out.println(Bal);
	  					}
	  					else if (FromAccountType.equals("Savings")) {
							SavingsAccount SA = new SavingsAccount();
						    System.out.println("ACcount NUmber "+ SA.getSavingsAcctNumber(UName)+"--- USername "+UName);
						    String AccountNb =  SA.getSavingsAcctNumber(UName);
			   		        SA = new SavingsAccount(AccountNb, Name, UName, Balance);
	  						System.out.println(AccountNb);
	  						Bal=SA.getBalance();

			   			    Bal=Float.parseFloat(Balance);
		}
		return Bal;
	}



}