package tech.strategio.skfinalproject.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/")
public class HealthCheckController {
    @RequestMapping("/")
    public int healthCheck() {
        return HttpStatus.OK.value();
    }
}
