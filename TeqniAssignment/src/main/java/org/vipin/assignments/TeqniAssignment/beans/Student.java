package org.vipin.assignments.TeqniAssignment.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private Integer studentId;

	@Column(name = "student_name", nullable = false)
	private String studentName;
	
	@Column(name="is_assigned", nullable=false)
	private Boolean isAssigned;
	
	@ManyToOne
	@JoinColumn(name="member_of")
	private Team memberOf;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Boolean getIsAssigned() {
		return isAssigned;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAssigned = isAvailable;
	}

	public Team getMemberOf() {
		return memberOf;
	}

	public void setMemberOf(Team memberOf) {
		this.memberOf = memberOf;
	}
	
}
