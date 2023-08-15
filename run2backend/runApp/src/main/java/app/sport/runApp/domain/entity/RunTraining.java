package app.sport.runApp.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "run_training")
public class RunTraining {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "distance")
    private double distance;

    @Column(name = "elapsed_time")
    private long elapsed_time;

    @Column(name = "begin_date_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime beginDateTime;
}
