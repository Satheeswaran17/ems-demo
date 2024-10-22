package employeemanagement.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import employeemanagement.model.Document;
import employeemanagement.service.DocumentService;
import employeemanagement.util.DateUtil;

/**
 * <p>
 * It is class to manage the Document details.
 * </p>
 */
public class DocumentController {
    Scanner scanner = new Scanner(System.in);
    private DocumentService documentService = new DocumentService();

    /**
     * <p>
     * It is method to get Document details from user and pass the Document details.
     * </p>
     *
     * @param employeeId to bind the Document with Employee.
     */
    public void addDocument(int employeeId) {
        boolean userInput;
        do {
            System.out.println("Enter document number");
            String documentNumber = scanner.nextLine();
            System.out.println("Enter document type");
            String type = scanner.nextLine();
            System.out.println("Enter document issue date (DD/MM/YYYY)");
            String inputDate = scanner.nextLine();
            Date issueDate = DateUtil.convertToDate(inputDate);
            if (issueDate == null) {
                System.out.println("Given Date formate is wrong");
            }
            System.out.println("Successfully added");
            System.out.println(documentService.addDocument(documentNumber, type, issueDate, employeeId) + "\n");
            System.out.println("Do you want add another document (true/false)");
            userInput = scanner.nextBoolean();
            scanner.nextLine();
        } while (userInput == true);

        
    }

    /**
     * <p>
     * It is method to remove Document.
     * </p>
     *
     * @param employeeId to find the Document.
     */
    public void removeDocumentById(int employeeId) {
        System.out.println("Enter a document id to delete");
        int documentId = scanner.nextInt();
        scanner.nextLine();
        if (!documentService.isDocumentPresent(documentId, employeeId)) {
            System.out.println("No document found");
        } else {
            documentService.removeDocument(documentId);
            System.out.println("Successfully Document deleted");
        }
    }

    /**
     * <p>
     * It is method to get Document details.
     * </p>
     *
     * @param employeeId to find the Document.
     */
    public void getDocumentDetails(int employeeId) {
        List<Document> documents = documentService.getDocumentById(employeeId);
        if (documents.size() == 0) {
            System.out.println("No document found");
        } else {
            for (Document document : documents) {
                System.out.print(document);
            }
        }
    }

    /**
     * <p>
     * It is method to remove Document.
     * </p>
     *
     * @param employeeId to find the Document.
     */
    public void removeDocument(int employeeId) {
        List<Document> documents = documentService.getDocumentById(employeeId);
        if (documents.size() == 0) {
            System.out.println("No document found");
        } else {
            for (Document document : documents) {
                documentService.removeDocument(document.getId());
                System.out.println("Successfully Document deleted");
            }
        }
    }

    /**
     * <p>
     * It is method to update Document datails and print the updated Document details
     * </p>
     *
     * @param employeeId to bind the Employee with Document.
     */
    public void updateDocument(int employeeId) {
        System.out.println("Enter 1 for add new document \nEnter 2 for update existing document");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                addDocument(employeeId);
                break;
            case 2:
                System.out.println("Enter a document id to update");
                int documentId = scanner.nextInt();
                scanner.nextLine();
                if (!documentService.isDocumentPresent(documentId, employeeId)) {
                    System.out.println("No document found");
                } else {
                    System.out.println("Enter document number");
                    String documentNumber = scanner.nextLine();
                    System.out.println("Enter document type");
                    String type = scanner.nextLine();
                    System.out.println("Enter document isuue date");
                    String inputDate = scanner.nextLine();
                    Date issueDate = DateUtil.convertToDate(inputDate);
                    if (issueDate == null) {
                        System.out.println("Given Date formate is wrong");
                    }
                    System.out.println("Successfully updated");
                    System.out.println(documentService.updateDocument(documentNumber, type, issueDate, documentId) + "\n");
                }
                break;
        }
    }
}