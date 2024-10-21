package employeemanagement.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import employeemanagement.model.Employee;
import employeemanagement.model.Team;
import employeemanagement.service.TeamService;

/**
 * <p>
 * It is class to manage the team details.
 * </p>
 */
public class TeamController {
  Scanner scanner = new Scanner(System.in);
  private TeamService teamService = new TeamService();
  
  /**
   * <p>
   * It is method to get Team details from user and pass the Team details or add existing Team.
   * </p>
   * @param employeeId to bind the Employee with Team.
   */
  public void addTeam(int employeeId) {
    System.out.println("Enter 1 for add into existing team");
    System.out.println("Enter 2 for add new team");
    int userChoice = scanner.nextInt();
	  scanner.nextLine();
    switch(userChoice) {
      case 1:
	      System.out.println("Teams: \n");
		    getAllTeams();
        System.out.println("Enter Team id");
        int id = scanner.nextInt();
				scanner.nextLine();
        if(teamService.isTeamPresent(id)) {
          System.out.println("Successfully added");
          System.out.println(teamService.addTeamById(id, employeeId) + "\n"); 
        } else {
          System.out.println("Team id is not present");
	     	}
        break;
      case 2:
        System.out.println("Enter Team domain");
        String domain = scanner.nextLine();
        System.out.println("Enter Team Employee count");
        int employeeCount = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Successfully added");
        System.out.println(teamService.addTeam(domain, employeeCount, employeeId) + "\n"); 
        break;
    }
  }
  
	/**
   * <p>
   * It is method to get Team details and print the all details of Team.
   * </p>
   * @param employeeId to find Team.
   */
	public void getTeamDetails(int employeeId) {
		Team team = teamService.getTeamById(employeeId);
		if(team == null) {
      System.out.println("No Team found");
    } else {
      System.out.print(team);
		}
	}
	
  /**
   * <p>
   * It is method to get all Team object and print the all Team details.
   * </p>
   */
  public void getAllTeams() {
    List<Team> teams = teamService.getAllTeams();
    if(teams.size() == 0) {
      System.out.println("No Team present");
    } else {
      for(Team team : teams) {
        System.out.println(team);
      }
    }
  }
}