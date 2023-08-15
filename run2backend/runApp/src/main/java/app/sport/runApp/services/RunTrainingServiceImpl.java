package app.sport.runApp.services;

import app.sport.runApp.domain.entity.RunTraining;
import app.sport.runApp.repository.RunTrainingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RunTrainingServiceImpl {
    private final RunTrainingRepository runTrainingRepository;

    public RunTraining saveRunTraining(RunTraining runTraining){
        return runTrainingRepository.saveAndFlush(runTraining);
    }

    public RunTraining getRunTrainingByTimeAndUserId(RunTraining runTraining){
        return runTrainingRepository.findRunTrainingByBeginDateTimeAndUser_id(runTraining.getBeginDateTime(), runTraining.getUser().getId());
    }

    public Iterable<RunTraining> getRunTrainingByUserEmail(String email){
        return runTrainingRepository.findAllRunTrainingByUserEmail(email);
    }
}
