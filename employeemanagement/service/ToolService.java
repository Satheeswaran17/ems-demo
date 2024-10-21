package employeemanagement.service;

import java.util.ArrayList;
import java.util.List;

import employeemanagement.dao.ToolDAO;
import employeemanagement.model.Tool;
import employeemanagement.model.Employee;
import employeemanagement.service.EmployeeService;

/**
 * <p>
 * It is Service class to Tool - related operations.
 * </p>
 */
public class ToolService {
  private ToolDAO toolDAO = new ToolDAO();
  private EmployeeService employeeService = new EmployeeService();
  
  /**
   * <p>
   * It is method to create and pass the Tool object.
   * </p>
   * @param name is denotes the Tool name.
   * @param version is denotes the Tool version.
   * @param type is denotes the Tool type.
   * @param employeeId to brand the Employee object with Laptop object.
   * @return added Tool object.
   */
  public Tool addTool(String name, String version, String type, int employeeId) {
    Tool tool = new Tool(name, version, type);
    toolDAO.insertTool(tool);
    return toolDAO.insertToolById(tool.getId(), employeeId);
  }
  
	/**
   * <p>
   * It is method to insert Employee with Tool.
   * </p>
   * @param id to store the Tool.
   * @param employeeId to bind the Employee with Tool.
   * @return inserted Tool object.
   */
	public Tool addToolById(int id, int employeeId) {
		return toolDAO.insertToolById(id, employeeId);
    
  }
	
	/**
   * <p>
   * It is method to find Tool available to add.
   * </p>
   * @param id to find the available.
   * @param employeeId to get Tools.
   * @return false if the tool present in specific Employee, otherwise true.
   */
	public Boolean isToolAvailable(int toolId, int employeeId) {
		List<Tool> tools = getToolById(employeeId);
    if(tools.size() == 0)	{
			return true;
		} else {
			for(Tool tool : tools) {
				if(tool.getId() == toolId) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
   * <p>
   * It is method to find Tool id is present or not.
   * </p>
   * @param id to find the Tool id.
   * @return true if the Tool id is present, otherwise false.
   */
	public Boolean isToolIdPresent(int id) {
    return toolDAO.isToolIdPresent(id);
  }
	
	/**
   * <p>
   * It is method to get the all Tool for specific Employee.
   * </p>
	 * @param employeeId to find the Employee.
   * @return List of Tool objects if Tools are present, otherwise empty List.
   */
	public List<Tool> getToolById(int employeeId) {
    return toolDAO.fetchTool(employeeId);
  }
	
  /**
   * <p>
   * It is method to find Tool is present or not.
   * </p>
   * @param toolId to find the Tool.
	 * @param employeeId to find the Tool.
   * @return true if the Tool is present, otherwise false.
   */
  public Boolean isToolPresent(int toolId, int employeeId) {
    return toolDAO.isToolPresent(toolId, employeeId);
  }
  
  /**
   * <p>
   * It is method to remove Employee and Tool object from Mapper.
   * </p>
   * @param toolId to find the Tool.
   * @param employeeId to find the Employee.
   */ 
  public void removeTool(int toolId, int employeeId) {
		toolDAO.deleteTool(toolId, employeeId);
  }
  
  /**
   * <p>
   * It is method to get the all Tool objects.
   * </p>
   * @return List of Tool objects if Tools are present, otherwise empty List.
   */
  public List<Tool> getAllTools() {
    return toolDAO.fetchAllTools();
  }
}