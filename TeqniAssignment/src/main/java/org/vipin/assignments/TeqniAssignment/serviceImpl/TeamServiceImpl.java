package org.vipin.assignments.TeqniAssignment.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.vipin.assignments.TeqniAssignment.beans.Student;
import org.vipin.assignments.TeqniAssignment.beans.Team;
import org.vipin.assignments.TeqniAssignment.dao.StudentDao;
import org.vipin.assignments.TeqniAssignment.dao.TeamDao;
import org.vipin.assignments.TeqniAssignment.service.TeamService;

@Repository("teamService")
@Transactional
public class TeamServiceImpl implements TeamService {

	@Autowired
	TeamDao teamDao;

	@Autowired
	StudentDao studentDao;

	/*
	 * Get list of all teams
	 */
	@Override
	public List<Team> getAllTeams() {

		return teamDao.getAllTeams();
	}

	/*
	 * Update the team details according to the input
	 */
	@Override
	public void updateTeam(String teamDetails) {

		List<Integer> unassignedStudents = new ArrayList<>();
		HashMap<Integer, List<Integer>> teams = new HashMap<>();

		try {
			
			//parsing the input
			for (String teamMemberPair : teamDetails.split(";")) {

				String[] teamMemberPairArray = teamMemberPair.split("\\|");

				if (teamMemberPairArray[0].equals("allItems")) {
					unassignedStudents.add(Integer.parseInt(teamMemberPairArray[1]));
				} else {
					if (teams.containsKey(Integer.parseInt(teamMemberPairArray[0]))) {
						teams.get(Integer.parseInt(teamMemberPairArray[0]))
								.add(Integer.parseInt(teamMemberPairArray[1]));
					} else {
						List<Integer> studentList = new ArrayList<>();
						studentList.add(Integer.parseInt(teamMemberPairArray[1]));
						teams.put(Integer.parseInt(teamMemberPairArray[0]), studentList);
					}
				}
			}

			//taking care of the newly unassigned teams
			for (Integer studentId : unassignedStudents) {
				Student student = studentDao.getByKey(studentId);
				student.setIsAssigned(false);
				studentDao.update(student);
			}

			//clear existing mappings
			for (Team team : teamDao.getAllTeams()) {
				team.setMembers(new ArrayList<>());
				teamDao.merge(team);
			}

			//creating new mappings
			for (Integer teamId : teams.keySet()) {
				System.out.println("Team - " + teamId);
				Team team = teamDao.getByKey(teamId);
				List<Student> students = new ArrayList<>();
				for (Integer studentId : teams.get(teamId)) {
					Student student = studentDao.getByKey(studentId);
					student.setIsAssigned(true);
					students.add(student);
					System.out.println("Student - " + studentId);
				}
				team.setMembers(students);
				teamDao.merge(team);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
