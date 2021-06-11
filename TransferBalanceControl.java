import java.lang.*; //including Java packages used by this program
import java.sql.*;
import javax.swing.*;
import java.util.*;
import com.ntu.*;

public class TransferBalanceControl
{
	private String TAccountType;
		private String TAccountNumber;
		private String FAccountType;
		private String FAccountNumber;
		private String Name;
		private String UName;
		private String Balance;
		private float TransferAmount;

	    public TransferBalanceControl(String TAccountType, String  TAccountNumber, String FAccountType, String  FAccountNumber, String  Name, String  UName, float  TransferAmount, float Balance) {

			this.TAccountType =TAccountType;
			this.TAccountNumber = TAccountNumber;
			this.FAccountType = FAccountType;
			this.FAccountNumber = FAccountNumber;
			this.Name = Name;
			this.UName =UName;
			this.Balance = Float.toString(Balance);
			this.TransferAmount = TransferAmount;
			}

			public String TransferToAccount()
			{
			System.out.println(TAccountType);
			float Bal = -1;

			CheckingAccount CA = new CheckingAccount(Name, UName, Balance);//TransferAmt
	        SavingsAccount SA = new SavingsAccount(Name, UName, Balance);//TransferAmt
	        String checkingAcctNumber = CA.getCheckingAcctNumber(UName);
		    String savingsAcctNumber = SA.getSavingsAcctNumber(UName);
	        Bal = Float.parseFloat(Balance);
			String TransferStatus = "Not Successful";


			if (FAccountType.equals("Checking")) {
				System.out.println(FAccountType);

				System.out.println("chekingACcount NUmber "+ CA.getCheckingAcctNumber(UName)+"--- USername "+UName);

				System.out.println(checkingAcctNumber);
				System.out.println(savingsAcctNumber);
				Bal = CA.getBalance(checkingAcctNumber);
				System.out.println("From Account Bal"+Bal);


				Bal = CA.remWithdraw(checkingAcctNumber,TransferAmount);
				System.out.println(">> Amount remited ");
				Bal = SA.addDeposit(savingsAcctNumber,TransferAmount);
				System.out.println(">> Amount deposited ");


				if(Bal != 1){
	                Transactions TC= new Transactions("Transfer",checkingAcctNumber,savingsAcctNumber,UName,Balance);

			        TC.saveTransaction();
	                TransferStatus = "Sucessful";
				}

			}
			else if (FAccountType.equals("Savings")){
				Bal = SA.getBalance(savingsAcctNumber);
				System.out.println("From Account Bal##"+Bal);

				Bal = SA.remWithdraw(savingsAcctNumber,TransferAmount);
				Bal = CA.addDeposit(checkingAcctNumber,TransferAmount);

				if(Bal != 1){

					Transactions TC= new Transactions("Transfer",checkingAcctNumber,savingsAcctNumber,UName,Balance);

			        TC.saveTransaction();
					TransferStatus = "Sucessful";

				}


			}
			System.out.println("Transfer Status from Controller "+ TransferStatus);
			return TransferStatus;

		}}
