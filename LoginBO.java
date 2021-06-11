/******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: September, 2012													  *
*******************************************************************************/

import java.awt.*;     //including Java packages used by this program
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class LoginBO extends JFrame implements ActionListener // Implementing ActionListener is for event handling.
{
    private JButton SignUpButton, LoginButton;  //Instance variables
    private JTextField UsernameField;
    private JPasswordField PasswordField;


    public LoginBO()
    {
        setTitle("Login");
        setSize(300, 200);

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

         SignUpButton = new JButton("Sign Up"); //initializing two button references
         LoginButton = new JButton("Login");

         UsernameField = new JTextField(15);
         PasswordField = new JPasswordField(15);
         PasswordField.setActionCommand("Login");

         JLabel FirstTimeUserLabel = new JLabel("First time user? Click Sign Up to register!");
         JLabel UsernameLabel = new JLabel("Username: ");
         JLabel PasswordLabel = new JLabel("Password: ");

         JPanel UsernamePanel = new JPanel();
         JPanel PasswordPanel = new JPanel();

         UsernamePanel.add(UsernameLabel);
         UsernamePanel.add(UsernameField);
         PasswordPanel.add(PasswordLabel);
         PasswordPanel.add(PasswordField);

         JPanel LoginPanel = new JPanel();
         LoginPanel.add(UsernamePanel);
         LoginPanel.add(PasswordPanel);

         LoginPanel.add(LoginButton);  //add the two buttons on to this panel
         LoginPanel.add(FirstTimeUserLabel);
         LoginPanel.add(SignUpButton);

         SignUpButton.addActionListener(this);  //event listener registration
         LoginButton.addActionListener(this);
         PasswordField.addActionListener(this);

         Container contentPane = getContentPane(); //add a panel to a frame
         contentPane.add(LoginPanel);

	}

    public void actionPerformed(ActionEvent evt)  //event handling
    {
        String arg = evt.getActionCommand();

        if (arg.equals("Sign Up")) { //determine which button is clicked
            SignUpControl SUC = new SignUpControl(); //take actions
		}

		if (arg.equals("Login")) {
			String CustomerName = "";
			String Username = UsernameField.getText();
			String Password = PasswordField.getText();
            LoginControl LoginC = new LoginControl(Username, Password);
            try {
													Socket socket = new Socket("127.0.0.1",2021);
													System.out.println("login run");

													//output input objets
												    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
				                                    ObjectInputStream in = new ObjectInputStream(socket.getInputStream());


				                                    BankActionEvent ev = new BankActionEvent();
				                                    ev.setActionname("Login");
				                                    ev.setUsername(Username);
				                                    ev.setPassword(Password);
													out.writeObject(ev);

													InputStreamReader isw = new InputStreamReader(in, "US-ASCII");
			                						BufferedReader inBuf = new BufferedReader(isw);
			                						out.flush();
			                						CustomerName=inBuf.readLine();


			                						//close all connection
							 						out.close();
													in.close();
			                                        socket.close();
										} catch (Exception e){
										System.out.println("Exception occurrred"+ e);
						        }
			            System.out.println("CustomerName"+CustomerName);
			            if (!CustomerName.equals("")) {

						            System.out.println(">>> INSIDE CUST");

			            MainBO signin = new MainBO(Username, CustomerName);

					}
					else{
			            JOptionPane.showMessageDialog(null, "Login failed because of invalid username or password.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			    }
		}
    }

    public static void main(String [] args)
    { JFrame frame = new LoginBO(); //initialize a JFrame object
      frame.show(); //display the frame
    }
}

