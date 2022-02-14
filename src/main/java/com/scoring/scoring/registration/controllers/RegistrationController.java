package com.scoring.scoring.registration.controllers;


import com.scoring.scoring.registration.domain.EncodePassword;
import com.scoring.scoring.registration.domain.User;
import com.scoring.scoring.registration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RegistrationController {

    @Autowired
    private UserService userService;
    @Autowired
    private EncodePassword encodePassword;


    @PostMapping("/registration")
    public User processRegistration(@RequestBody User user) {
        String enPassword = encodePassword.encodePassword(user.getPassword());
        user.setPassword(enPassword);
      return userService.create(user);

    }

}


