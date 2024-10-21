package employeemanagement.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import employeemanagement.jdbcconnection.JdbcConnector;
import employeemanagement.model.Tool;

/**
 * <p>
 * It is class to access, insert, update and delete the Tool in database.
 * </p>
 */
public class ToolDAO {
  
  /**
   * <p>
   * It is method to insert Tool into database.
   * </p>
   * @param tool to store the Tool.
	 * @param employeeId to bind the Employee with Tool
   */
  public void insertTool(Tool tool) {
		try(PreparedStatement preparedStatement = JdbcConnector.getConnection().prepareStatement("insert into tool" + 
		"(name, version, type) values(?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
			preparedStatement.setString(1, tool.getName());
			preparedStatement.setString(2, tool.getVersion());
			preparedStatement.setString(3, tool.getType());
			preparedStatement.executeUpdate();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			tool.setId(resultSet.getInt(1));
		} catch(Exception e) {
			System.out.println(e);
		}
  }
  
	/**
   * <p>
   * It is method to insert Tool and Employee into mapper database.
   * </p>
   * @param toolId to store the Tool.
	 * @param employeeId to bind the Employee with Tool
   */
	public Tool insertToolById(int toolId, int employeeId) {
		try(PreparedStatement preparedStatement = JdbcConnector.getConnection().prepareStatement("insert into " + 
		"employee_tool_mapper(employee_id, tool_id) values(?,?)")) {
			preparedStatement.setInt(1, employeeId);
			preparedStatement.setInt(2, toolId);
			preparedStatement.executeUpdate();
		  Statement statement = JdbcConnector.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery("select * from tool where id = " + toolId);
			resultSet.next();
			Tool tool = new Tool(resultSet.getString(2), resultSet.getString(3), 
	  	resultSet.getString(4));
			tool.setId(resultSet.getInt(1));
			statement.close();
			return tool;
		} catch(Exception e) {
			System.out.println(e);
		}
    return null;
  }
	
	/**
   * <p>
   * It is method to find Tool is present or not in Tool database.
   * </p>
   * @param id to find the Tool.
   * @return true if the Tool is present, otherwise false.
   */
	public Boolean isToolIdPresent(int id) {
    try(Statement statement = JdbcConnector.getConnection().createStatement()) {
			ResultSet resultSet = statement.executeQuery("select * from tool where id = " + id );
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
   * It is method to find Tool is present or not in mapper database.
   * </p>
   * @param toolId to find the Tool.
	 * @param employeeId to find the Tool.
   * @return true if the Tool is present, otherwise false.
   */
  public Boolean isToolPresent(int toolId, int employeeId) {
		try(Statement statement = JdbcConnector.getConnection().createStatement()) {
			ResultSet resultSet = statement.executeQuery("select * from employee_tool_mapper where tool_id = "
			+ toolId + " and employee_id = " + employeeId);
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
   * It is method to delete Tool from database.
   * </p>
   * @param toolId to find the Tool.
	 * @param employeeId to find the Tool.
   * @return deleted Tool if the Tool is deleted, otherwise null.
   */  
  public void deleteTool(int toolId, int employeeId) {
		try(Statement statement = JdbcConnector.getConnection().createStatement()) {
			statement.executeUpdate("delete from employee_tool_mapper where tool_id = " + toolId + " and employee_id = " + 
			employeeId);
		} catch(Exception e) {
			System.out.println(e);
		}
  }
  
  /**
   * <p>
   * It is method to get the Tool objects for specific mployee from database.
   * </p>
   * @param employeeId to find and get Tools.
   * @return List of Tool objects if Tool is present in database, otherwise empty List.
   */
  public List<Tool> fetchTool(int employeeId) {
		List<Tool> tools = new ArrayList<>();
		try(Statement statement = JdbcConnector.getConnection().createStatement()) {
			ResultSet resultSet = statement.executeQuery("select * from tool where id in (select tool_id from " + 
			"employee_tool_mapper where employee_id = " + employeeId + ")" );
		  while(resultSet.next()) {
			  Tool tool = new Tool(resultSet.getString(2), resultSet.getString(3), 
	  		resultSet.getString(4));
		  	tool.setId(resultSet.getInt(1));
				tools.add(tool);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
    return tools;
  }
  
  /**
   * <p>
   * It is method to get the all Tool from database.
   * </p>
   * @return List of Tool objects if Tools are present in database, otherwise empty List.
   */
  public List<Tool> fetchAllTools() {
    List<Tool> tools = new ArrayList<>();
		try(Statement statement = JdbcConnector.getConnection().createStatement()) {
			ResultSet resultSet = statement.executeQuery("select * from tool");
			while(resultSet.next()) {
			  Tool tool = new Tool(resultSet.getString(2), resultSet.getString(3), 
	  		resultSet.getString(4));
		  	tool.setId(resultSet.getInt(1));
				tools.add(tool);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
    return tools;
  }
}