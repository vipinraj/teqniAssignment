package org.vipin.assignments.TeqniAssignment.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;
import org.vipin.assignments.TeqniAssignment.beans.Team;
import org.vipin.assignments.TeqniAssignment.dao.AbstractDao;
import org.vipin.assignments.TeqniAssignment.dao.TeamDao;

@Repository("teamDao")
public class TeamDaoImpl extends AbstractDao<Integer, Team> implements TeamDao {

	@Override
	public List<Team> getAllTeams() {
		Criteria cr = createEntityCriteria();
		List<Team> teams = null;

		try {

			cr.addOrder(Order.asc("teamName"));
			teams = cr.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return teams;
	}

}
