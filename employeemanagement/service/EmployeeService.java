package employeemanagement.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import employeemanagement.dao.EmployeeDAO;
import employeemanagement.model.Document;
import employeemanagement.model.Employee;
import employeemanagement.model.Laptop;
import employeemanagement.model.Team;
import employeemanagement.model.Tool;

/**
 * <p>
 * It is Service class to Employee - related operations.
 * </p>
 */
public class EmployeeService {
  private EmployeeDAO employeeDAO = new EmployeeDAO();
  
  
  /**
   * <p>
   * It is method to create and pass the Employee object.
   * </p>
   * @param name is denotes the Employee name.
   * @param dob is denotes the Employee date of birth.
   * @param doj is denotes the Employee date of joining.
   * @param role is denotes the Employee role.
   * @param phoneNumber is denotes the Employee phone number.
   * @return inserted Employee object.
   */
  public Employee addEmployee(String name, Date dob, Date doj, String role, long phoneNumber) {
    Employee employee = new Employee(name, dob, doj, role, phoneNumber);
    employeeDAO.insertEmployee(employee);
    return employee;
  }
  
	/**
   * <p>
   * It is method to insert Team id into Employee.
   * </p>
   * @param teamId to store the Team id.
   * @param employeeId to bind the Employee with Laptop.
   */
	public void setTeamId(int teamId, int employeeId) {
		employeeDAO.setTeamId(teamId, employeeId);
	}
  /**
   * <p>
   * It is method to find Employee is present or not.
   * </p>
   * @param id to find the Employee.
   * @return true if the Employee is present, otherwise false.
   */
  public Boolean isEmployeePresent(int id) {
    return employeeDAO.isEmployeePresent(id);
  }
	
	/**
   * <p>
   * It is method to find Team is present or not.
   * </p>
   * @param id to find the Team.
   * @return true if the Team is present, otherwise false.
   */
	public Boolean isTeamPresent(int employeeId) {
    return employeeDAO.isTeamPresent(employeeId);
  }
  
  /**
   * <p>
   * It is method to remove Employee.
   * </p>
   * @param id to find the Employee.
   */  
  public void removeEmployee(int id) {
    employeeDAO.deleteEmployee(id);
  }
  
  /**
   * <p>
   * It is method to update specific employee datails and print the employee details.
   * </p>
   * @param id to find Employee object.
	 * @param name is denotes the Employee name.
   * @param dob is denotes the Employee date of birth.
   * @param doj is denotes the Employee date of joining.
   * @param role is denotes the Employee role.
   * @param phoneNumber is denotes the Employee phone number.
   * @return updated Employee object.
   */
  public Employee updateEmployee(int id, String name, Date dob, Date doj, String role, long phoneNumber) {
    Employee employee = new Employee(name, dob, doj, role, phoneNumber);
    employeeDAO.updateEmployee(employee, id);
    return employee;
  }

  /**
   * <p>
   * It is method to remove Team.
   * </p>
   * @param employeeId to find the Team.
   */
  public void removeTeam(int employeeId) {
	  employeeDAO.deleteTeam(employeeId);
  }
  
  /**
   * <p>
   * It is method to get Employee.
   * </p>
   * @param id to find the Employee.
   * @return Employee object if the Employee is present, otherwise null.
   */
  public Employee getEmployeeById(int id) {
    return employeeDAO.fetchEmployee(id);
  }
  
	/**
   * <p>
   * It is method to get Team id.
   * </p>
   * @param employeeId to find the Employee.
   * @return Team id if the Team id is present, otherwise -1.
   */
	public int getTeamId(int employeeId) {
		return employeeDAO.getTeamId(employeeId);
	}
	
  /**
   * <p>
   * It is method to get the all Employee.
   * </p>
   * @return List of Employee objects if Employees are present, otherwise empty List.
   */
  public List<Employee> getAllEmployees() {
    return employeeDAO.fetchAllEmployees();
  }
}