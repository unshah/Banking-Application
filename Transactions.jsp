<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="com.ntu.*;" %>

<%
	String FromDate = new String("");
	String ToDate = new String("");
	String UserID = new String("");
	String Name = new String("");

	FromDate = request.getParameter( "FromDate" );
	ToDate = request.getParameter( "ToDate" );
	UserID = request.getParameter( "UserID" );
	Name = request.getParameter( "Name" );

    Transactions ts = new Transactions(UserID);
    Vector componentNames = ts.TransFound(FromDate, ToDate);
    
    %>
    
    <HTML><HEAD></HEAD>
    		<BODY bgcolor='#ffffff'>
    		<TABLE cellPadding=3 ALIGN='center' border="1">
            		<tr>
            			<td>TransactionNumber</td>
            			<td>TransactionAmount</td>
            			<td>TransactionType</td>
            			<td>TransactionTime</td>
            			<td>TransactionDate</td>
            			<td>ToAccount</td>
            			<td>FromAccount</td>
            			<td>UserName</td>
            			
            		</tr>
            		<%
            			for(int i = 0;i<componentNames.size();i++ ){
            				Vector objs =(Vector) componentNames.get(i);
            				out.println("<tr>");
            					for(int j=0;j < objs.size();j++){
            						out.println("<td>" + objs.get(j) +"</td>");
            					}
            				out.println("</tr>");
            			}
    
            		%>
            	</TABLE>
            </BODY>
            </HTML>
