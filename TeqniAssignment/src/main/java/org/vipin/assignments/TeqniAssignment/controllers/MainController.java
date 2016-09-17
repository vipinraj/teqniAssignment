package org.vipin.assignments.TeqniAssignment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.POST)
	public String homePost(ModelMap model, @RequestParam("listOfItems") String listOfItems) {
		System.out.println(listOfItems);
		teamService.updateTeam(listOfItems);
		model.addAttribute("unAssignedStudents", studentService.getUnAssignedStudents());
		model.addAttribute("teams", teamService.getAllTeams());
		return "home";
	}
}
