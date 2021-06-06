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
	String Username = new String("");
	String TransID = new String("");
	String TransAmt = new String("");
	String TransTime = new String("");
	String TransDate = new String("");
	String FromAccount = new String("");
	String ToAccount = new String("");
	
%>
<HTML><HEAD></HEAD>
<BODY>
    <FORM NAME="TransferForm" ACTION="/CSCI6810/UpdateTrans.jsp" METHOD ="POST">

        <TABLE cellPadding=3 ALIGN='center'>
            <TR bgcolor='#ECFAEB'>
                <TD>Username:</TD>
                <TD>
        		<INPUT TYPE='Text' NAME='UserID' VALUE='<%=request.getParameter("UserID")%>' Readonly>
                </TD>
            </TR>
            <TR bgcolor='#ECFAEB'>
                <TD>Transaction ID:</TD>
                <TD>
                    <INPUT TYPE='Text' NAME='TransID' Value='<%=request.getParameter("TransactionID")%>' SIZE='15' Readonly>
                </TD>
            </TR>
            <TR bgcolor='#ECFAEB'>
                <TD>Amount:</TD>
                <TD>
                    <INPUT TYPE='Text' NAME='TransAmt' Value=TransAmt SIZE='15'>
                </TD>
            </TR>
            <TR bgcolor='#ECFAEB'>
                <TD>Time:</TD>
                <TD>
                    <INPUT TYPE='Text' NAME='TransTime' Value=TransTime SIZE='15'>
                </TD>
            </TR>            
            <TR bgcolor='#ECFAEB'>
                <TD>Date:</TD>
                <TD>
                    <INPUT TYPE='Text' NAME='TransDate' Value=TransDate SIZE='15'>
                </TD>
            </TR>
            <TR bgcolor='#ECFAEB'>
                <TD>From Account:</TD>
                <TD>
                    <INPUT TYPE='Text' NAME='FromAccount' Value=FromAccount SIZE='15'>
                </TD>
            </TR>
            <TR bgcolor='#F1F1FD'>
                <TD>To Account:</TD>
                <TD>
                   <INPUT TYPE='text' NAME='ToAccount' Value=ToAccount SIZE='15'>
                </TD>
            </TR>
          </TABLE><BR>
<CENTER><INPUT TYPE="SUBMIT" NAME='submitBNTN' VALUE='Update'></CENTER><BR>
</FORM>
</BODY>
</HTML>
<SCRIPT LANGUAGE='JavaScript'>
</SCRIPT>