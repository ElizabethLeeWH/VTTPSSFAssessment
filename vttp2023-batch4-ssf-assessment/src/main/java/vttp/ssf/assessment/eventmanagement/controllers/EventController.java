package vttp.ssf.assessment.eventmanagement.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;
import vttp.ssf.assessment.eventmanagement.models.Event;
import vttp.ssf.assessment.eventmanagement.repositories.RedisRepository;
import vttp.ssf.assessment.eventmanagement.services.DatabaseService;

@Controller
@RequestMapping("/events")
public class EventController {

	//Task 5
	@Autowired
	RedisRepository redisRepo;
	
	@GetMapping("/listing")
	public String displayEvents(HttpSession session, Model model){
		List<Event> events = (List<Event>) session.getAttribute("events");
		model.addAttribute("events", events);
		return "view0";
	}

}
