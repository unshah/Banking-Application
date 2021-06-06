<HTML>
<HEAD></HEAD>
<BODY>
<FORM NAME="TransactionsFrom" ACTION="/CSCI6810/Transactions.jsp" METHOD ="POST">
    <INPUT TYPE='hidden' NAME='UserID' VALUE='<%=request.getParameter("UserID")%>'>
    <INPUT TYPE='hidden' NAME='Name' VALUE='<%=request.getParameter("Name")%>'>
    <TABLE cellPadding=3 ALIGN='center'>

        <tr bgcolor='#ccd7ff'><td>From Date:</td><td><INPUT TYPE="TEXT" NAME="FromDate" PLACEHOLDER="YYYY-MM-DD" SIZE=20></td></tr>
        <tr bgcolor='#ccd7ff'><td>To Date:</td><td><INPUT TYPE="TEXT" NAME="ToDate" PLACEHOLDER="YYYY-MM-DD" SIZE=20></td></tr>
    </TABLE><BR>
    <CENTER><INPUT TYPE="SUBMIT" NAME='submitBNTN' VALUE='Inquire Transactions'"></CENTER><BR>
</FORM>

</BODY>
</HTML>
<SCRIPT LANGUAGE='JavaScript'>
</SCRIPT>