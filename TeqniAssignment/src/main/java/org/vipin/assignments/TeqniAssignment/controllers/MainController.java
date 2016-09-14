package org.vipin.assignments.TeqniAssignment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.vipin.assignments.TeqniAssignment.service.StudentService;
import org.vipin.assignments.TeqniAssignment.service.TeamService;

@Controller
public class MainController {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	TeamService teamService;
	
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home(ModelMap model) {
		
		model.addAttribute("unAssignedStudents", studentService.getUnAssignedStudents());
		model.addAttribute("teams", teamService.getAllTeams());
		return "home";
	}
}
