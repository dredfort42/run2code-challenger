package app.sport.runApp.controllers;

import app.sport.runApp.domain.entity.RunTraining;
import app.sport.runApp.services.RunTrainingServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@Controller
public class RunTrainingController {

    private final RunTrainingServiceImpl runTrainingService;

    @GetMapping(path="/allTrainingByUserEmail/{email}")
    public @ResponseBody Iterable<RunTraining> getRunTrainingByUserEmail(@PathVariable("email") String email) {
        return runTrainingService.getRunTrainingByUserEmail(email);
    }

    @PostMapping(path="/newRunTraining")
    public @ResponseBody RunTraining addNewRunTraining(@RequestBody String msg) throws JsonProcessingException {
        ObjectMapper objectMapper = JsonMapper.builder()
                .findAndAddModules()
                .build();
        RunTraining runTraining = objectMapper.readValue(msg, RunTraining.class);
        if (runTrainingService.getRunTrainingByTimeAndUserId(runTraining) != null){
            return null;
        }
        return runTrainingService.saveRunTraining(runTraining);
    }
}
