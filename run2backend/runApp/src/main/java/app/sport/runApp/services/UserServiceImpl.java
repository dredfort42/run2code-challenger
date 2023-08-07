package app.sport.runApp.services;

import app.sport.runApp.domain.entity.User;
import app.sport.runApp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl {
    private final UserRepository userRepository;

    public Iterable<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public User findUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

}
