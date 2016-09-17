package org.vipin.assignments.TeqniAssignment.dao;

import java.util.List;

import org.vipin.assignments.TeqniAssignment.beans.Student;
import org.vipin.assignments.TeqniAssignment.beans.Team;

public interface TeamDao {
	List<Team> getAllTeams();
	void update(Team team);
	void merge(Team team);
	Team getByKey(Integer teamId);
	
}
