<!--
/******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet *
*	Date: September, 2012						      *
**************************************** ***************************************/
-->

<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="com.ntu.*;" %>

<%
	String Username = new String("");
	String FullName = new String("");
	String ChkAccNum = new String("");
	String SavAccNum = new String("");

	float SBal = 0;
	float CBal = 0;

	
	Username = request.getParameter( "UserID" );
	FullName = request.getParameter( "Name" );
	
	CheckingAccount chk = new CheckingAccount();
	ChkAccNum = chk.getCheckingAcctNumber(Username);
	
	CheckingAccount CA = new CheckingAccount(ChkAccNum);
	CBal = CA.getBalance();
	
	SavingsAccount sav = new SavingsAccount();
	SavAccNum = sav.getSavingsAcctNumber(Username);
	
	SavingsAccount SA = new SavingsAccount(SavAccNum);	
	SBal = SA.getBalance();
	
	System.out.println("UserID: "+Username + "and" + CBal +" and "+ SBal);
%>
<HTML>
 <HEAD>
 </HEAD>
	<BODY bgcolor='#b3c3ff'>
		<CENTER><h4>Your Checking Account Balance is $<%= CBal %></h4>
		<h4>Your Saving Account Balance is $<%= SBal %></h4></CENTER>
 	</BODY>
 </HTML>
