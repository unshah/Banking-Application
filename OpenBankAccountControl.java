/******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: February, 2014													  *
*******************************************************************************/
import java.lang.*; //including Java packages used by this program
import javax.swing.*;
import com.ntu.*;

public class OpenBankAccountControl
{

    public OpenBankAccountControl(String AcountType, String  AcountNumber, String  Name, String  UName, String  Balance) {
		//Use CheckingAccount object to invoke method openAcct()
		if (AcountType.equals("Checking")) {
			CheckingAccount CA = new CheckingAccount(AcountNumber, Name, UName, Balance);
            if (CA.openAcct()) {

            String Transtype= "Deposit";
            String fromAcc="";

			Transactions trans = new Transactions(Transtype, AcountNumber, fromAcc, UName, Balance);
			trans.saveTransaction();

            JOptionPane.showMessageDialog(null, "Opening a Checking Account is Successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            } else
            JOptionPane.showMessageDialog(null, "Opening a Checking Account failed.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (AcountType.equals("Savings")){
			SavingsAccount SA = new SavingsAccount(AcountNumber, Name, UName, Balance);
			if (SA.openAcct()) {

			String Transtype= "Deposit";
			String fromAcc="";

			Transactions trans = new Transactions(Transtype, AcountNumber, fromAcc, UName, Balance);
   			trans.saveTransaction();

			JOptionPane.showMessageDialog(null, "Opening a Savings Account is Successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			} else
			JOptionPane.showMessageDialog(null, "Opening a Savings Account failed.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		}

	}
}