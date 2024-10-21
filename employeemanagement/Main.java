package employeemanagement;

import java.util.Scanner;

import employeemanagement.controller.*;
import employeemanagement.model.Employee;

/**
 * <p>
 * It is class to get choice from user.
 * </p>
 */
public class Main {
	
  /**
   * <p>
   * It is method to get choice from user to add, delete, read and update the Employee details.
   * </p>
   */
  public static void main(String args[]) {
    int userInputNumber;
    Scanner scanner = new Scanner(System.in);
    EmployeeController employeeController = new EmployeeController();
	  LaptopController laptopController = new LaptopController();
    DocumentController documentController = new DocumentController();
    TeamController teamController = new TeamController();
    ToolController toolController = new ToolController();
    do {
      System.out.println("Enter 1 for insert the employee details");
      System.out.println("Enter 2 for delete specific employee details");
      System.out.println("Enter 3 for get specific employee details");
      System.out.println("Enter 4 for get all employee details");
      System.out.println("Enter 5 for update employee's details");
      System.out.println("Enter 0 for exit");
      userInputNumber = scanner.nextInt();
      scanner.nextLine();
      switch(userInputNumber) {
        case 1:
          Employee employee = employeeController.addEmployee();
		      System.out.println("Do you want add your laptop details (true/false)");
          boolean userInput = scanner.nextBoolean();
          scanner.nextLine();
          int id = employee.getId();
          if(userInput == true) {
            laptopController.addLaptop(id);
          }
          System.out.println("Do you want add your document details (true/false)");
          userInput = scanner.nextBoolean();
          scanner.nextLine();
          if(userInput == true) {
            documentController.addDocument(id);
          }
          System.out.println("Do you want add your Team details (true/false)");
          userInput = scanner.nextBoolean();
          scanner.nextLine();
          if(userInput == true) {
            teamController.addTeam(id);
          }
          System.out.println("Do you want add your Tool details (true/false)");
          userInput = scanner.nextBoolean();
          scanner.nextLine();
          if(userInput == true) {
            toolController.addTool(id);
          }
          break;
        case 2:
		      System.out.println("Enter employee id");
          id = scanner.nextInt();
					scanner.nextLine();
          if(!employeeController.isEmployeePresent(id)) {
            System.out.println("Employee id is not in the database \n");
          } else {
            System.out.println("Do you want delete full Employee details (true/false)");
            boolean userChoice = scanner.nextBoolean();
            scanner.nextLine();
            if(userChoice == true) {
			        laptopController.removeLaptop(id);
							documentController.removeDocument(id);
							toolController.removeTool(id);
							employeeController.removeEmployee(id);
						} else {
							System.out.println("Do you want delete laptop details (true/false)");
              userChoice = scanner.nextBoolean();
              scanner.nextLine();
              if(userChoice == true) {
								laptopController.removeLaptop(id);
							}
							System.out.println("Do you want delete document details (true/false)");
              userChoice = scanner.nextBoolean();
              scanner.nextLine();
              while(userChoice == true) {
                documentController.removeDocumentById(id);
                System.out.println("Do you want delete another document details (true/false)");
                userChoice = scanner.nextBoolean();
                scanner.nextLine();
              }
							System.out.println("Do you want delete team details (true/false)");
              userChoice = scanner.nextBoolean();
              scanner.nextLine();
			        if(userChoice == true) {
                employeeController.removeTeam(id);
			        }
					    System.out.println("Do you want delete tool details (true/false)");
              userChoice = scanner.nextBoolean();
              scanner.nextLine();
              while(userChoice == true) {
                toolController.removeToolById(id);
                System.out.println("Do you want update another Document details (true/false)");
                userChoice = scanner.nextBoolean();
                scanner.nextLine();
              }
						}
          }
          break;
        case 3:
		      System.out.println("Enter employee id");
          id = scanner.nextInt();
					scanner.nextLine();
					if(!employeeController.isEmployeePresent(id)) {
            System.out.println("Employee id is not in the database\n");
		      } else {
            employeeController.getEmployeeDetails(id);
						laptopController.getLaptopDetails(id);
						documentController.getDocumentDetails(id);
						teamController.getTeamDetails(id);
						toolController.getToolDetails(id);
					}
          break;
        case 4:
          employeeController.getAllEmployees();
          break;
        case 5:
		      System.out.println("Enter employee id");
          id = scanner.nextInt();
					scanner.nextLine();
          boolean userChoice;
          if(!employeeController.isEmployeePresent(id)) {
            System.out.println("Employee id is not in the database");
            System.out.println();
          } else {
						employeeController.getEmployeeDetails(id);
						laptopController.getLaptopDetails(id);
						documentController.getDocumentDetails(id);
						teamController.getTeamDetails(id);
						toolController.getToolDetails(id);
		        employeeController.updateEmployee(id);
            System.out.println("Do you want update Laptop details (true/false)");
            userChoice = scanner.nextBoolean();
            scanner.nextLine();
            if(userChoice == true) {
              laptopController.updateLaptop(id);
			      }
		        System.out.println("Do you want update Document details (true/false)");
            userChoice = scanner.nextBoolean();
            scanner.nextLine();
            while(userChoice == true) {
							documentController.updateDocument(id);
			        System.out.println("Do you want update another Document details (true/false)");
              userChoice = scanner.nextBoolean();
              scanner.nextLine();
		        }
		        System.out.println("Do you want update Team details (true/false)");
            userChoice = scanner.nextBoolean();
            scanner.nextLine();
            if(userChoice == true) {
              System.out.println("You can't update your team details\nDo you want create new team or join existing team (true/false)");
			        userChoice = scanner.nextBoolean();
              scanner.nextLine();
              if(userChoice == true) {
                teamController.addTeam(id);
              }
		        }
            System.out.println("Do you want update Tool details (true/false)");
            userChoice = scanner.nextBoolean();
            scanner.nextLine();
            if(userChoice == true) {
              System.out.println("You can't update your tool details\nDo you want create new tool or join existing tool (true/false)");
	   	        userChoice = scanner.nextBoolean();
              scanner.nextLine();
              if(userChoice == true) {
			          toolController.addTool(id);
			        }
						}
		      }
		      break;
        default:
          System.out.println("Please enter a valid number");
	    }
    } while(userInputNumber != 0);
  }
}
