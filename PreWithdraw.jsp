<!--
/******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: September, 2012													  *
*******************************************************************************/
-->

<HTML><HEAD></HEAD>
<BODY>
    <FORM NAME="WithdrawForm" ACTION="/CSCI6810/Withdraw.jsp" METHOD ="POST">
        <INPUT TYPE='hidden' NAME='UserID' VALUE='<%=request.getParameter("UserID")%>'>
        <INPUT TYPE='hidden' NAME='Name' VALUE='<%=request.getParameter("Name")%>'>

        <TABLE cellPadding=3 ALIGN='center'>

            <TR bgcolor='#ECFAEB'>
                <TD>Withdraw From:</TD>
                <TD>
                    <select size="1" name="CheckingOrSavings">
		    	<option selected value="Checking">Checking</option>
		    	<option value="Savings">Savings</option>    
  	            </select>
                </TD>
            </TR>

            <TR bgcolor='#F1F1FD'>
                <TD>Amount to Withdraw:</TD>
                <TD>
                   <INPUT TYPE='text' NAME='AmountField' Value='' SIZE='15'>
                </TD>
            </TR>
          </TABLE><BR>
<CENTER><INPUT TYPE="SUBMIT" NAME='submitBNTN' VALUE='Make Withdrawal'></CENTER><BR>
</FORM>

</BODY>
</HTML>
<SCRIPT LANGUAGE="JavaScript">
	       function checkInputs()
	       {

	          var Prompts = "";
	           Balance = window.document.WithdrawPage.AmountField.value;
	           AccountNumber = window.document.WithdrawPage.AccountNumField.value;
                   
                     if (Balance == "" || AccountNumber == "") {
	              if (Balance == "")
	                 Prompts +="Please enter amount!\n";
	              if (AccountNumber == "")
	                 Prompts +="Please enter aaccount number!\n";
	              if (Prompts != "")
	                 window.alert(Prompts);
	           } else {
	              document.WithdrawPage.submit();
	           }
	       }

</SCRIPT>