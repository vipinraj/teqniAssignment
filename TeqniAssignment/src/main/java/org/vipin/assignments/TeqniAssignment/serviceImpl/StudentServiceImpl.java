package org.vipin.assignments.TeqniAssignment.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vipin.assignments.TeqniAssignment.beans.Student;
import org.vipin.assignments.TeqniAssignment.dao.StudentDao;
import org.vipin.assignments.TeqniAssignment.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentDao studentDao;
	
	/* 
	 * Get list of all students who are not assigned to any team
	 */
	@Override
	public List<Student> getUnAssignedStudents() {
		// TODO Auto-generated method stub
		return studentDao.getUnAssignedStudents();
	}

}
