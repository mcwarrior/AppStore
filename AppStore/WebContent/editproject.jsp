<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Project</title>
</head>
<body>
<%! 
	String user;
%>

<%
	user = request.getParameter("value");
%>
	<a href="home.jsp?value=<%= user %>">Back to Home</a>
	<form id="CreateProject" action="Create" method="post">
	    <h1>Edit Project</h1>
	    <fieldset id="info">
	    	<table>
	    		<tr>
	    			<td align="right">Enter Project Name:</td>
	    			<td><input id="name" name="name" type="text" autofocus required> <br /> </td>
	    		</tr>
	    		<tr>
	    			<td align="right">Enter Project Website:</td>
	    			<td><input id="site" name="site" type="text"required> <br /></td>
	    		</tr>
	    		<tr>
	    			<td align="right">Enter Description:</td>
	    			<td><input id="desc" name="desc" type="text"></td>
	    		</tr>
	    		<tr>
	    			<td>
	    				<input id="user" name="user" type="hidden" value="<%= user %>">
	    			</td>
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