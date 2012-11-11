<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Personal Information</title>
</head>
<body>
<%! 
	String user;
%>

<%
	user = request.getParameter("value");
%>
	<a href="home.jsp?value=<%= user %>">Back to Home</a>
	<form id="register" action="Register" method="post">
	    <h1>Edit Personal Information</h1>
	    <fieldset id="user">
	    	<table>
	    		<tr>
	    			<td align="right"></td>
	    			<td></td>
	    		</tr>
	    		<tr>
	    			<td align="right">Enter password:</td>
	    			<td> <input id="pass" name="pass" type="password" ></td>
	    		</tr>
	    		<tr>
	    			<td align="right">Re-Enter password:</td>
	    			<td><input id="rePass" name="rePass" type="password" ></td>
	    		</tr>
	    		<tr>
	    			<td align="right">First Name:</td>
	    			<td> <input id="first" name="first" type="text" ></td>
	    		</tr>
	    		<tr>
	    			<td align="right">Last Name: </td>
	    			<td> <input id="last" name="last" type="text" ></td>
	    		</tr>
	    		<tr>
	    			<td align="right"><input type="submit" id="submit" value="Submit"></td>
	    			<td><input type="reset" id="reset" value="Reset"></td>
	    		</tr>
	        </table>
		</fieldset>
	</form>
</body>
</html>