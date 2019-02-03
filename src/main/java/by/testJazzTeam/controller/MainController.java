package by.testJazzTeam.controller;

import by.testJazzTeam.entity.User;
import by.testJazzTeam.repo.CommandRepo;
import by.testJazzTeam.repo.RobotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("/")
public class MainController {
    private final CommandRepo commandRepo;
    private final RobotRepo robotRepo;

    @Value("dev")
    private String profile;

    @Autowired
    public MainController(CommandRepo commandRepo,RobotRepo robotRepo) {
        this.commandRepo = commandRepo;
        this.robotRepo = robotRepo;
    }

    @GetMapping
    public String main(Model model, @AuthenticationPrincipal User user){
        HashMap<Object,Object> data = new HashMap<>();

        data.put("profile",user);
        data.put("commands",commandRepo.findAll());
        data.put("robots",robotRepo.findAll());
//        data.put("robots",null);

        model.addAttribute("frontendData",data);
        model.addAttribute("isDevMode","dev".equals(profile));
        return "main";
    }
}
