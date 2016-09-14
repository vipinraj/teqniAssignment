package org.vipin.assignments.TeqniAssignment.dao;

import java.util.List;

import org.vipin.assignments.TeqniAssignment.beans.Student;

public interface StudentDao {
	List<Student> getUnAssignedStudents();
}
