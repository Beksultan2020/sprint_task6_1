package kz.bitlab.SPRING_SPRINT_TASK_2.Controller;


import jakarta.websocket.server.PathParam;
import kz.bitlab.SPRING_SPRINT_TASK_2.model.ApplicationRequest;
import kz.bitlab.SPRING_SPRINT_TASK_2.repositories.ApplicationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ApplicationRequestRepository ARRepository;

    @GetMapping("/")
    public String homePage(Model model) {
        List<ApplicationRequest> applications = ARRepository.findAll();
        model.addAttribute("applications", applications);
        return "home";
    }

    @GetMapping(value = "/add_applications")
    public String addPage(){
        return "addApplication";
    }

    @PostMapping(value = "/add_applications")
    public String addPage(ApplicationRequest applicationRequest) {
        ARRepository.save(applicationRequest);
        return "redirect:/";
    }

    @GetMapping(value = "/applicationsDetails/{id}")
    public String detailsPage(@PathVariable(name = "id") Long id, Model model) {
        ApplicationRequest applicationRequest = ARRepository.findById(id).orElse(null);
        model.addAttribute("details", applicationRequest);
        return "details";
    }

    @PostMapping(value = "/updateApp")
    public String updateApp(@RequestParam(name="id")Long id){
        ApplicationRequest applicationRequest=ARRepository.findById(id).orElseThrow();
        applicationRequest.setHandled(true);
        ARRepository.save(applicationRequest);
        return "redirect:/";
    }

    @PostMapping(value = "/deleteApp")
    public String deleteApp(@RequestParam(name = "id")Long id){
        ApplicationRequest applicationRequest=ARRepository.findById(id).orElseThrow();
        ARRepository.delete(applicationRequest);
        return "redirect:/";
    }

    @GetMapping(value = "/newApp")
    public String getFalseHandled(Model model){
        model.addAttribute("applications",ARRepository.findByHandledIsFalse());
        return "home";
    }

    @GetMapping(value = "/handledApp")
    public String getTrueHandled(Model model){
        model.addAttribute("applications",ARRepository.findByHandledIsTrue());
        return "home";
    }
}
