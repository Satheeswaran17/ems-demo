package employeemanagement.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import employeemanagement.model.Document;
import employeemanagement.model.Laptop;
import employeemanagement.model.Team;
import employeemanagement.model.Tool;

/**
 * <p>
 * It is class represent the Employee.
 * </p>
 */
public class Employee {
  private int id;
  private String name;
  private Date dob;
  private Date doj;
  private String role;
  private long phoneNumber;
  private Laptop laptop;
  private List<Document> documents;
  private Team team;
  private List<Tool> tools;
  
  public Employee(String name, Date dob, Date doj, String role, long phoneNumber) {
    this.name = name;
    this.dob = dob;
    this.doj = doj;
    this.role = role;
    this.phoneNumber = phoneNumber;
    this.documents = new ArrayList<>();
    this.tools = new ArrayList<>();
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
  
  public void setName(String name) {
    this.name = name;
  }
  
  public Date getDob() {
    return this.dob;
  }
  
  public void setDob(Date dob) {
    this.dob = dob;
  }
  
  public Date getDoj() {
    return this.doj;
  }
  
  public void setDoj(Date doj) {
    this.doj = doj;
  }
  
  public String getRole() {
    return this.role;
  }
  
  public void setRole(String role) {
    this.role = role;
  }
  
  public long getPhoneNumber() {
    return this.phoneNumber;
  }
  
  public void setPhoneNumber(long phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
  
  public Laptop getLaptop() {
    return this.laptop;
  }
  
  public void setLaptop(Laptop laptop) {
    this.laptop = laptop;
  }
  
  public List<Document> getDocument() {
    return this.documents;
  }
  
  public void setDocument(Document document) {
    this.documents.add(document);
  }
  
  public Team getTeam() {
    return this.team;
  }
  
  public void setTeam(Team team) {
    this.team = team;
  }
  
  public List<Tool> getTool() {
    return this.tools;
  }
  
  public void setTool(Tool tool) {
    this.tools.add(tool);
  }
  
  public String toString(){
    return "Employee [Id: " + this.id + ", Name " + this.name + ", Dob: " + this.dob + ", Doj: " + 
    this.doj + ", Role: " + this.role + ", PhoneNumber: " + this.phoneNumber + "]\n";
  }
}