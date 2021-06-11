public class BankActionEvent implements java.io.Serializable {

    private String actionname;
    private String username;
    private String password;
    private float Balance;
    private String AccountNumber;
    private String Name;
    private String FromAccountType;
    private String CheckingAccountNumber;
    private String SavingsAccountNumber;
    private String ToAccountType;
	private String ToAccountNumber;
	private String FromAccountNumber;
	private float TransferAmt;
	private String StartDate;
	private String EndDate;
	private String AccountType;

    public String getActionname() {
        return actionname;
    }

    public void setActionname(String actionname) {
        this.actionname = actionname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

     public String getAccountNumber() {
	        return AccountNumber;
    }

    public void setAccountNumber(String AccountNumber) {
	        this.AccountNumber = AccountNumber;
    }

    public String getName() {
		        return Name;
    }
    public void setName(String Name) {
		        this.Name = Name;
    }

     public float getBalance() {
	        return Balance;
    }
    public void setBalance(float Balance) {
			        this.Balance = Balance;
    }

    public String getFromAccountType() {
	        return FromAccountType;
    }
    public void setFromAccountType(String FromAccountType) {
			        this.FromAccountType = FromAccountType;
    }
    public String getCheckingAccountNumber() {
        return CheckingAccountNumber;
    }
    public void setCheckingAccountNumber(String CheckingAccountNumber) {
	        this.CheckingAccountNumber = CheckingAccountNumber;
	    }

   public String getSavingsAccountNumber() {
        return SavingsAccountNumber;
    }
    public void setSavingsAccountNumber(String SavingsAccountNumber) {
		        this.SavingsAccountNumber = SavingsAccountNumber;
		    }

  public String getToAccountType() {
        return ToAccountType;
    }
    public void setToAccountType(String ToAccountType) {
		        this.ToAccountType = ToAccountType;
		    }


  public String getToAccountNumber() {
        return ToAccountNumber;
    }
    public void setToAccountNumber(String ToAccountNumber) {
		        this.ToAccountNumber = ToAccountNumber;
		    }

 public String getFromAccountNumber() {
        return FromAccountNumber;
    }
    public void setFromAccountNumber(String FromAccountNumber) {
		        this.FromAccountNumber = FromAccountNumber;
		    }

public float getTransferAmt() {
	        return TransferAmt;
    }
public void setTransferAmt(float TransferAmt) {
			        this.TransferAmt = TransferAmt;
    }

   public String getStartDate() {
           return StartDate;
       }

       public void setStartDate(String StartDate) {
           this.StartDate = StartDate;
    }

    public String getEndDate() {
	        return EndDate;
	    }

	    public void setEndDate(String EndDate) {
	        this.EndDate = EndDate;
    }

    public String getAccountType() {
		        return AccountType;
		    }

		    public void setAccountType(String AccountType) {
		        this.AccountType = AccountType;
    }

}