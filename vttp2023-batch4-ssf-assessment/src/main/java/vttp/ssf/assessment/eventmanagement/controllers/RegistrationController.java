package vttp.ssf.assessment.eventmanagement.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/events")
public class RegistrationController {
    
    // TODO: Task 6

    @GetMapping("/register")
    public String employeeList(Model model) {
        List<Register> employees = empRepo.findAll();

        model.addAttribute("", employees);

        return "eventregister";

    }
    // TODO: Task 7
}
