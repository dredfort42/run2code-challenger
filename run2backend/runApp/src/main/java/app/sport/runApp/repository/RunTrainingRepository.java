package app.sport.runApp.repository;

import app.sport.runApp.domain.entity.RunTraining;
import app.sport.runApp.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Repository
@Transactional
public interface RunTrainingRepository extends JpaRepository<RunTraining, Long> {
    RunTraining findRunTrainingByBeginDateTimeAndUser_id(LocalDateTime beginDateTime, Long userId);

    Iterable<RunTraining> findAllRunTrainingByUserEmail(String email);
}
