<!--
/******************************************************************************
*	Program Author: Ujjwal Shah for CSCI 3480 Java and the Internet	  *
*	Date: May, 2021												  *
*******************************************************************************/
-->
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="com.ntu.*;" %>

<%
	String AccountType = new String("");		
	String Balance = new String("");
	String ChkAccNum = new String("");
	String SavAccNum = new String("");
        String Username = new String("");
        String Name = new String("");
	float Bal = -1;
	
	AccountType = request.getParameter("CheckingOrSavings");	
	Balance = request.getParameter("AmountField");	
	Username = request.getParameter( "UserID" );
	Name = request.getParameter( "Name" );
	String status = "failed";
	
	if (AccountType.equals("Checking")) {
	
				CheckingAccount chk = new CheckingAccount();
				ChkAccNum = chk.getCheckingAcctNumber(Username);
				
				CheckingAccount CA = new CheckingAccount(ChkAccNum, Name, Username, Balance);
				Bal=Float.parseFloat(Balance);
				Bal=CA.addDeposit(ChkAccNum,Bal);
	            if (Bal!=-1) {
	        
	             Transactions TC= new Transactions("Deposit",ChkAccNum,"0",Username,Balance);
	            	if (TC.saveTransaction()) {
						status = "Successful";
					}
					}
			} else if (AccountType.equals("Savings")) {
			
				SavingsAccount sav = new SavingsAccount();
				SavAccNum = sav.getSavingsAcctNumber(Username);
				
				SavingsAccount SA = new SavingsAccount(SavAccNum, Name, Username, Balance);
			        Bal=Float.parseFloat(Balance);
				Bal=SA.addDeposit(SavAccNum,Bal);
				if (Bal!=-1) {
				     Transactions TC= new Transactions("Deposit",SavAccNum,"0",Username,Balance);
				     if (TC.saveTransaction()) {
				     status = "Successful";
				 }
				}
		}
%>

<HTML>
<HEAD></HEAD>
	<BODY bgcolor='#b3c3ff'>
		<h4>Money Deposit <%= status %>!</h4>
        </BODY>
</HTML>
