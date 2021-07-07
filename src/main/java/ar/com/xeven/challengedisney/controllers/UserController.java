package ar.com.xeven.challengedisney.controllers;

import ar.com.xeven.challengedisney.entities.User;
import ar.com.xeven.challengedisney.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/auth/register")
    public String register(@RequestBody User user){
        return userService.save(user);
    }

    @PostMapping("/auth/login")
    public String login(@RequestParam String email, @RequestParam String token){
        return userService.login(email, token);
    }
}
