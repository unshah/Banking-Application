import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.ntu.*;

public class BankServer {
    //to store active clients
    static Vector<ClientHandler> ar = new Vector<>();

    //to count clients
    static int i = 0;

    public static void main(String[] args) throws Exception {
        //socket to listen with port
        ServerSocket listener = new ServerSocket(2021);

        //for infinte loop of request
        while (true) {
            try {

                //accept incoming request
                Socket s = listener.accept();
                System.out.println("bank server is running..." + s);

                System.out.println("creating new havdler class");


                // Create a new handler object for handling this request.
                ClientHandler mtch = new ClientHandler(s);

                // Create a new Thread with this object.
                Thread t = new Thread(mtch);
                System.out.println("Adding this client to active client list");

                // add this client to active clients list
                ar.add(mtch);

                // start the thread.
                t.start();
                //increment the client
                i++;
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(-1);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
    }
}



//creating client handler class
class ClientHandler implements Runnable
{
    //private String name;
    ObjectInputStream in;
    ObjectOutputStream out1;
    Socket s;


    //contrsuctor
    public ClientHandler( Socket s)
    {
        try {
            this.s=s;
            this.in = new ObjectInputStream(s.getInputStream());
            this.out1= new ObjectOutputStream(s.getOutputStream());
            }
        catch (Exception e) {
            System.err.println(e);
           }
    }

    //override method
     @Override
     public void run()
     {
        try
        {
            //two line reomveif needed

            OutputStreamWriter osw = new OutputStreamWriter(out1, "US-ASCII");
            PrintWriter out = new PrintWriter(osw);


            BankActionEvent ev = (BankActionEvent) in.readObject();

            //for login condition new thread
            if(ev != null)
            {
                if (ev.getActionname().equals("Login"))
                {
                    System.out.println("--->" + ev.getActionname());
                    System.out.println("Useranme" + ev.getUsername() + "--- Password" + ev.getPassword());

                    LoginThread Lt = new LoginThread(s, out, ev);
                    Lt.start();
                }else if (ev.getActionname().equals("Deposite"))
                {
					System.out.println("--->" + ev.getActionname());
					System.out.println("Useranme" + ev.getUsername() + "--- account type" + ev.getFromAccountType());
					//Needs to go into  deposite thread
					DepositeThread Dt = new DepositeThread(s, out, ev);
					Dt.start();
			    }else if (ev.getActionname().equals("Transfer"))
			     {
					System.out.println("--->" + ev.getActionname());
					System.out.println("from:"+ev.getFromAccountType()+"to:"+ev.getToAccountType());
					TransferThread Tt = new TransferThread(s, out, ev);
					Tt.start();
				 }else if (ev.getActionname().equals("Withdrawal"))
			     {
					System.out.println("--->" + ev.getActionname());
					System.out.println("from:"+ev.getFromAccountType()+"to:"+ev.getToAccountType());
					WithdrawalThread Wt = new WithdrawalThread(s, out, ev);
					Wt.start();
				 }else if (ev.getActionname().equals("Inquire"))
			     {
					System.out.println("--->" + ev.getActionname());
					System.out.println("Useranme" + ev.getUsername() + "--- account type" + ev.getFromAccountType());
					InquireThread It = new InquireThread(s, out, ev);
					It.start();
				 }
				 else{ System.out.println("eeror");}
            }
          }catch (Exception e) {
            System.err.println(e);
            return;
        }

     }
}

//creation login thread ang logic
class LoginThread extends Thread
{
    Socket s;
    PrintWriter out;
    BankActionEvent ev;
    //private Account Acct;
    public LoginThread(Socket S, PrintWriter sout, BankActionEvent ev)
    {
        try
        {
            this.s=S;
            this.out= sout;
            this.ev = ev;
            System.out.println("In Login Thread");
        }catch (Exception e) {
            System.err.println(e);
        }
    }
    public void run()
    {
        try {
            System.out.println("In Login Thread1");

                    System.out.println("--->" + ev.getActionname());
                    System.out.println("Useranme" + ev.getUsername() + "--- Password" + ev.getPassword());

                    LoginControl LoginC = new LoginControl(ev.getUsername(), ev.getPassword());
                    String CustomerName = LoginC.signIn();
                    System.out.println("validated?" + CustomerName);
                    out.println(CustomerName);
                    out.flush();


            out.close();

            s.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

}

class DepositeThread extends Thread
{
	Socket s;
	PrintWriter out;
    BankActionEvent ev;

    public DepositeThread(Socket S, PrintWriter sout, BankActionEvent ev)
	    {
	        try
	        {
	            this.s=S;
	            this.out= sout;
	            this.ev = ev;
	            System.out.println("In deposite Thread");
	        }catch (Exception e) {
	            System.err.println(e);
	        }
        }
	public void run()
	    {
	        try {
	            System.out.println("In deposite Thread run");


	                    System.out.println("--->" + ev.getActionname());
	                    System.out.println("Useranme" + ev.getUsername() + "--- account type" + ev.getFromAccountType());

                        if(ev.getFromAccountType().equals("Checking")){

							System.out.println("server side balance "+ev.getBalance());
							DepositControl DB_Ctrl = new DepositControl(ev.getFromAccountType(),
										ev.getCheckingAccountNumber(), ev.getName(), ev.getUsername(), 	ev.getBalance());
							  float Bal = DB_Ctrl.DepositToAccount();
							  out.println(Bal);
                              out.flush();
							}else if(ev.getFromAccountType().equals("Savings")){

							System.out.println("server saving side balance "+ev.getBalance());
							DepositControl DB_Ctrl = new DepositControl(ev.getFromAccountType(),
										ev.getCheckingAccountNumber(), ev.getName(), ev.getUsername(), 	ev.getBalance());
							float Bal = DB_Ctrl.DepositToAccount();
							out.println(Bal);
                            out.flush();
    	 	                   }
	            out.close();

	            s.close();

	        } catch (IOException e) {
	            e.printStackTrace();
	            System.exit(-1);
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.exit(-1);
	        }
    }
}

class TransferThread extends Thread
{
	Socket s;
	PrintWriter out;
    BankActionEvent ev;

    public TransferThread(Socket S, PrintWriter sout, BankActionEvent ev)
		    {
		        try
		        {
		            this.s=S;
		            this.out= sout;
		            this.ev = ev;
		            System.out.println("In Transfer Thread");
		        }catch (Exception e) {
		            System.err.println(e);
		        }
        }
   public void run()
   	    {
   	        try {
   	            System.out.println("In Transfer Thread run");


   	             System.out.println("--->" + ev.getActionname());
   	             System.out.println("Useranme" + ev.getUsername() + "--- account type" + ev.getFromAccountType());

                 System.out.println("tranamt"+ev.getTransferAmt());

                 TransferBalanceControl tbc = new TransferBalanceControl(ev.getToAccountType(), ev.getCheckingAccountNumber(), ev.getFromAccountType(),
   				           ev.getSavingsAccountNumber(), ev.getName(), ev.getUsername(),ev.getTransferAmt(), ev.getBalance());

   				 String TransferStatus = tbc.TransferToAccount();

   				 System.out.println(">>>> Transfer Status in  Controller "+TransferStatus);

   				 out.println(TransferStatus);
                 out.flush();

   	            out.close();

   	            s.close();

   	        } catch (IOException e) {
   	            e.printStackTrace();
   	            System.exit(-1);
   	        } catch (Exception e) {
   	            e.printStackTrace();
   	            System.exit(-1);
   	        }
    }
}

class WithdrawalThread extends Thread
{
	    Socket s;
		PrintWriter out;
	    BankActionEvent ev;

	    public WithdrawalThread(Socket S, PrintWriter sout, BankActionEvent ev)
			    {
			        try
			        {
			            this.s=S;
			            this.out= sout;
			            this.ev = ev;
			            System.out.println("In Withdrawal Thread");
			        }catch (Exception e) {
			            System.err.println(e);
			        }
              }

public void run()
   	    {
   	        try {
   	            System.out.println("In Withdrawal Thread run");

   	             System.out.println("--->" + ev.getActionname());
   	             System.out.println("Useranme" + ev.getUsername() + "--- account type" + ev.getFromAccountType());

                 //call controller
                 WithdrawControl WB_Ctrl = new WithdrawControl(ev.getFromAccountType(), ev.getCheckingAccountNumber(),
                 ev.getName(), ev.getUsername(), ev.getBalance());
                 //call controller method
                 float Bal = WB_Ctrl.WithrawAmt();

   				out.println(Bal);
                 out.flush();

   	            out.close();
   	            s.close();
   	        } catch (IOException e) {
   	            e.printStackTrace();
   	            System.exit(-1);
   	        } catch (Exception e) {
   	            e.printStackTrace();
   	            System.exit(-1);
   	        }
    }
}

class InquireThread extends Thread
{
        Socket s;
		PrintWriter out;
	    BankActionEvent ev;

	    public InquireThread(Socket S, PrintWriter sout, BankActionEvent ev)
					    {
					        try
					        {
					            this.s=S;
					            this.out= sout;
					            this.ev = ev;
					            System.out.println("In Inquire Thread");
					        }catch (Exception e) {
					            System.err.println(e);
					        }
                       }

      public void run()
   	    {
   	        try {
   	            System.out.println("In Inquire Thread run");

   	             System.out.println("--->" + ev.getActionname());
   	             System.out.println("Useranme" + ev.getUsername() + "--- account type" + ev.getFromAccountType());
                 System.out.println("account tuype...."+ev.getAccountType());
                 //call controller
                 InquireTransControl INC_Ctrl = new InquireTransControl(ev.getAccountType(), ev.getCheckingAccountNumber(), ev.getName(), ev.getUsername(), ev.getStartDate(), ev.getEndDate());
                 System.out.println("st"+ev.getStartDate()+"et"+ev.getEndDate());
                 Vector ve = INC_Ctrl.InquireMethod();
				 out.println(ve);
				 out.flush();


                 out.flush();

   	            out.close();
   	            s.close();
   	        } catch (IOException e) {
   	            e.printStackTrace();
   	            System.exit(-1);
   	        } catch (Exception e) {
   	            e.printStackTrace();
   	            System.exit(-1);
   	        }
      }

}