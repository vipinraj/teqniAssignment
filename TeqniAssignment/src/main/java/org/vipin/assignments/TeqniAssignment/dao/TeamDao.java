package org.vipin.assignments.TeqniAssignment.dao;

import java.util.List;

import org.vipin.assignments.TeqniAssignment.beans.Student;
import org.vipin.assignments.TeqniAssignment.beans.Team;

public interface TeamDao {
	List<Team> getAllTeams();
	List<Student> getTeamMembers(Integer teamId);
	void updateTeam(Team team);
}
