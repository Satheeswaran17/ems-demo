package employeemanagement.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import employeemanagement.model.Employee;
import employeemanagement.model.Tool;
import employeemanagement.service.ToolService;

/**
 * <p>
 * It is class to manage the Tool details.
 * </p>
 */
public class ToolController {
  Scanner scanner = new Scanner(System.in);
  private ToolService toolService = new ToolService();
  
  /**
   * <p>
   * It is method to get Tool details from user and pass the Tool details or add existing Tool.
   * </p>
   * @param employeeId to bind the Employee with Tool.
   */
  public void addTool(int employeeId) {
    boolean userInput;
    do {
      System.out.println("Enter 1 for add into existing tool");
      System.out.println("Enter 2 for add new tool");
      int userChoice = scanner.nextInt();
	    scanner.nextLine();
      switch(userChoice) {
        case 1:
		      System.out.println("Tools");
		      getAllTools();
          System.out.println("Enter Tool id");
          int id = scanner.nextInt();
					scanner.nextLine();
          if(toolService.isToolIdPresent(id)) {
						if(toolService.isToolAvailable(id, employeeId)) {
              System.out.println("Successfully added");
              System.out.println(toolService.addToolById(id, employeeId) + "\n"); 
						} else {
							System.out.println("Tool Already Exist");
						}							
          } else {
            System.out.println("The tool is not present");
		      }
          break;
        case 2:
          System.out.println("Enter Tool name");
          String name = scanner.nextLine();
          System.out.println("Enter Tool version");
          String version = scanner.nextLine();
          System.out.println("Enter Tool type");
          String type = scanner.nextLine();
          System.out.println("Successfully added");
          System.out.println(toolService.addTool(name, version, type, employeeId) + "\n"); 
          break;
      }
      System.out.println("Do you want add another tool (true/false)");
      userInput = scanner.nextBoolean();
      scanner.nextLine();
    } while(userInput == true);
  }
  
	/**
   * <p>
   * It is method to get Tool details and print the all details of Tool.
   * </p>
   * @param employeeId to find Tool.
   */
	public void getToolDetails(int employeeId) {
		List<Tool> tools = toolService.getToolById(employeeId);
    if(tools.size() == 0) {
      System.out.println("No tool found");
    } else {
      for(Tool tool : tools) {
        System.out.print(tool);
      }
    }
	}
  
  /**
   * <p>
   * It is method to remove Employee from all Tool.
   * </p>
   * @param employeeId to find the Tool.
   */
  public void removeTool(int employeeId) {
		List<Tool> tools = toolService.getToolById(employeeId);
    if(tools.size() == 0) {
      System.out.println("No tool found");
    } else {
      for(Tool tool : tools) {
				toolService.removeTool(tool.getId(), employeeId);
				System.out.println("Successfully Tool deleted");
      }
    }
  }
  
	/**
   * <p>
   * It is method to remove Employee from Tool.
   * </p>
   * @param employeeId to find the Tool.
   */
	public void removeToolById(int employeeId) {
    System.out.println("Enter a tool id to delete");
    int toolId = scanner.nextInt();
    scanner.nextLine();    
		if(!toolService.isToolPresent(toolId, employeeId)) {
	    System.out.println("No tool found");
	  } else {
			toolService.removeTool(toolId, employeeId);
			System.out.println("Successfully Tool deleted");
	  }
  }
	
  /**
   * <p>
   * It is method to get all Tool and print the all Tool details.
   * </p>
   */
  public void getAllTools() {
    List<Tool> tools = toolService.getAllTools();
    if(tools.size() == 0) {
      System.out.println("No Tool present");
    } else {
      for(Tool tool: tools) {
        System.out.println(tool);
      }
    }
  }
}