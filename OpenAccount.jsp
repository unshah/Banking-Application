<!--
/******************************************************************************
*	Program Author: Ujjwal for CSCI 4380 Java and the Internet *
*	Date: September, 2020						      *
*******************************************************************************/
-->

<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="com.ntu.*;" %>

<%
	String AccountType = new String("");
	String AccountNumber = new String("");
	String Balance = new String("");
	String UserID = new String("");
	String Name = new String("");

	AccountType = request.getParameter( "CheckingOrSavings" );
	AccountNumber = request.getParameter( "AccountNumber" );
	Balance = request.getParameter( "deposit" );
	UserID = request.getParameter( "UserID" );
	Name = request.getParameter( "Name" );
	String status = "failed";

    if (AccountType.equals("Checking")) {
			CheckingAccount CA = new CheckingAccount(AccountNumber, Name, UserID, Balance);
            if (CA.openAcct()) {
            	Transactions Tran = new Transactions("Deposit", "", AccountNumber, UserID, Balance);
            	if (Tran.saveTransaction()) {
					status = "Successful";
				}
				}
		} else if (AccountType.equals("Savings")) {
			SavingsAccount SA = new SavingsAccount(AccountNumber, Name, UserID, Balance);
			if (SA.openAcct()) {
			     Transactions Tran = new Transactions("Deposit","", AccountNumber, UserID, Balance);
			     if (Tran.saveTransaction()) {
			     status = "Successful";
			 }
			}
		}%>
        <HTML><HEAD></HEAD>
		<BODY bgcolor='#b3c3ff'>
		<h4>Opening a <%= AccountType %> Account is <%= status %>!</h4>
        </BODY>
        </HTML>