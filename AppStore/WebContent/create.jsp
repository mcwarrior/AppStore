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
<title>Create Project</title>
</head>
<body>
<%! 
	String user;
	String name;
	String website;
	String desc;
	Connection conn = null;
	DataAccess da = null;
%>

<%
	user = request.getParameter("value");
	name = request.getParameter("name");
	website = request.getParameter("site");
	desc = request.getParameter("desc");
	
	da = new DataAccess();
	conn = da.Connect();
	da.InsertProject(conn, name, website, desc, user);
	if(da.checkUser(conn, user)){
		response.sendRedirect("home.jsp?value=" + user);	
	}
	da.close(conn);
	
%>
</body>
</html>