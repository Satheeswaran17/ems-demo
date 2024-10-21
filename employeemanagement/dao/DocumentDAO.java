package employeemanagement.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import employeemanagement.jdbcconnection.JdbcConnector;
import employeemanagement.model.Document;

/**
 * <p>
 * It is class to access, insert, update and delete the Document in database.
 * </p>
 */
public class DocumentDAO {
  
  /**
   * <p>
   * It is method to insert Document into database.
   * </p>
   * @param document to store the Document.
	 * @param employeeId to bind the Employee with Document
   */
  public void insertDocument(Document document, int employeeId) {
		Date issueDate = new Date(document.getIssueDate().getTime());
		try(PreparedStatement preparedStatement = JdbcConnector.getConnection().prepareStatement("insert into document" + 
		"(document_number, type, issue_date, employee_id) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
			preparedStatement.setString(1,document.getDocumentNumber());
			preparedStatement.setString(2,document.getType());
			preparedStatement.setDate(3,issueDate);
			preparedStatement.setInt(4,employeeId);
			preparedStatement.executeUpdate();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			document.setId(resultSet.getInt(1));
		} catch(Exception e) {
			System.out.println(e);
		}
  }
  
	/**
   * <p>
   * It is method to update Document into database.
   * </p>
   * @param document to store the Document.
	 * @param id to update the Document in database.
   */
	public void updateDocument(Document document, int id) {
		Date issueDate = new Date(document.getIssueDate().getTime());
		try(PreparedStatement preparedStatement = JdbcConnector.getConnection().prepareStatement("insert into document" + 
		"(document_number, type, issue_date) values(?,?,?)")) {
			preparedStatement.setString(1,document.getDocumentNumber());
			preparedStatement.setString(2,document.getType());
			preparedStatement.setDate(3,issueDate);
			preparedStatement.executeUpdate();
			document.setId(id);
		} catch(Exception e) {
			System.out.println(e);
		}
  }
	
  /**
   * <p>
   * It is method to find Document is present or not.
   * </p>
   * @param documentId to find the Document.
	 * @param employeeId to find Document.
   * @return true if the Document is present, otherwise false.
   */
  public Boolean isDocumentPresent(int documentId, int employeeId) {
		try(Statement statement = JdbcConnector.getConnection().createStatement()) {
			ResultSet resultSet = statement.executeQuery("select * from document where id = " + documentId + 
			" and employee_id = " + employeeId);
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
   * It is method to delete Document from database.
   * </p>
   * @param id to delete the Document object.
   */  
  public void deleteDocument(int id) {
    try(Statement statement = JdbcConnector.getConnection().createStatement()) {
			statement.executeUpdate("delete from document where id = " + id );
		} catch(Exception e) {
			System.out.println(e);
		}
  }
  
  /**
   * <p>
   * It is method to get the all Document from database.
   * </p>
   * @param employeeId to find and get Document.
   * @return List of Document object if Document is present in database, otherwise empty List.
   */
  public List<Document> fetchDocument(int employeeId) {
		List<Document> documents = new ArrayList<>();
		try(Statement statement = JdbcConnector.getConnection().createStatement()) {
			ResultSet resultSet = statement.executeQuery("select * from document where employee_id = " + employeeId );
		  while(resultSet.next()) {
			  Document document = new Document(resultSet.getString(2), resultSet.getString(3), 
	  		new java.util.Date(resultSet.getDate(4).getTime()));
		  	document.setId(resultSet.getInt(1));
				documents.add(document);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
    return documents;
  }
}