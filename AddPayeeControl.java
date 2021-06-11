/******************************************************************************
*	Program Author:	Name:	Ujjwal N Shah						ID:	1794487				  *
*	Midterm Exam Date: March 10, 2021		Class:	CSCI 4380						  *
*******************************************************************************/

import java.lang.*; //including Java packages used by this program
import javax.swing.*;
import com.ntu.*;

public class AddPayeeControl
{
    private Payee NewPayee;

    public AddPayeeControl(String PANumber, String PName) {
		NewPayee = new Payee(PName, PANumber);
		Boolean Added = NewPayee.add(PName, PANumber);
        if (!Added) {
            System.out.println("fail!");
            JOptionPane.showMessageDialog(null, "Add Payee failed because of invalid payee name or Payee Account Number.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            System.out.println("successful!");
            JOptionPane.showMessageDialog(null, "Add Payee is successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}