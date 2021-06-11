/******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: February, 2014													  *
*******************************************************************************/

import java.lang.*; //including Java packages used by this program
import javax.swing.*;
import com.ntu.*;

public class LoginControl
{
    private Account Acct;

    public LoginControl(String UName, String PWord) {
		Acct = new Account(UName, PWord);
	}

	public String signIn(){
			//Acct = new Account(UName, PWord);
			System.out.println("---->");
			String CustomerName = Acct.signIn();
			System.out.println(CustomerName);
			return CustomerName;
	}
}