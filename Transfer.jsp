<!--
/******************************************************************************
*	Program Author: Ujjwal Shah for CSCI 6810 Java and the Internet	  *
*	Date: September, 2012													  *
*******************************************************************************/
-->
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="com.ntu.*;" %>

<%
	String ToAccountType = new String("");
	String FromAccountType = new String("");
	String Balance = new String("");
	String ChkAccNum = new String("");
	String SavAccNum = new String("");
        String Username = new String("");
        String Name = new String("");
	
	float Bal = -1;
	
	FromAccountType = request.getParameter("FromCheckingOrSavings");
	ToAccountType = request.getParameter("ToCheckingOrSavings");
	Balance = request.getParameter("AmountField");	
	Username = request.getParameter( "UserID" );
	Name = request.getParameter( "Name" );
	String status = "failed";
	
	CheckingAccount CA = new CheckingAccount(Name, Username, Balance);
        SavingsAccount SA = new SavingsAccount(Name, Username, Balance);
        
        String ChkAccountNum = CA.getCheckingAcctNumber(Username);
       	String SavAccountNum = SA.getSavingsAcctNumber(Username);
	
	Bal = Float.parseFloat(Balance);		

		if (FromAccountType.equals("Checking")) {
			if(ToAccountType.equals("Savings")){
			
				System.out.println(ChkAccountNum);
                       		System.out.println(SavAccountNum);
				
				CA.remWithdraw(ChkAccountNum,Bal);
		       		SA.addDeposit(SavAccountNum,Bal);
				
	        		if (Bal!=-1) {
	        			Transactions TC= new Transactions("Transfer",SavAccountNum,ChkAccountNum,Username,Balance);
	            			if (TC.saveTransaction()){
					status = "Successful";
				}
			}
			
		}} 
		else if (FromAccountType.equals("Savings")) {
			if(ToAccountType.equals("Checking")){
				
				System.out.println(ChkAccountNum);
				System.out.println(SavAccountNum);	
				
				SA.remWithdraw(SavAccountNum,Bal);
				CA.addDeposit(ChkAccountNum,Bal);
				
			if (Bal!=-1) {
				Transactions TC= new Transactions("Transfer",ChkAccountNum,SavAccountNum,Username,Balance); 
				if (TC.saveTransaction()){
				     status = "Successful";
				}
			}
		}}
	
%>

<HTML>
<HEAD></HEAD>
	<BODY bgcolor='#b3c3ff'>
		<h4>Money Transfer <%= status %>!</h4>
        </BODY>
</HTML>