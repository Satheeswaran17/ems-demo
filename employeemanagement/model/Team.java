package employeemanagement.model;

import java.util.ArrayList;
import java.util.List;

import employeemanagement.model.Employee;

/**
 * <p>
 * It is class represent the Team.
 * </p>
 */
public class Team {
  private int id;
  private String domain;
  private int employeesCount;
  private List<Employee> employees;
  
  public Team(String domain, int employeesCount) {
    this.domain = domain;
    this.employeesCount = employeesCount;
    this.employees = new ArrayList<>();
  }
  
  public int getId() {
    return this.id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getDomain() {
    return this.domain;
  }
  
  public void setDomain(String domain) {
    this.domain = domain;
  }
  
  public int getEmployeesCount() {
    return this.employeesCount;
  }
  
  public void setEmployeesCount(int employeesCount) {
    this.employeesCount = employeesCount;
  }
  
  public void setEmployee(Employee employee) {
    this.employees.add(employee);
  }
  
  public List<Employee> getEmployee() {
    return this.employees;
  }
  
  public String toString() {
    return "Team [Id: " + this.id + ", Domain: " + this.domain + ", EmployeesCount: " + this.employeesCount + "]\n";
  }
}