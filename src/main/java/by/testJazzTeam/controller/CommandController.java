package by.testJazzTeam.controller;

import by.testJazzTeam.entity.Commands;
import by.testJazzTeam.repo.CommandRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commands")
public class CommandController {
    private final CommandRepo commandRepo;
    @Autowired
    public CommandController(CommandRepo commandRepo) {
        this.commandRepo = commandRepo;
    }
    @GetMapping
    public List<Commands> list(){
        return commandRepo.findAll();
    }
    @GetMapping("{id}")
    public Commands getOne(@PathVariable("id") Commands command){
        return command;
    }
    @PostMapping
    public Commands create(@RequestBody Commands command){
        return commandRepo.save(command);
    }

    @PutMapping("{id}")
    public Commands update(
            @PathVariable("id") Commands commandFromDB,
            @RequestBody Commands command
    ){
        BeanUtils.copyProperties(command,commandFromDB,"id");
        return commandRepo.save(commandFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Commands command){
        commandRepo.delete(command);
    }

    @MessageMapping("/changeCommand")
    @SendTo("/topic/activity")
    public Commands change(Commands commands){
        return commandRepo.save(commands);
    }
}
