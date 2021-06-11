import java.awt.*;     //including Java packages used by this program
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.*;
import com.ntu.*;

class InquireTransBO extends JPanel implements ActionListener
{
    private JButton InquireButton;
    private JTextField UsernameField, NameField, AccountNumberField, StartDateField, EndDateField;
    private JComboBox CheckingOrSavingsBox;
    private String UName, AccountNumber, StartDate, EndDate, Name, AccountType;
    private Account Acct;

    public InquireTransBO(String UName, String CustomerName)
    {

        InquireButton = new JButton("Inquire"); //initializing two button references

        CheckingOrSavingsBox = new JComboBox();
        CheckingOrSavingsBox.addItem("Choose Account Type");
		CheckingOrSavingsBox.addItem("Checking");
		CheckingOrSavingsBox.addItem("Savings");

        UsernameField = new JTextField(15);
        UsernameField.setText(UName);
        NameField = new JTextField(15);
        NameField.setText(CustomerName);
        StartDateField = new JTextField(15);
        EndDateField = new JTextField(15);

        JLabel TypeLabel = new JLabel("Choose Account Type: ");
        JLabel NameLabel = new JLabel("Customer Name:");
        JLabel UsernameLabel = new JLabel("Username: ");
        JLabel StartDateLabel = new JLabel("Start Date (yyyy-mm-dd):");
        JLabel EndDateLabel = new JLabel("End Date (yyyy-mm-dd):");

        JPanel TypePanel = new JPanel();

        TypePanel.add(CheckingOrSavingsBox);

        InquireButton.addActionListener(this); //event listener registration

        GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl); //let the layout manager be GridBagLayout
			  GridBagConstraints gbc = new GridBagConstraints();
		     //apply GridBagConstraints to a GUI component and add it to this panel
		      gbc.fill = GridBagConstraints.NONE;
		      gbc.weightx = 100;
		      gbc.weighty = 100;
      		  add(NameLabel, gbc, 0, 2, 1, 1);

      		  gbc.fill = GridBagConstraints.NONE;
			  		      gbc.weightx = 100;
			  		      gbc.weighty = 100;
      		  add(NameField, gbc, 1, 2, 1, 1);

      		  gbc.fill = GridBagConstraints.NONE;
			  gbc.weightx = 100;
			  gbc.weighty = 100;
      		  add(TypeLabel, gbc, 0, 0, 1, 1);


			  //apply GridBagConstraints to a GUI component and add it to this panel
			  gbc.fill = GridBagConstraints.NONE;
			  gbc.weightx = 100;
			  gbc.weighty = 100;
      		  add(TypePanel, gbc, 1,0, 1, 1);

      		  gbc.fill = GridBagConstraints.NONE;
			  gbc.weightx = 100;
			  gbc.weighty = 100;
      		  add(UsernameField, gbc, 1, 1, 1, 1);

      		  gbc.fill = GridBagConstraints.NONE;
			  gbc.weightx = 100;
			  gbc.weighty = 100;
      		  add(UsernameLabel, gbc, 0, 1, 1, 1);

      		  gbc.fill = GridBagConstraints.NONE;
			  gbc.weightx = 100;
			  gbc.weighty = 100;
			  add(StartDateField, gbc, 1, 4, 1, 1);

			  gbc.fill = GridBagConstraints.NONE;
			  gbc.weightx = 100;
			  gbc.weighty = 100;
      		  add(StartDateLabel, gbc, 0, 4, 1, 1);

      		  gbc.fill = GridBagConstraints.NONE;
			  gbc.weightx = 100;
			  gbc.weighty = 100;
			  add(EndDateField, gbc, 1, 5, 1, 1);

			 gbc.fill = GridBagConstraints.NONE;
			 gbc.weightx = 100;
			 gbc.weighty = 100;
      		  add(EndDateLabel, gbc, 0, 5, 1, 1);

      		gbc.fill = GridBagConstraints.NONE;
			gbc.weightx = 100;
			gbc.weighty = 100;
      		add(InquireButton, gbc, 1, 6, 1, 1);

    }

   public void actionPerformed(ActionEvent evt)  //event handling
   {
       //Object source = evt.getSource(); //get who generates this event
		String arg = evt.getActionCommand();
        String ChkAccNO, SavAccNO;

        if (arg.equals("Inquire")) { //determine which button is clicked
        	UName = UsernameField.getText(); //take actions
        	Name = NameField.getText();
        	String stDate = StartDateField.getText();
        	String endDate = EndDateField.getText();

        	AccountType = (String)CheckingOrSavingsBox.getSelectedItem();

		            try {
							Socket socket = new Socket("127.0.0.1",2021);
							System.out.println("inquire from  client");

							//output input objets
					       ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
						   ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
		                   System.out.println("Inquire show UName"+UName);

					       BankActionEvent ev = new BankActionEvent();
					       System.out.println("client Working for inquire");
					       System.out.println("UName"+UName+"Name"+Name+"StartDate"+stDate+"EndDate"+endDate);
					       ev.setActionname("Inquire");
					       ev.setUsername(UName);
			               ev.setName(Name);
			               ev.setAccountType(AccountType);
			               ev.setStartDate(stDate);
			               ev.setEndDate(endDate);

			               out.writeObject(ev);

			               InputStreamReader isw = new InputStreamReader(in, "US-ASCII");
						   BufferedReader inBuf = new BufferedReader(isw);

						   System.out.println(inBuf.readLine());
		                   out.flush();

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