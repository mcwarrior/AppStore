


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import db.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
	private DataAccess da;


    /**
     * Default constructor. 
     */
    public Register() {
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
		String first = request.getParameter("first");
		String last = request.getParameter("last");
		
		da.InsertUser(conn, user, pass, first, last);
		da.close(conn);
		String html = "<!DOCTYPE html> <html> <head> <meta charset=UTF-8> " +
				"<title>Home</title> </head> <body>";
		pw.println(html);
		response.sendRedirect("home.jsp?value='" + user + "'");
		pw.println("</body></html>");
	}

}
