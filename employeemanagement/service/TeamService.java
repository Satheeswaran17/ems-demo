package employeemanagement.service;

import java.util.ArrayList;
import java.util.List;

import employeemanagement.dao.TeamDAO;
import employeemanagement.model.Team;
import employeemanagement.model.Employee;
import employeemanagement.service.EmployeeService;

/**
 * <p>
 * It is Service class to Team - related operations.
 * </p>
 */
public class TeamService {
  private TeamDAO teamDAO = new TeamDAO();
  private EmployeeService employeeService = new EmployeeService();
  
  /**
   * <p>
   * It is method to create and pass the Team.
   * </p>
   * @param domain is denotes the Team domain.
   * @param employeeCount is denotes the Team employee count.
   * @param employeeId to brand the Employee object with Laptop object.
   * @return inserted Team object.
   */
  public Team addTeam(String domain, int employeeCount, int employeeId) {
    Team team = new Team(domain, employeeCount);
    teamDAO.insertTeam(team);
		employeeService.setTeamId(team.getId(), employeeId);
    return team;
  }
  
	/**
   * <p>
   * It is method to insert Employee with Team.
   * </p>
   * @param id to store the Team.
   * @param employeeId to bind the Employee with Team.
   * @return inserted Team object.
   */
	public Team addTeamById(int id, int employeeId) {
		employeeService.setTeamId(id, employeeId);
    return getTeamById(employeeId);
  }
	
	/**
   * <p>
   * It is method to insert Team id into Employee.
   * </p>
   * @param id to store the Team id.
   * @param employeeId to bind the Employee with Laptop.
   */
	public void setTeamId(int id, int employeeId) {
		employeeService.setTeamId(id, employeeId);
	}
  
  /**
   * <p>
   * It is method to find Team is present or not.
   * </p>
   * @param id to find the Team id.
   * @return true if the Team is present, otherwise false.
   */
  public Boolean isTeamPresent(int id) {
    return teamDAO.isTeamPresent(id);
  }
  
	/**
   * <p>
   * It is method to get the Team.
   * </p>
	 * @param employeeId to find the Team id.
   * @return Team objects if Teams are present, otherwise null.
   */
	public Team getTeamById(int employeeId) {
		int id = employeeService.getTeamId(employeeId);
		if(id == -1) {
			return null;
		}
    return teamDAO.fetchTeam(id);
  }
  
  /**
   * <p>
   * It is method to get the all Team objects.
   * </p>
   * @return List of Team objects if Teams are present, otherwise empty List.
   */
  public List<Team> getAllTeams() {
    return teamDAO.fetchAllTeams();
  }
}