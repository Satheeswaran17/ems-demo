package employeemanagement.service;

import employeemanagement.dao.LaptopDAO;
import employeemanagement.model.Laptop;
import employeemanagement.model.Employee;
import employeemanagement.service.EmployeeService;

/**
 * <p>
 * It is Service class to Laptop - related operations.
 * </p>
 */
public class LaptopService {
  private LaptopDAO laptopDAO = new LaptopDAO();
  private EmployeeService employeeService = new EmployeeService();
  
  /**
   * <p>
   * It is method to create and pass the Laptop object.
   * </p>
   * @param model is denotes the Laptop model.
   * @param brand is denotes the Laptop brand.
   * @param os is denotes the Laptop os.
   * @param employeeId to brand the Employee object with Laptop object.
   * @return inserted Laptop object.
   */
  public Laptop addLaptop(String model, String brand, String os, int employeeId) {
    Laptop laptop = new Laptop(model, brand, os);
    laptopDAO.insertLaptop(laptop, employeeId);
    return laptop;
  }
  
	 /**
   * <p>
   * It is method to get Laptop.
   * </p>
   * @param employeeId to find the Laptop.
   * @return Laptop object if the Laptop is present, otherwise null.
   */
	public Laptop getLaptopById(int employeeId) {
    return laptopDAO.fetchLaptop(employeeId);
  }
	
  /**
   * <p>
   * It is method to remove Laptop.
   * </p>
   * @param laptop to remove Laptop.
   * @return deleted Laptop object if the Laptop is deleted, otherwise null.
   */ 
  public void removeLaptop(int employeeId) {
    laptopDAO.deleteLaptop(employeeId);
  }
  
  /**
   * <p>
   * It is method to update specific Laptop datails and print the Laptop details.
   * </p>
   * @param model is denotes the Laptop model.
   * @param brand is denotes the Laptop brand.
   * @param os is denotes the Laptop os.
   * @param laptop is denotes the Laptop object.
   * @return updated Laptop object.
   */
  public Laptop updateLaptop(String model, String brand, String os, int id) {
    Laptop laptop = new Laptop(model, brand, os);
    laptopDAO.updateLaptop(laptop, id);
    return laptop;
  }
}