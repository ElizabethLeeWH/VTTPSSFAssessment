package vttp.ssf.assessment.eventmanagement.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vttp.ssf.assessment.eventmanagement.models.Event;
import vttp.ssf.assessment.eventmanagement.repositories.RedisRepository;

@Controller
@RequestMapping("/events")
public class EventController {

	//Task 5
	@Autowired
	RedisRepository redisRepo;
	
	@GetMapping("/listing")
	public String displayEvents(Model model){
		Event e = new Event();
		model.addAttribute("events", e);
		return "view0";
	}
 

}
