/******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: February, 2014													  *
*******************************************************************************/

import java.awt.*;     //including Java packages used by this program
import java.awt.event.*;
import javax.swing.*;

class OpenBankAccountPanel extends JPanel implements ActionListener
{
    private JButton OpenButton;
    private JTextField UsernameField, NameField, AccountNumberField, BalanceField;
    private JComboBox CheckingOrSavingsBox;
    private String UName, AccountNumber, Balance, Name, AccountType;

    public OpenBankAccountPanel(String UName, String CustomerName)
    {
        OpenButton = new JButton("Open"); //initializing two button references

        CheckingOrSavingsBox = new JComboBox();
        CheckingOrSavingsBox.addItem("Choose Account Type");
		CheckingOrSavingsBox.addItem("Checking");
		CheckingOrSavingsBox.addItem("Savings");

        UsernameField = new JTextField(15);
        UsernameField.setText(UName);
        NameField = new JTextField(CustomerName);
        AccountNumberField = new JTextField(15);
        BalanceField = new JTextField(15);
        BalanceField.setText("0.0");

        JLabel NameLabel = new JLabel("Customer Name:");
        JLabel UsernameLabel = new JLabel("Username: ");
        JLabel NumberLabel = new JLabel("Account Number:");
        JLabel BalanceLabel = new JLabel("Opening Deposit:");

        JPanel TypePanel = new JPanel();
        JPanel UsernamePanel = new JPanel();
        JPanel NamePanel = new JPanel();
        JPanel NumberPanel = new JPanel();
        JPanel BalancePanel = new JPanel();

        TypePanel.add(CheckingOrSavingsBox);
        UsernamePanel.add(UsernameLabel);
        UsernamePanel.add(UsernameField);
        NamePanel.add(NameLabel);
        NamePanel.add(NameField);
        NumberPanel.add(NumberLabel);
        NumberPanel.add(AccountNumberField);
        BalancePanel.add(BalanceLabel);
        BalancePanel.add(BalanceField);

        OpenButton.addActionListener(this); //event listener registration

        JPanel TopPanel = new JPanel();
        TopPanel.add(TypePanel);
        TopPanel.add(UsernamePanel);

        JPanel CenterPanel = new JPanel();
        CenterPanel.add(NamePanel);
        CenterPanel.add(NumberPanel);
        CenterPanel.add(BalancePanel);
        CenterPanel.add(OpenButton);
        setLayout(new BorderLayout());
        add(TopPanel, BorderLayout.NORTH);
        add(CenterPanel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent evt)  //event handling
    {
        String arg = evt.getActionCommand();
        if (arg.equals("Open")) { //determine which button is clicked
            UName = UsernameField.getText(); //take actions
            Name = NameField.getText();
            AccountNumber = AccountNumberField.getText();
            Balance = BalanceField.getText();
            AccountType = (String)CheckingOrSavingsBox.getSelectedItem();
            if (AccountType.equals("Choose Account Type"))
                JOptionPane.showMessageDialog(null, "Please Choose an Account Type!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            else if (AccountNumber.length() != 8 )
                     JOptionPane.showMessageDialog(null, "Please Enter an Account Number with Exactly 8 Characters!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                 else {
					 OpenBankAccountControl OBAcct_Ctrl = new OpenBankAccountControl(AccountType, AccountNumber, Name, UName, Balance);
				 }

		}
    }
}

public class OpenBankAccountBO extends JFrame
{
    private OpenBankAccountPanel OBA_Panel;

    public OpenBankAccountBO(String UName, String CustomerName)
    {
        setTitle("Open a Bank Account");
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
         OBA_Panel = new OpenBankAccountPanel(UName, CustomerName);
         contentPane.add(OBA_Panel);
         show();
    }

}

