import java.awt.*;     //including Java packages used by this program1
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.Scanner;
import com.ntu.*;

class AccountOBO extends JPanel implements ActionListener
{
	private JButton OpenButton;
	private JTextField UsernameField, NameField, FromAccountNumberField,ToAccountNumberField, AmountField;
    private JComboBox CheckingOrSavingsBox1,CheckingOrSavingsBox2;
    private String UName, FromAccountNumber, ToAccountNumber, Amount, Name, FromAccountType, ToAccountType;
    private Account Acct;
    private double Bal= -1;

    public AccountOBO(String UName, String CustomerName)
    {
		OpenButton = new JButton("View"); //initializing two button references

		CheckingOrSavingsBox1 = new JComboBox();
        CheckingOrSavingsBox1.addItem("Choose From Account Type");
		CheckingOrSavingsBox1.addItem("Checking");
		CheckingOrSavingsBox1.addItem("Savings");

        UsernameField = new JTextField(15);
        UsernameField.setText(UName);
        NameField = new JTextField(15);
        NameField.setText(CustomerName);
        FromAccountNumberField = new JTextField(15);
        ToAccountNumberField = new JTextField(15);
        AmountField = new JTextField(15);



        JLabel NameLabel = new JLabel("Customer Name:");
        JLabel UsernameLabel = new JLabel("Username: ");

        JLabel AmountLabel = new JLabel("Amount:");


        JPanel TypePanel1 = new JPanel();

        TypePanel1.add(CheckingOrSavingsBox1);

        OpenButton.addActionListener(this); //event listener registration
        //declare and initialize a GridBagLayout object
			  GridBagLayout gbl = new GridBagLayout();
			  setLayout(gbl); //let the layout manager be GridBagLayout
			  //declare and initialize a GridBagConstraints object
			  GridBagConstraints gbc = new GridBagConstraints();
		     //apply GridBagConstraints to a GUI component and add it to this panel
		      gbc.fill = GridBagConstraints.NONE;
		      gbc.weightx = 100;
		      gbc.weighty = 100;
      		  add(NameLabel, gbc, 0, 1, 1, 1);

      		  gbc.fill = GridBagConstraints.NONE;
			  		      gbc.weightx = 100;
			  		      gbc.weighty = 100;
      		  add(NameField, gbc, 1, 1, 1, 1);



      		  gbc.fill = GridBagConstraints.NONE;
			  gbc.weightx = 100;
			  gbc.weighty = 100;
      		  add(FromAccountNumberField, gbc, 1, 2, 1, 1);

			  gbc.fill = GridBagConstraints.NONE;
			  gbc.weightx = 100;
			  gbc.weighty = 100;
      		  add(TypePanel1, gbc, 0,2, 1, 1);

      		  gbc.fill = GridBagConstraints.NONE;
			  gbc.weightx = 100;
			  gbc.weighty = 100;
      		  add(UsernameField, gbc, 1, 0, 1, 1);

      		  gbc.fill = GridBagConstraints.NONE;
			  gbc.weightx = 100;
			  gbc.weighty = 100;
      		  add(UsernameLabel, gbc, 0, 0, 1, 1);




      		  gbc.fill = GridBagConstraints.NONE;
			  gbc.weightx = 100;
			  gbc.weighty = 100;
			  add(AmountField, gbc, 1, 3, 1, 1);

			  gbc.fill = GridBagConstraints.NONE;
			  gbc.weightx = 100;
			  gbc.weighty = 100;
      		  add(AmountLabel, gbc, 0, 3, 1, 1);



      		gbc.fill = GridBagConstraints.NONE;
			gbc.weightx = 100;
			gbc.weighty = 100;
      		add(OpenButton, gbc, 1, 4, 1, 1);

    }

   public void actionPerformed(ActionEvent evt)  //event handling
   {
        String arg = evt.getActionCommand();
        String ChkAccNum, SavAccNum;
        if (arg.equals("View")) { //if view button is clicked
        UName = UsernameField.getText(); //take actions
        Name = NameField.getText();
        FromAccountNumber = FromAccountNumberField.getText();
        FromAccountType = (String)CheckingOrSavingsBox1.getSelectedItem();

			if (FromAccountType.equals("Checking")) {
						//System.out.println(AccountType);
						CheckingAccount chk = new CheckingAccount();
						ChkAccNum = chk.getCheckingAcctNumber(UName);
						CheckingAccount CA = new CheckingAccount(ChkAccNum, Name, UName, "0");
						FromAccountNumberField.setText(ChkAccNum);
						//System.out.println(AccountNumber);
						Bal=CA.getBalance();
						AmountField.setText(String.valueOf(Bal));
						System.out.println(Bal);
						if(Bal!=-1)
							JOptionPane.showMessageDialog(null, "Successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			            else
			            //System.out.println("fail!");
			            	JOptionPane.showMessageDialog(null, "Failed.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
					}
					else if (FromAccountType.equals("Savings")) {
						SavingsAccount sav = new SavingsAccount();
						SavAccNum = sav.getSavingsAcctNumber(UName);
						SavingsAccount SA = new SavingsAccount(SavAccNum, Name, UName, "0");
						FromAccountNumberField.setText(SavAccNum);
						
						AmountField.setText(String.valueOf(Bal));
						if(Bal!=-1)
			              JOptionPane.showMessageDialog(null, "Successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			            else
			            //System.out.println("fail!");
			            JOptionPane.showMessageDialog(null, "Failed", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		}

   		}
    }


 public void add(Component c, GridBagConstraints gbc,
	                     int x, int y, int w, int h)
	     {
	        gbc.gridx = x;
	        gbc.gridy = y;
	        gbc.gridwidth = w;
	        gbc.gridheight = h;
	        add(c, gbc);
   }

}