package employeemanagement.jdbcconnection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * <p>
 * It is a class to connecte database using Jdbc.
 * </p>
 */
public class JdbcConnector {
	private static Connection connection = null;
	
	/**
   * <p>
   * It is method to create Jdbc connection.
   * </p>
   * @return new connection.
   */

  public static Connection createConnection() throws Exception {
		String url = "jdbc:postgresql://localhost:5432/EmployeeManagement?user=postgres&password=Sathees172003@";
	  connection = DriverManager.getConnection(url);
		return connection;
	}
	
	/**
   * <p>
   * It is method to get the connection.
   * </p>
   * @return new connection if connection is null or closed, otherwise existing connection.
   */

	public static Connection getConnection() throws Exception {
		if(connection == null || connection.isClosed()) {
		  return createConnection();
		}
		return connection;
	}
}