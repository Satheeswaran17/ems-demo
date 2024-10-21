package employeemanagement.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import employeemanagement.model.Document;
import employeemanagement.model.Employee;
import employeemanagement.model.Laptop;
import employeemanagement.model.Team;
import employeemanagement.model.Tool;
import employeemanagement.service.EmployeeService;
import employeemanagement.util.DateUtil;

/**
 * <p>
 * It is class to manage the Employee details.
 * </p>
 */
public class EmployeeController {
  Scanner scanner = new Scanner(System.in);
  private EmployeeService employeeService = new EmployeeService();
  
  /**
   * <p>
   * It is method to get Employee details from user and pass the Employee details.
   * </p>
   */
  public Employee addEmployee() {
    System.out.println("Enter employee name");
    String name = scanner.nextLine();
    System.out.println("Enter employee date of birth (DD/MM/YYYY)");
    String inputDate = scanner.nextLine();
    Date dob = DateUtil.convertToDate(inputDate);
	  if(dob == null) {
	    System.out.println("Given Date formate is wrong");
	  }
    System.out.println("Enter employee date of joining (DD/MM/YYYY)");
    inputDate = scanner.nextLine();
    Date doj = DateUtil.convertToDate(inputDate);
	  if(doj == null) {
	    System.out.println("Given Date formate is wrong");
    }
    System.out.println("Enter employee role");
    String role = scanner.nextLine();
    System.out.println("Enter employee valid phone number");
    long phoneNumber = scanner.nextLong();
    scanner.nextLine();
		Employee employee = employeeService.addEmployee(name, dob, doj, role, phoneNumber); 
    System.out.println("Successfully added");
    System.out.println(employee + "\n");
		return employee;
  }
  
  /**
   * <p>
   * It is method to find Employee is present or not.
   * </p>
   * @param id to find the Employee.
   * @return true if the Employee is present, otherwise false.
   */
  public Boolean isEmployeePresent(int id) {
    return employeeService.isEmployeePresent(id);
  }
  
  /**
   * <p>
   * It is method to get Employee.
   * </p>
   * @param id to find the Employee.
   * @return Employee object if the Employee is present, otherwise null.
   */
  public Employee getEmployeeById(int id) {
    return employeeService.getEmployeeById(id);
  }
  
  /**
   * <p>
   * It is method to remove Employee.
   * </p>
   * @param id to find the Employee.
   */  
  public void removeEmployee(int id) {
    employeeService.removeEmployee(id);
		removeTeam(id);
		System.out.println("Successfully Employee deleted");
  }
  
  /**
   * <p>
   * It is method to remove Team .
   * </p>
   * @param employeeId to find the Employee.
   */
  public void removeTeam(int employeeId) {
		if(!employeeService.isTeamPresent(employeeId)) {
      System.out.println("No Team found");
    } else {
	    employeeService.removeTeam(employeeId);
	    System.out.println("Successfully Team deleted");
		}
  }
  
  /**
   * <p>
   * It is method to get Employee details and print the all details of Employee.
   * </p>
   * @param id to find Employee.
   */
  public void getEmployeeDetails(int id) {
    System.out.print(employeeService.getEmployeeById(id));
  }
  
  /**
   * <p>
   * It is method to get all employee object and print the all employee details.
   * </p>
   */
  public void getAllEmployees() {
    List<Employee> employees = employeeService.getAllEmployees();
    if(employees.size() == 0) {
      System.out.println("No employee present");
    } else {
      for(Employee employee : employees) {
        System.out.println(employee);
      }
    }
  }
  
  /**
   * <p>
   * It is method to update specific Employee datails and print the Employee details.
   * </p>
   * @param id to find Employee.
   */
  public void updateEmployee(int id) {
    System.out.println("Do you want update Employee details (true/false)");
    boolean userChoice = scanner.nextBoolean();
    scanner.nextLine();
    if(userChoice == true) {
      System.out.println("Enter employee name");
      String name = scanner.nextLine();
      System.out.println("Enter employee date of birth");
      String inputDate = scanner.nextLine();
      Date dob = DateUtil.convertToDate(inputDate);
	    if(dob == null) {
	      System.out.println("Given Date formate is wrong");
	    }
      System.out.println("Enter employee date of joining");
      inputDate = scanner.nextLine();
      Date doj = DateUtil.convertToDate(inputDate);
	    if(doj == null) {
	      System.out.println("Given Date formate is wrong");
	    }
      System.out.println("Enter employee role");
      String role = scanner.nextLine();
      System.out.println("Enter employee valid phone number");
      long phoneNumber = scanner.nextLong();
      scanner.nextLine();
      System.out.println("Successfully updated");
      System.out.println(employeeService.updateEmployee(id, name, dob, doj, role, phoneNumber) + "\n");
    }
  }
}