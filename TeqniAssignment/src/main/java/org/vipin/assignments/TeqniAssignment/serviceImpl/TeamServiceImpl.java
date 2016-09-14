package org.vipin.assignments.TeqniAssignment.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.vipin.assignments.TeqniAssignment.beans.Student;
import org.vipin.assignments.TeqniAssignment.beans.Team;
import org.vipin.assignments.TeqniAssignment.dao.TeamDao;
import org.vipin.assignments.TeqniAssignment.service.TeamService;

@Repository("teamService")
@Transactional
public class TeamServiceImpl implements TeamService{

	
	@Autowired
	TeamDao teamDao;
	
	/* 
	 * Get list of all teams
	 */
	@Override
	public List<Team> getAllTeams() {
		
		return teamDao.getAllTeams();
	}

	@Override
	public List<Student> getTeamMembers(Integer teamId) {
		
		
		return null;
	}

	@Override
	public void updateTeam(String teamDetails) {
		// TODO Auto-generated method stub
		
	}
	
}
