package org.vipin.assignments.TeqniAssignment.beans;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="teams")
public class Team {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="team_id")
	private Integer teamId;
	
	@Column(name="team_name", nullable=false)
	private String teamName;
	
	@Column(name="team_size")
	private Integer maximumMembers;
	
	@OneToMany(mappedBy="memberOf", cascade = CascadeType.ALL)
	private Collection<Student> members;

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Collection<Student> getMembers() {
		return members;
	}

	public void setMembers(Collection<Student> members) {
		this.members = members;
	}

	public Integer getMaximumMembers() {
		return maximumMembers;
	}

	public void setMaximumMembers(Integer maximumMembers) {
		this.maximumMembers = maximumMembers;
	}
	
	
}
