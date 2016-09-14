package org.vipin.assignments.TeqniAssignment.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;
import org.vipin.assignments.TeqniAssignment.beans.Student;
import org.vipin.assignments.TeqniAssignment.beans.Team;
import org.vipin.assignments.TeqniAssignment.dao.AbstractDao;
import org.vipin.assignments.TeqniAssignment.dao.TeamDao;


@Repository("teamDao")
public class TeamDaoImpl extends AbstractDao<Integer, Team> implements TeamDao {

	@Override
	public List<Team> getAllTeams() {
		Criteria cr = createEntityCriteria();
		cr.addOrder(Order.asc("teamName"));
		return cr.list();
	}

	@Override
	public List<Student> getTeamMembers(Integer teamId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateTeam(Team team) {
		// TODO Auto-generated method stub
		
	}

}
