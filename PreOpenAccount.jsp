<HTML><HEAD></HEAD>
<BODY>
<FORM NAME="OpenAccountForm" ACTION="/CSCI6810/OpenAccount.jsp" METHOD ="POST">
    <INPUT TYPE='hidden' NAME='UserID' VALUE='<%=request.getParameter("UserID")%>'>
    <INPUT TYPE='hidden' NAME='Name' VALUE='<%=request.getParameter("Name")%>'>
    <TABLE cellPadding=3 ALIGN='center'>

        <TR bgcolor='#ccd7ff'>
            <TD>Select Account Type:</TD>
            <TD>
                <select size="1" name="CheckingOrSavings">
                    <option selected value="Checking">Checking</option>
                    <option value="Savings">Savings</option>
                </select>
            </TD>
        </TR>
        <tr bgcolor='#ccd7ff'><td>Account Number:</td><td><INPUT TYPE="TEXT" NAME="AccountNumber" SIZE=20></td></tr>
        <tr bgcolor='#ccd7ff'><td>Opening Deposit:</td><td><INPUT TYPE="TEXT" NAME="deposit" PLACEHOLDER=0.0 SIZE=20></td></tr>
    </TABLE><BR>
    <CENTER><INPUT TYPE="BUTTON" NAME='submitBNTN' VALUE='Open Account' onClick="checkInputs()"></CENTER><BR>
</FORM>

</BODY>
</HTML>
<SCRIPT LANGUAGE='JavaScript'>
document.OpenAccountForm.AccountNumber.focus();
function checkInputs()
		{
		var Prompts = "";
		AccountNumber = window.document.OpenAccountForm.AccountNumber.value;
		if (AccountNumber == "")
		Prompts +="Please enter an Account Number with exactly 8 Characters!\n";
		if (AccountNumber != "" && AccountNumber.length !=8 )
		Prompts +="Please enter an Account Number with exactly 8 Characters!\n";
		if (Prompts != "")
		window.alert(Prompts);
		else {
		document.OpenAccountForm.submit();
		}
		}
</SCRIPT>