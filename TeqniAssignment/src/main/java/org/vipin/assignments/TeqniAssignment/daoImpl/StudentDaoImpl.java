package org.vipin.assignments.TeqniAssignment.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.vipin.assignments.TeqniAssignment.beans.Student;
import org.vipin.assignments.TeqniAssignment.dao.AbstractDao;
import org.vipin.assignments.TeqniAssignment.dao.StudentDao;

@Repository("studentDao")
public class StudentDaoImpl extends AbstractDao<Integer, Student> implements StudentDao {

	@Override
	public List<Student> getUnAssignedStudents() {
		
		Criteria cr = createEntityCriteria();
		List<Student> students = null;
		
		try {
			
			cr.add(Restrictions.eq("isAssigned", false));
			students = cr.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return students;
	}
	
}
