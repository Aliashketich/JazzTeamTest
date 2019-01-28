package by.testJazzTeam.controller;

import by.testJazzTeam.entity.Robots;
import by.testJazzTeam.repo.RobotRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/robots")
public class RobotController {
    private final RobotRepo robotRepo;

    @Autowired
    public RobotController(RobotRepo robotRepo) {
        this.robotRepo = robotRepo;
    }

    @GetMapping
    public List<Robots> list(){
        return robotRepo.findAll();
    }
    @GetMapping("{id}")
    public Robots getOne(@PathVariable("id") Robots robot){
        return robot;
    }

    @PostMapping
    public Robots create(@RequestBody Robots robot){
        return robotRepo.save(robot);
    }

    @PutMapping("{id}")
    public Robots update(
            @PathVariable("id") Robots robotFromDB,
            @RequestBody Robots robot
    ){
        BeanUtils.copyProperties(robot,robotFromDB,"id");
        return robotRepo.save(robotFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Robots robot){
        robotRepo.delete(robot);
    }
}
