import java.lang.*; //including Java packages used by this program
import java.sql.*;
import javax.swing.*;
import java.util.*;
import com.ntu.*;

public class InquireTransControl
{

	private String AccountType;
		private String AccountNumber;
		private String Name;
		private String UName;
		private String StartDate;
		private String EndDate;

		public InquireTransControl(String AccountType, String  AccontNumber, String  Name, String  UName, String StartDate, String EndDate)
		{
			this.AccountType = AccountType;
	        this.AccountNumber = AccountNumber;
			this.Name = Name;
			this.UName =UName;
			this.StartDate = StartDate;
			this.EndDate = EndDate;
	    }

	    public InquireTransControl(){
		}

		public Vector InquireMethod(){


	            Vector ve = new Vector();
				if(AccountType.equals("Checking")){

								CheckingAccount CA = new CheckingAccount();
								String AccountNb =  CA.getCheckingAcctNumber(UName);


			Transactions ts = new Transactions(UName);
			System.out.println("starting "+StartDate+"endinh"+EndDate);
			ve = ts.TransFound(StartDate,EndDate);
			Vector<String> value = new Vector<String>(7);
	       	value.add(0,"TransactionID");
	       	value.add(1,"Amount");
	       	value.add(2,"TransactionType");
	       	value.add(3,"Time");
	       	value.add(4,"Date");
	       	value.add(5,"FromAccount");
	       	value.add(6,"ToAccount");
	       	value.add(7,"UserID");



	       	ShowTransactionBO st = new ShowTransactionBO(ve,value);

		  }
		  return ve;
  }
}