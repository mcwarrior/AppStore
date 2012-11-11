

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import db.DataAccess;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Create
 */
@WebServlet("/Create")
public class Create extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataAccess da = null;
	private Connection conn = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Create() {
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
		
		String name = request.getParameter("name");
		String website = request.getParameter("site");
		String desc = request.getParameter("desc");
		String user = request.getParameter("user");
		
		da.InsertProject(conn, name, website, desc, user);	
		String html = "<!DOCTYPE html> <html> <head> <meta charset=UTF-8> " +
				"<title>Home</title> </head> <body>";
		pw.println(html);
		response.sendRedirect("home.jsp?value=" + user);
		pw.println("</body></html>");
	}

}
