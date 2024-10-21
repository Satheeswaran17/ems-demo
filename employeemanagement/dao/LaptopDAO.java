package employeemanagement.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import employeemanagement.jdbcconnection.JdbcConnector;
import employeemanagement.model.Laptop;

/**
 * <p>
 * It is class to access, insert, update and delete the Laptop in database.
 * </p>
 */
public class LaptopDAO {
  
  /**
   * <p>
   * It is method to insert Laptop into database.
   * </p>
   * @param laptop to store the Laptop.
	 * @param employeeId to bind Employee with Laptop.
   */
  public void insertLaptop(Laptop laptop, int employeeId) {
		try(PreparedStatement preparedStatement = JdbcConnector.getConnection().prepareStatement("insert into laptop" + 
		"(model, brand, os, employee_id) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
			preparedStatement.setString(1, laptop.getModel());
			preparedStatement.setString(2, laptop.getBrand());
			preparedStatement.setString(3, laptop.getOs());
			preparedStatement.setInt(4, employeeId);
			preparedStatement.executeUpdate();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			laptop.setId(resultSet.getInt(1));
		} catch(Exception e) {
			System.out.println(e);
		}
  }
  
	/**
   * <p>
   * It is method to update Laptop into database.
   * </p>
   * @param laptop to store the Laptop.
	 * @param employeeId to bind Employee with Laptop.
   */
	public void updateLaptop(Laptop laptop, int id) {
		try(PreparedStatement preparedStatement = JdbcConnector.getConnection().prepareStatement("insert into laptop" + 
		"(model, brand, os) values(?,?,?)")) {
			preparedStatement.setString(1, laptop.getModel());
			preparedStatement.setString(2, laptop.getBrand());
			preparedStatement.setString(3, laptop.getOs());
			preparedStatement.executeUpdate();
			laptop.setId(id);
		} catch(Exception e) {
			System.out.println(e);
		}
  }
  
	/**
   * <p>
   * It is method to get the Laptop from database.
   * </p>
   * @param employeeId to find and get Laptop.
   * @return Laptop object if Laptop is present in database, otherwise null.
   */
	public Laptop fetchLaptop(int employeeId) {
		try(Statement statement = JdbcConnector.getConnection().createStatement()) {
			ResultSet resultSet = statement.executeQuery("select * from laptop where employee_id = " + employeeId );
		  if(resultSet.next()) {
			  Laptop laptop = new Laptop(resultSet.getString(2), resultSet.getString(3), 
	  		resultSet.getString(4));
		  	laptop.setId(resultSet.getInt(1));
			  return laptop;
			}
		} catch(Exception e) {
			System.out.println(e);
		}
    return null;
  }
	
  /**
   * <p>
   * It is method to delete Laptop from database.
   * </p>
   * @param employeeId to find and delete the Laptop.
   */  
  public void deleteLaptop(int employeeId) {
		try(Statement statement = JdbcConnector.getConnection().createStatement()) {
			statement.executeUpdate("delete from laptop where employee_id = " + employeeId );
		} catch(Exception e) {
			System.out.println (e);
		}
  }
}