<%@ 
	page language="java" 
	import="java.sql.Connection"
	import="java.sql.ResultSet"
	import="db.DataAccess"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
<%! 
	String user;
	String first;
	String last;
	Connection conn = null;
	ResultSet rs = null;
	DataAccess da = null;
%>
<%
	da = new DataAccess();
	user = request.getParameter("value");
	conn = da.Connect();
	/*rs = da.Name(conn, user);
	while(rs.next()){
		first = rs.getString("firstName");
		last = rs.getString("lastName");
	}*/
	out.println("<h1>Welcome </h1>");// + first + " " + last);
	out.println("<a href=editpersonal.jsp?value=" + user + ">Edit Personal Information</a> <br />");
	
	if (da.checkUser(conn, user)){
		out.print("<a href=editproject.jsp?value=" + user + ">Edit Project</a>");
	} else {
		out.print("<a href=createproject.jsp?value=" + user + ">Create Project</a>");
	}
	da.close(conn);
%>
</body>
</html>