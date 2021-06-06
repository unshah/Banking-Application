<!--
/******************************************************************************
*	Program Author: Ujjwal N Shah CSCI 4380 Java and the Internet	  *
*	Date: May 12, 2021													  *
*******************************************************************************/
-->

<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="com.ntu.*;" %>


<%
	String Username = new String("request.getParameter("UserID")");
	String TransID = new String("request.getParameter("TransactionID")");
	String TransAmt = new String("request.getParameter("TransAmt")");
	String TransTime = new String("request.getParameter("TransTime")");
	String TransDate = new String("request.getParameter("TransDate")");
	String FromAccount = new String("request.getParameter("FromAccount")");
	String ToAccount = new String("request.getParameter("FromToAccount")");
	
	Username = request.getParameter( "UserID" );
	
	Transactions TC= new Transactions("Transfer",FromAccount,ToAccount,Username,TransAmt);
	TC.saveTransaction();
					

%>