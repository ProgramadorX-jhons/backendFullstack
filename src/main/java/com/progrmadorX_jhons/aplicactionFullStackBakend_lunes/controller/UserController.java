package com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.controller;

import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.model.User;
import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<User> findUserByJwtToken(@RequestHeader("Authorization")String Jwt) throws Exception {
        User user=userService.findUserByJwtToken(Jwt);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
}
