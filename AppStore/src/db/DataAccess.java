package db;
import java.sql.*;

import javax.swing.JOptionPane;

public class DataAccess {
	private Connection conn = null;
	private PreparedStatement ps = null;
	//private Statement st;
	private ResultSet rs = null;
	
	public Connection Connect(){
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost/appstore";
		String user = "root";
		String pass ="1111";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "Unable to Load the Driver",
					"Error", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException sqle) {
			if (sqle.getSQLState().contentEquals("08S01")) {
				JOptionPane.showMessageDialog(null, "Connection to Database Failed\nCheck your Connetion Setting and Try Again",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
			else if (sqle.getSQLState().contentEquals("28000")) {
				JOptionPane.showMessageDialog(null,
						"Password for root is Wrong", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
			else {
				System.out.println("Exception occurred:\nMessage: "
						+ sqle.getMessage());
				System.out.println("SQL state: " + sqle.getSQLState());
				System.out.println("Vendor code: " + sqle.getErrorCode() + "\n");
			}
		}
		return conn;
	}
	public ResultSet loginQuery(Connection connection, String user, String pass){
		try {
			String sql = "SELECT username, password FROM user WHERE username='" + user + "' AND password = '" + pass + "'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException sqle) {
				System.out.println("Exception occurred:\nMessage: "
						+ sqle.getMessage());
				System.out.println("SQL state: " + sqle.getSQLState());
				System.out.println("Vendor code: " + sqle.getErrorCode() + "\n");
		} catch(Exception ex){
            System.out.println(ex.getMessage());
        }
		return rs;
	}
	public boolean checkUser(Connection connection, String user){
		boolean check = false;
		try {
			
			String sql = "SELECT * FROM project WHERE username=" + user;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()){
				check = true;
			}
			rs.close();
		} catch (SQLException sqle) {
				System.out.println("Exception occurred:\nMessage: "
						+ sqle.getMessage());
				System.out.println("SQL state: " + sqle.getSQLState());
				System.out.println("Vendor code: " + sqle.getErrorCode() + "\n");
				sqle.printStackTrace();
		} catch(Exception ex){
            System.out.println(ex.getMessage());
        }
		return check;
	}
	public ResultSet Name(Connection connection, String user){
		try {
			String sql = "SELECT * FROM user WHERE username=" + user;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException sqle) {
				System.out.println("Exception occurred:\nMessage: "
						+ sqle.getMessage());
				System.out.println("SQL state: " + sqle.getSQLState());
				System.out.println("Vendor code: " + sqle.getErrorCode() + "\n");
		} catch(Exception ex){
            System.out.println(ex.getMessage());
        }
		return rs;
	}
	public void InsertUser (Connection conn,String user, String pass, String first, String last){
		try {
			String sql = "INSERT INTO user (username, password, firstName, lastName) VALUES(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			ps.setString(3, first);
			ps.setString(4, last);
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException sqle){
            System.out.println("Exception occurred:\nMessage: " +
                    sqle.getMessage());
            System.out.println("SQL state: " + sqle.getSQLState());
            System.out.println("Vendor code: " + sqle.getErrorCode() + "\n");
            System.out.println("\n\n\n");
            sqle.printStackTrace();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        finally{
             try {
            //Step 4: Closing the connection
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
            catch (Exception e) {
            }
        }
	}
	public void InsertProject (Connection conn,String name, String website, String desc, String user){
		try {
			String sql = "INSERT INTO project (projectName, website, description, username) VALUES(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, website);
			ps.setString(3, desc);
			ps.setString(4, user);
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException sqle){
            System.out.println("Exception occurred:\nMessage: " +
                    sqle.getMessage());
            System.out.println("SQL state: " + sqle.getSQLState());
            System.out.println("Vendor code: " + sqle.getErrorCode() + "\n");
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        finally{
             try {
            //Step 4: Closing the connection
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
            catch (Exception e) {
            }
        }
	}
	public void close(Connection conn){
		try {
			if (conn != null){
				conn.close();
			} else if (ps != null){
				ps.close();
			} else if (rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
