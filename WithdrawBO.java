import java.awt.*;     //including Java packages used by this program
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.Scanner;
import com.ntu.*;

class WithdrawBO extends JPanel implements ActionListener
{
	private JButton WithdrawButton;
	private JTextField UsernameField, NameField, AccountNumberField,ToAccountNumberField, AmountField;
    private JComboBox CheckingOrSavingsBox;
    private String UName, FromAccountNumber, ToAccountNumber, Amount, Name, FromAccountType, AccountType;
    private Account Acct;

    public WithdrawBO(String UName, String CustomerName)
    {
		WithdrawButton = new JButton("Withdrawal"); //initializing two button references
		CheckingOrSavingsBox = new JComboBox();
		CheckingOrSavingsBox.addItem("Choose Account Type");
		CheckingOrSavingsBox.addItem("Checking");
		CheckingOrSavingsBox.addItem("Savings");

		UsernameField = new JTextField(15);
        UsernameField.setText(UName);
        NameField = new JTextField(15);
        NameField.setText(CustomerName);


        AmountField = new JTextField(15);

        JLabel NameLabel = new JLabel("Customer Name:");
        JLabel UsernameLabel = new JLabel("Username: ");
        JLabel AccountTypeLabel = new JLabel("Account Type:");
        JLabel AmountLabel = new JLabel("Amount:");


        JPanel TypePanel1 = new JPanel();


        TypePanel1.add(CheckingOrSavingsBox);


        WithdrawButton.addActionListener(this);
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();

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
      		  add(TypePanel1, gbc, 1, 2, 1, 1);

			  gbc.fill = GridBagConstraints.NONE;
			  gbc.weightx = 100;
			  gbc.weighty = 100;
      		  add(AccountTypeLabel, gbc, 0,2, 1, 1);

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
      		add(WithdrawButton, gbc, 1, 4, 1, 1);

    }

   public void actionPerformed(ActionEvent evt)  //event handling
   {
        String arg = evt.getActionCommand();
        String ChkAccNO, SavAccNO;
    if (arg.equals("Withdrawal")) { //determine which button is clicked
	        	UName = UsernameField.getText(); //take actions
	        	Name = NameField.getText();
	        	Amount = AmountField.getText();
	        	FromAccountType = (String)CheckingOrSavingsBox.getSelectedItem();
	        	//client step2
	            try {
						Socket socket = new Socket("127.0.0.1",2021);
						System.out.println("withrawing client run");

						//output input objets
				       ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
					   ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
	                   System.out.println("withdraw FromAccountType->" +FromAccountType+"FromAccountNumber"+FromAccountNumber+" UName"+UName);

				       BankActionEvent ev = new BankActionEvent();
				       System.out.println("client Working for withdreawal");
				       System.out.println("UName"+UName+"Name"+Name+"FromAccountType"+FromAccountType+"Amount"+Amount);
				       ev.setActionname("Withdrawal");
				       ev.setUsername(UName);
		               ev.setName(Name);
		               ev.setFromAccountType(FromAccountType);
		               ev.setBalance(Float.parseFloat(Amount));

		               out.writeObject(ev);

		               InputStreamReader isw = new InputStreamReader(in, "US-ASCII");
					   BufferedReader inBuf = new BufferedReader(isw);
	                   out.flush();
	//CONDITION LEFT
	                  String UpdatedBalance=inBuf.readLine();
					                     System.out.println("updated bal is "+UpdatedBalance);
					                     if(Float.parseFloat(UpdatedBalance)== -1)
					                     {
					  					   JOptionPane.showMessageDialog(null, "Balance not deposited!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
					  					   }else{
					  						   JOptionPane.showMessageDialog(null, "Balance deposited!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
							   }

					    out.close();
					    in.close();
	                    socket.close();
				   	}
				   	catch (Exception e){
							System.out.println("Exception occurrred"+ e);
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