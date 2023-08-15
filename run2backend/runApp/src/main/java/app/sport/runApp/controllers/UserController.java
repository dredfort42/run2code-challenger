package app.sport.runApp.controllers;

import app.sport.runApp.domain.entity.User;
import app.sport.runApp.services.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping(path="/users")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping(path="/userById/{id}")
    public @ResponseBody User getUserById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @GetMapping(path="/userByEmail/{email}")
    public @ResponseBody User getUserByEmail(@PathVariable("email") String email) {
        return userService.findUserByEmail(email);
    }

    @PostMapping(path="/newUser")
    public @ResponseBody User addNewUser(@RequestBody String msg) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(msg, User.class);
        if (userService.findUserByEmail(user.getEmail()) != null){
            return null;
        }
        return userService.saveUser(user);
    }

    @PostMapping(path="/setNewPassword")
    public @ResponseBody User setNewPassword(@RequestBody String msg) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(msg, User.class);
        User existUser = userService.findUserByEmail(user.getEmail());
        if (existUser == null){
            return null;
        }
        existUser.setPassword(user.getPassword());
        return userService.saveUser(existUser);
    }

}
