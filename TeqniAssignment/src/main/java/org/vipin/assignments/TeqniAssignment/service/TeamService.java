package org.vipin.assignments.TeqniAssignment.service;

import java.util.List;

import org.vipin.assignments.TeqniAssignment.beans.Student;
import org.vipin.assignments.TeqniAssignment.beans.Team;

public interface TeamService {
	List<Team> getAllTeams();
	List<Student> getTeamMembers(Integer teamId);
	void updateTeam(String teamDetails);
}
