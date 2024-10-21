package employeemanagement.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import employeemanagement.dao.DocumentDAO;
import employeemanagement.model.Document;
import employeemanagement.model.Employee;
import employeemanagement.service.EmployeeService;

/**
 * <p>
 * It is Service class to Document - related operations.
 * </p>
 */
public class DocumentService {
  private DocumentDAO documentDAO = new DocumentDAO();
  private EmployeeService employeeService = new EmployeeService();
  
  /**
   * <p>
   * It is method to create and pass the Document object.
   * </p>
   * @param documentNumber is denotes the Document number.
   * @param type is denotes the Document type.
   * @param issueDate is denotes the Document issueDate.
   * @param employeeId to brand the Employee object with Document object.
   * @return inserted Document object.
   */
  public Document addDocument(String documentNumber, String type, Date issueDate, int employeeId) {
    Document document = new Document(documentNumber, type, issueDate);
    documentDAO.insertDocument(document, employeeId);
    return document;
  }
  
  /**
   * <p>
   * It is method to find Document is present or not.
   * </p>
   * @param documentId to find the Document id.
	 * @param employeeId to bind the Employee with Tool
   * @return true if the Document is present, otherwise false.
   */
  public Boolean isDocumentPresent(int documentId, int employeeId) {
    return documentDAO.isDocumentPresent(documentId, employeeId);
  }
  
	/**
   * <p>
   * It is method to get the all Document.
   * </p>
   * @param employeeId to find and get Document.
   * @return List of Document object if Document is present in database, otherwise empty List.
   */
	public List<Document> getDocumentById(int employeeId) {
    return documentDAO.fetchDocument(employeeId);
  }
	
  /**
   * <p>
   * It is method to remove Document.
   * </p>
   * @param id to find the Document.
   */ 
  public void removeDocument(int id) {
    documentDAO.deleteDocument(id);
  }
  
  /**
   * <p>
   * It is method to update specific Document datails and print the Document details.
   * </p>
   * @param documentNumber is denotes the Document number.
   * @param type is denotes the Document type.
   * @param issueDate is denotes the Document issueDate.
   * @param document is denotes the Document object.
   * @return updated Document object.
   */
  public Document updateDocument(String documentNumber, String type, Date issueDate, int id) {
    Document document = new Document(documentNumber, type, issueDate);
    documentDAO.updateDocument(document, id);
    return document;
  }
}