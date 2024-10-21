package employeemanagement.model;

import java.util.Date;

import employeemanagement.model.Employee;

/**
 * <p>
 * It is class represent the Document.
 * </p>
 */
public class Document {
  private int id;
  private String documentNumber;
  private String type;
  private Date issueDate;
  private Employee employee;
  
  public Document(String documentNumber, String type, Date issueDate) {
    this.documentNumber = documentNumber;
    this.type = type;
    this.issueDate = issueDate;
  }
  
  public int getId() {
    return this.id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getDocumentNumber() {
    return this.documentNumber;
  }
  
  public void setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
  }
  
  public String getType() {
    return this.type;
  }
  
  public void setType(String type) {
    this.type = type;
  }
  
  public Date getIssueDate() {
    return this.issueDate;
  }
  
  public void setIssueDate(Date issueDate) {
    this.issueDate = issueDate;
  }
  
  public Employee getEmployee() {
    return this.employee;
  }
  
  public void setEmployee(Employee employee) {
    this.employee = employee;
  }
  
  public String toString() {
    return "Document [Id: " + this.id + ", DocumenNumber: " + this.documentNumber + ", Type: " + this.type + 
		", IssueDate: " + this.issueDate + "]\n";
  }
}