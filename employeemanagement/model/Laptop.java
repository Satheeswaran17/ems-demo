package employeemanagement.model;

import employeemanagement.model.Employee;

/**
 * <p>
 * It is class represent the Laptop.
 * </p>
 */
public class Laptop {
  private int id;
  private String model;
  private String brand;
  private String os;
  private Employee employee;
  
  public Laptop(String model, String brand, String os) {
    this.model = model;
    this.brand = brand;
    this.os = os;
  }
  
  public int getId() {
    return this.id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getModel() {
    return this.model;
  }
  
  public void setModel(String model) {
    this.model = model;
  }
  
  public String getBrand() {
    return this.brand;
  }
  
  public void setBrand(String brand) {
    this.brand = brand;
  }
  
  public String getOs() {
    return this.os;
  }
  
  public void setOs(String os) {
    this.os = os;
  }
  
  public Employee getEmployee() {
    return this.employee;
  }
  
  public void setEmployee(Employee employee) {
    this.employee = employee;
  }
  
  public String toString() {
    return "Laptop [Id: " + this.id + ", Model: " + this.model + ", Brand: " + this.brand + ", Os: " + this.os + "]\n";
  }
}