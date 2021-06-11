/******************************************************************************
*	Program Author:	Name:	Ujjwal N Shah						ID:	1794487				  *
*	Midterm Exam Date: March 10, 2021		Class:	CSCI 4380						  *
*******************************************************************************/

import java.awt.*;     //including Java packages used by this program
import java.awt.event.*;
import javax.swing.*;

class AddPayeePanel extends JPanel implements ActionListener
{
    private JButton AddButton;
    private JTextField NameField, AccountNumberField;
    private String AccountNumber, Name;

    public AddPayeePanel()
    {
        AddButton = new JButton("Add"); //initializing two button references

        NameField = new JTextField(15);
        AccountNumberField = new JTextField(15);

        JLabel NameLabel = new JLabel("Payee Name:");
        JLabel NumberLabel = new JLabel("Account Number:");

        JPanel NamePanel = new JPanel();
        JPanel NumberPanel = new JPanel();

        NamePanel.add(NameLabel);
        NamePanel.add(NameField);
        NumberPanel.add(NumberLabel);
        NumberPanel.add(AccountNumberField);

        AddButton.addActionListener(this); //event listener registration

        JPanel CenterPanel = new JPanel();
        CenterPanel.add(NamePanel);
        CenterPanel.add(NumberPanel);
        CenterPanel.add(AddButton);
        setLayout(new BorderLayout());
        add(CenterPanel, BorderLayout.CENTER);

    }

    public void actionPerformed(ActionEvent evt)  //event handling
    {

		String PayeeName = NameField.getText();
		String PayerAccountNumber = AccountNumberField.getText();
		AddPayeeControl PayeeC = new AddPayeeControl(PayerAccountNumber, PayeeName);
    }
}

public class AddPayeeBO extends JFrame
{
    private AddPayeePanel Payee_Panel;

    public AddPayeeBO()
    {
        setTitle("Add Payee");
        setSize(450, 200);

         //get screen size and set the location of the frame
         Toolkit tk = Toolkit.getDefaultToolkit();
         Dimension d = tk.getScreenSize();
         int screenHeight = d.height;
         int screenWidth = d.width;
         setLocation( screenWidth / 3, screenHeight / 4);

         addWindowListener (new WindowAdapter()  //handle window event
            {
		       public void windowClosing (WindowEvent e)
			                  { System.exit(0);
               }
            });

         Container contentPane = getContentPane(); //add a panel to a frame
         Payee_Panel = new AddPayeePanel();
         contentPane.add(Payee_Panel);
         show();
    }

    public static void main(String [] args)
    { JFrame frame = new AddPayeeBO(); //initialize a JFrame object
      frame.show(); //display the frame
    }
}
