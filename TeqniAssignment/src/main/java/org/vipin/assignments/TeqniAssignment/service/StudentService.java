package org.vipin.assignments.TeqniAssignment.service;

import java.util.List;

import org.vipin.assignments.TeqniAssignment.beans.Student;

public interface StudentService {
	List<Student> getUnAssignedStudents();
}
