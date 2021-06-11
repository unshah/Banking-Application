import java.awt.*;     //including Java packages used by this program
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.Scanner;
import com.ntu.*;

class TransferBalBO extends JPanel implements ActionListener
{
    private JButton TransButton;
    private JTextField UsernameField, NameField, FromAccountNumberField,ToAccountNumberField, AmountField;
    private JComboBox CheckingOrSavingsBox1,CheckingOrSavingsBox2;
    private String UName, FromAccountNumber, ToAccountNumber, Amount, Name, FromAccountType, ToAccountType;
    private Account Acct;

    public TransferBalBO(String UName, String CustomerName)
    {
        TransButton = new JButton("Transfer"); //initializing two button references

        CheckingOrSavingsBox1 = new JComboBox();
        CheckingOrSavingsBox1.addItem("Choose From Account Type");
		CheckingOrSavingsBox1.addItem("Checking");
		CheckingOrSavingsBox1.addItem("Savings");

		CheckingOrSavingsBox2 = new JComboBox();
        CheckingOrSavingsBox2.addItem("Choose TO Account Type");
		CheckingOrSavingsBox2.addItem("Checking");
		CheckingOrSavingsBox2.addItem("Savings");

        UsernameField = new JTextField(15);
        UsernameField.setText(UName);
        NameField = new JTextField(15);
        NameField.setText(CustomerName);
        FromAccountNumberField = new JTextField(15);
        ToAccountNumberField = new JTextField(15);
        AmountField = new JTextField(15);


        JLabel NameLabel = new JLabel("Customer Name:");
        JLabel UsernameLabel = new JLabel("Username: ");
        JLabel AccountFromNumber = new JLabel ("From Account: ");
        JLabel AccountToNumber = new JLabel ("To Account: ");
        JLabel AmountLabel = new JLabel("Amount:");


        JPanel TypePanel1 = new JPanel();
        JPanel TypePanel2 = new JPanel();

        TypePanel1.add(CheckingOrSavingsBox1);
        TypePanel2.add(CheckingOrSavingsBox2);

        TransButton.addActionListener(this); //event listener registration
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
      		  add(AccountToNumber, gbc, 0, 3, 1, 1);

      		  gbc.fill = GridBagConstraints.NONE;
			  gbc.weightx = 100;
			  gbc.weighty = 100;
      		  add(TypePanel1, gbc, 1, 2, 1, 1);

			  gbc.fill = GridBagConstraints.NONE;
			  gbc.weightx = 100;
			  gbc.weighty = 100;
      		  add(TypePanel2, gbc, 1, 3, 1, 1);

			  //apply GridBagConstraints to a GUI component and add it to this panel
			  gbc.fill = GridBagConstraints.NONE;
			  gbc.weightx = 100;
			  gbc.weighty = 100;
      		  add(AccountFromNumber, gbc, 0,2, 1, 1);

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
			  add(AmountField, gbc, 1, 4, 1, 1);

			  gbc.fill = GridBagConstraints.NONE;
			  gbc.weightx = 100;
			  gbc.weighty = 100;
      		  add(AmountLabel, gbc, 0, 4, 1, 1);



      		gbc.fill = GridBagConstraints.NONE;
			gbc.weightx = 100;
			gbc.weighty = 100;
      		add(TransButton, gbc, 1, 5, 1, 1);

    }

   public void actionPerformed(ActionEvent evt)  //event handling
   {
        String arg = evt.getActionCommand();
        String chkAccNo,savAccNo;
        if (arg.equals("Transfer")) { //determine which button is clicked
		        	UName = UsernameField.getText(); //take actions
		        	Name = NameField.getText();
		        	FromAccountNumber = FromAccountNumberField.getText();
		        	ToAccountNumber = ToAccountNumberField.getText();
		        	Amount = AmountField.getText();
		        	FromAccountType = (String)CheckingOrSavingsBox1.getSelectedItem();
		        	ToAccountType = (String)CheckingOrSavingsBox2.getSelectedItem();

		//me client
		        	try {
							Socket socket = new Socket("127.0.0.1",2021);
							System.out.println("transfer run");

							//output input objets
					       ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
						   ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
		                   System.out.println("transfer FromAccountNumber->" +FromAccountNumber+" UName"+UName+"ToAccountType"+ToAccountType);
					       BankActionEvent ev = new BankActionEvent();
					       System.out.println("UName"+UName+"Name"+Name+"FromAccountType"+FromAccountType+"ToAccountType"+ToAccountType+"Amount"+Amount);
					       ev.setActionname("Transfer");
					       ev.setUsername(UName);
			               ev.setName(Name);
			               ev.setFromAccountType(FromAccountType);
		                   ev.setToAccountType(ToAccountType);
			               //ev.setBalance(Float.parseFloat(Amount));
		   	               ev.setTransferAmt(Float.parseFloat(Amount));

			               out.writeObject(ev);

			               InputStreamReader isw = new InputStreamReader(in, "US-ASCII");
						   BufferedReader inBuf = new BufferedReader(isw);
		                   out.flush();

		                   String TransferStatus = inBuf.readLine();
		                   System.out.println(" Transfer Status recevied from in Server "+TransferStatus);

		                   if(TransferStatus.equals("Sucessful")){
							   JOptionPane.showMessageDialog(null, "Balance transfer Sucessful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
						   }
						   else if(TransferStatus.equals("Not sufficent balance")){
							   	JOptionPane.showMessageDialog(null, "Not sufficent Balance to transfer!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
						   }
						   else{
						 		JOptionPane.showMessageDialog(null, "Balance transfer not Sucessful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);

						   }

		                    out.close();
						    in.close();
		                    socket.close();
					   }catch (Exception e){
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