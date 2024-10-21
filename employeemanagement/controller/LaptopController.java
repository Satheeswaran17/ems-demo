package employeemanagement.controller;

import java.util.Scanner;

import employeemanagement.model.Laptop;
import employeemanagement.service.LaptopService;

/**
 * <p>
 * It is class to manage the Laptop details.
 * </p>
 */
public class LaptopController {
  Scanner scanner = new Scanner(System.in);
  private LaptopService laptopService = new LaptopService();
  
  /**
   * <p>
   * It is method to get Laptop details from user and pass the Laptop details.
   * </p>
   * @param employeeId to bind the Employee with Laptop.
   */
  public void addLaptop(int employeeId) {
    System.out.println("Enter laptop model");
    String model = scanner.nextLine();
    System.out.println("Enter laptop brand");
    String brand = scanner.nextLine();
    System.out.println("Enter laptop os");
    String os = scanner.nextLine();
    Laptop updatedLaptop = laptopService.addLaptop(model, brand, os, employeeId);
    System.out.println("Successfully added");
    System.out.println(updatedLaptop + "\n"); 
  }
  
	
	/**
   * <p>
   * It is method to get Laptop details and print the all details of Laptop.
   * </p>
   * @param employeeId to find Laptop.
   */
	public void getLaptopDetails(int employeeId) {
		Laptop laptop = laptopService.getLaptopById(employeeId);
		if(laptop == null) {
      System.out.println("No laptop found");
    } else {
      System.out.print(laptop);
		}
	}
	
  /**
   * <p>
   * It is method to remove Laptop.
   * </p>
   * @param employeeId to find the Laptop.
   */
  public void removeLaptop(int employeeId) {
		Laptop laptop = laptopService.getLaptopById(employeeId);
    if(laptop == null) {
      System.out.println("No laptop found");
    } else {
			laptopService.removeLaptop(employeeId);
			System.out.println("Successfully Laptop deleted");
    }
  }
  
  /**
   * <p>
   * It is method to update Laptop datails and print the Laptop details.
   * </p>
   * @param employeeId to bind the Employee with Laptop.
   */
  public void updateLaptop(int employeeId) {
		Laptop laptop = laptopService.getLaptopById(employeeId);
	  if(laptop == null) {
	    System.out.println("No laptop present you want add new laptop please enter (true/false)");
      boolean userChoice = scanner.nextBoolean();
	    scanner.nextLine();
      if(userChoice == true) {
        addLaptop(employeeId);
      }
    } else {
      System.out.println("Enter laptop model");
      String model = scanner.nextLine();
      System.out.println("Enter laptop brand");
      String brand = scanner.nextLine();
      System.out.println("Enter laptop os");
      String os = scanner.nextLine();
      System.out.println("Successfully updated");
      System.out.println(laptopService.updateLaptop(model, brand, os, laptop.getId()) + "\n");
	  }	  
  }
}