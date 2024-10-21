package employeemanagement.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import employeemanagement.jdbcconnection.JdbcConnector;
import employeemanagement.model.Employee;

/**
 * <p>
 * It is class to access, insert, update and delete the Employee in database.
 * </p>
 */
public class EmployeeDAO {

  /**
   * <p>
   * It is method to insert Employee into database.
   * </p>
   * @param employee to store the Employee object.
   */
  public void insertEmployee(Employee employee) {
		Date dob = new Date(employee.getDob().getTime());
		Date doj = new Date(employee.getDoj().getTime());
		try(PreparedStatement preparedStatement = JdbcConnector.getConnection().prepareStatement("insert into employee" + 
		"(name, dob, doj, role, phone_number) values(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
			preparedStatement.setString(1,employee.getName());
			preparedStatement.setDate(2,dob);
			preparedStatement.setDate(3,doj);
			preparedStatement.setString(4,employee.getRole());
			preparedStatement.setLong(5,employee.getPhoneNumber());
			preparedStatement.executeUpdate();
      ResultSet resultSet = preparedStatement.getGeneratedKeys();			
			resultSet.next();
			employee.setId(resultSet.getInt(1));
		} catch(Exception e) {
			System.out.println(e);
		}
  }
  
  /**
   * <p>
   * It is method to find Employee is present or not.
   * </p>
   * @param id to find the Employee.
   * @return true if the Employee is present, otherwise false.
   */
  public Boolean isEmployeePresent(int id) {
		try(Statement statement = JdbcConnector.getConnection().createStatement()) {
			ResultSet resultSet = statement.executeQuery("select * from employee where id = " + id );
			if(resultSet.next()) {
				return true;
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		return false;
  }
	
	/**
   * <p>
   * It is method to find Toom is present or not.
   * </p>
   * @param id to find the Team.
   * @return true if the Team is present, otherwise false.
   */
	public Boolean isTeamPresent(int id) {
		try(Statement statement = JdbcConnector.getConnection().createStatement()) {
			ResultSet resultSet = statement.executeQuery("select * from employee where id = " + id + 
			" and team_id is not null" );
			if(resultSet.next()) {
				return true;
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		return false;
  }
  
  /**
   * <p>
   * It is method to delete Employee from database.
   * </p>
   * @param id to find and delete the Employee.
   */  
  public void deleteEmployee(int id) {
		try(Statement statement = JdbcConnector.getConnection().createStatement()) {
			statement.executeUpdate("delete from employee where id = " + id );
		} catch(Exception e) {
			System.out.println(e);
		}
  }
	
	
	/**
   * <p>
   * It is method to delete Team from database.
   * </p>
   * @param id to find and delete the Team.
   */  
	public void deleteTeam(int id) {
		try(Statement statement = JdbcConnector.getConnection().createStatement()) {
			statement.executeUpdate("update employee set team_id = null where id = " + id );
		} catch(Exception e) {
			System.out.println(e);
		}
  }
  
	/**
   * <p>
   * It is method to update Team from database.
   * </p>
	 * @param employee to store the Employee.
   * @param id to find and update the Team.
   */  
	public void updateEmployee(Employee employee, int id) {
		Date dob = new Date(employee.getDob().getTime());
		Date doj = new Date(employee.getDoj().getTime());
		try(PreparedStatement preparedStatement = JdbcConnector.getConnection().prepareStatement("insert into employee" + 
		"(name, dob, doj, role, phone_number) values(?,?,?,?,?)")){
			preparedStatement.setString(1,employee.getName());
			preparedStatement.setDate(2,dob);
			preparedStatement.setDate(3,doj);
			preparedStatement.setString(4,employee.getRole());
			preparedStatement.setLong(5,employee.getPhoneNumber());
			preparedStatement.executeUpdate();
			employee.setId(id);
		} catch(Exception e) {
			System.out.println(e);
		}
  }
	
  /**
   * <p>
   * It is method to get the Employee from database.
   * </p>
   * @param id to find and get Employee.
   * @return Employee object if Employee is present in database, otherwise null.
   */
  public Employee fetchEmployee(int id) {
		try(Statement statement = JdbcConnector.getConnection().createStatement()) {
			ResultSet resultSet = statement.executeQuery("select * from employee where id = " + id );
			resultSet.next();
			Employee employee = new Employee(resultSet.getString(2), new java.util.Date(resultSet.getDate(3).getTime()), 
			new java.util.Date(resultSet.getDate(4).getTime()), resultSet.getString(5), resultSet.getLong(6));
			employee.setId(resultSet.getInt(1));
			return employee;
		} catch(Exception e) {
			System.out.println(e);
		}
    return null;
  }
  
  /**
   * <p>
   * It is method to get the all Employee from database.
   * </p>
   * @return List of Employee objects if Employees are present in database, otherwise empty List.
   */
  public List<Employee> fetchAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		try(Statement statement = JdbcConnector.getConnection().createStatement()) {
			ResultSet resultSet = statement.executeQuery("select * from employee");
			while(resultSet.next()) {
			  Employee employee = new Employee(resultSet.getString(2), new java.util.Date(resultSet.getDate(3).getTime()), 
			  new java.util.Date(resultSet.getDate(4).getTime()), resultSet.getString(5), resultSet.getLong(6));
			  employee.setId(resultSet.getInt(1));
				employees.add(employee);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
    return employees;
  }
	
	/**
   * <p>
   * It is method to add Team in Employee database.
   * </p>
   * @param teamId to add Team.
	 * @param id to find Employee.
   */
	public void setTeamId(int teamId, int id) {
		try(Statement statement = JdbcConnector.getConnection().createStatement()) {
			statement.executeUpdate("update employee set team_id = " + teamId + " where id = " + id);
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	/**
   * <p>
   * It is method to get Team id in Employee database.
   * </p>
   * @param id to find Team id.
	 * @return Team id if Team present, otherwise -1.
   */
	public int getTeamId(int id) {
		try(Statement statement = JdbcConnector.getConnection().createStatement()) {
			ResultSet resultSet = statement.executeQuery("select team_id from employee where id = " + id );
			if(resultSet.next()) {
				return resultSet.getInt(1);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		return -1;
	}
	
}