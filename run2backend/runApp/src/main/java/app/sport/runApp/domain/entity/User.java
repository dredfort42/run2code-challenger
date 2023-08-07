package app.sport.runApp.domain.entity;

import com.sun.istack.internal.NotNull;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotEmpty(message = "{errors.incorrect.email}")
//    @Email
//    @ValidEmail(message = "{errors.double.email}")
//    @NotNull
    @Column(name="email")
    private String email;

//    @ValidPassword(message = "{errors.incorrect.password}")
//    @NotNull
    @Column(name = "password")
    private String password;
}
