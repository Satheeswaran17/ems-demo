package employeemanagement.model;

import java.util.ArrayList;
import java.util.List;

import employeemanagement.model.Employee;

/**
 * <p>
 * It is class represent the Tool.
 * </p>
 */
public class Tool {
  private int id;
  private String name;
  private String version;
  private String type;
  private List<Employee> employees;
  
  public Tool(String name, String version, String type) {
    this.name = name;
    this.version = version;
    this.type = type;
    this.employees = new ArrayList<>();
  }
  
  public int getId() {
    return this.id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getName() {
    return this.name;
  }
  
  public void setToolName(String name) {
    this.name = name;
  }
  
  public String getVersion() {
    return this.version;
  }
  
  public void setVersion(String version) {
    this.version = version;
  }
  
  public String getType() {
    return this.type;
  }
  
  public void setType(String type) {
    this.type = type;
  }
  
  public void setEmployee(Employee employee) {
    this.employees.add(employee);
  }
  
  public List<Employee> getEmployee() {
    return this.employees;
  }
  
  public String toString() {
    return "Tool [Id: " + this.id + ", Name: " + this.name + ", Version: " + this.version + ", Type: " + this.type + 
		"]\n";
  }
}