package app.sport.runApp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
public class HealthCheckController {

    @GetMapping(path="/check")
    public @ResponseBody String check() {
        return "Ok";
    }
}
