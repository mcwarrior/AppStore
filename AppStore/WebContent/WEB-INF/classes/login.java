


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DataAccess;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
	private ResultSet rs;
	private DataAccess da;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		da = new DataAccess();
		conn = da.Connect();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		//String type = request.getParameter("select");
		String s = "";
		

		rs = da.loginQuery(conn, user, pass);
		s = "";
		try {
			if(rs.next()){
				response.sendRedirect("home.jsp?value='" + user + "'");
			} else {
				s = "Login Failed";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String html = "<!DOCTYPE html> <html> <head> <meta charset=UTF-8> " +
				"<title>Login</title> </head> <body>";
		pw.println(html);
		pw.println("<h1>" + s + "</h1>");
		pw.println("</body></html>");
	}

}
