package tech.strategio.skfinalproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tech.strategio.skfinalproject.models.User;
import tech.strategio.skfinalproject.repositories.UserRepository;
import tech.strategio.skfinalproject.services.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/login")
public class LoginController {

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> login(){
        return userService.getAllUsers();
    }

    @PostMapping("/new-login")
    public List loginUser (@RequestBody Map body){
        User user = userService.getUserByUsername(body.get("username").toString());
        List response = new ArrayList();
        System.out.println(user);
        if(user.getUsername().equals("") || user == null){
            response.add("Invalid username");
            return response;
        }
        if(!encoder.matches(body.get("password").toString(), user.getPassword())){
            response.add("Invalid password");
        }
        else{
            response.add(HttpStatus.OK);
            response.add(user.getId());
            response.add(user.getUsername());
        }
        return response;
    }

    @PostMapping("/new-user")
    public HttpStatus createNewUser(@RequestBody Map body){
        System.out.println(body);
        if(userService.getUserByUsername(body.get("username").toString()) != null){
            return HttpStatus.CONFLICT;
        }
        else {
            User user = new User(body.get("username").toString(), encoder.encode(body.get("password").toString()), body.get("email").toString());
            userService.addUser(user);
            return HttpStatus.CREATED;
        }
    }



}
