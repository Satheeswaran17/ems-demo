package employeemanagement.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import employeemanagement.jdbcconnection.JdbcConnector;
import employeemanagement.model.Team;

/**
 * <p>
 * It is class to access, insert, update and delete the Team in database.
 * </p>
 */
public class TeamDAO {
  
  /**
   * <p>
   * It is method to insert Team into database.
   * </p>
   * @param team to store the Team.
   */
  public void insertTeam(Team team) {
		try(PreparedStatement preparedStatement = JdbcConnector.getConnection().prepareStatement("insert into team" + 
		"(domain, employee_count) values(?,?)", Statement.RETURN_GENERATED_KEYS)) {
			preparedStatement.setString(1, team.getDomain());
			preparedStatement.setInt(2, team.getEmployeesCount());
			preparedStatement.executeUpdate();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			team.setId(resultSet.getInt(1));
		} catch(Exception e) {
			System.out.println(e);
		}
  }
  
  /**
   * <p>
   * It is method to find Team is present or not.
   * </p>
   * @param id to find the Team.
   * @return true if the Team is present, otherwise false.
   */
  public Boolean isTeamPresent(int id) {
    try(Statement statement = JdbcConnector.getConnection().createStatement()) {
			ResultSet resultSet = statement.executeQuery("select * from team where id = " + id );
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
   * It is method to get the Team from database.
   * </p>
   * @param id to find and get Team .
   * @return Team object if Team is present in database, otherwise null.
   */
  public Team fetchTeam(int id) {
		try(Statement statement = JdbcConnector.getConnection().createStatement()) {
			ResultSet resultSet = statement.executeQuery("select * from team where id = " + id );
		  if(resultSet.next()) {
			  Team team = new Team(resultSet.getString(2), resultSet.getInt(3));
		  	team.setId(resultSet.getInt(1));
			  return team;
			}
			else {
				return null;
			}
		} catch(Exception e) {
			System.out.println(e);
		}
    return null;
  }
  
  /**
   * <p>
   * It is method to get the all Team from database.
   * </p>
   * @return List of Team objects if Teams are present in database, otherwise empty List.
   */
  public List<Team> fetchAllTeams() {
    List<Team> teams = new ArrayList<>();
		try(Statement statement = JdbcConnector.getConnection().createStatement()) {
			ResultSet resultSet = statement.executeQuery("select * from team");
			while(resultSet.next()) {
			  Team team = new Team(resultSet.getString(2), resultSet.getInt(3));
		  	team.setId(resultSet.getInt(1));
				teams.add(team);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
    return teams;
  }
}