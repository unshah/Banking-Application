import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class MainBO extends JFrame
{
   private JTabbedPane tabbedPane;
   private JPanel tabPanel_1, tabPanel_2,tabPanel_3,tabPanel_4,tabPanel_5, tabPanel_6, tabPanel_7;
   public MainBO(String UName, String CustomerName)
   {

      setTitle("Account Overview");
      setSize(900, 550);
      //get screen size and set the location of the frame
      Toolkit tk = Toolkit.getDefaultToolkit();
      Dimension d = tk.getScreenSize();
      int screenHeight = d.height;
      int screenWidth = d.width;
      setLocation( screenWidth / 3 - 180, screenHeight / 6);

      addWindowListener (new WindowAdapter()  //handle window closing event
         {  public void windowClosing (WindowEvent e)
            { System.exit(0);
            }
         });

         tabbedPane = new JTabbedPane(); //initialize a JTabbedPane object
		 tabPanel_2 = new OpenBankAccountPanel(UName,CustomerName);
		 tabPanel_3 = new ViewBalanceBO(UName,CustomerName);
		 tabPanel_4 = new WithdrawBO(UName,CustomerName);
		 tabPanel_5 = new DepositBO(UName,CustomerName);
		 tabPanel_6 = new TransferBalBO(UName,CustomerName);
		 tabPanel_7 = new InquireTransBO(UName,CustomerName);
		 tabbedPane.addTab("Open Account", tabPanel_2);
		 tabbedPane.setSelectedIndex(0);
		 tabbedPane.addTab("Account Overview", tabPanel_3); //add GUI components to Tabbed Pane
		 tabbedPane.addTab("Withdraw", tabPanel_4);
		 tabbedPane.addTab("Deposit", tabPanel_5);
		 tabbedPane.addTab("Transfer", tabPanel_6);
		 tabbedPane.addTab("Inquire", tabPanel_7);
		 add(tabbedPane);
		show();



	}
}