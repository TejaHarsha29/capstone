package com.capstone.loanapp.controller;

import com.capstone.loanapp.Security.JwtTokenProvider;
import com.capstone.loanapp.dto.JWTAuthResponse;
import com.capstone.loanapp.dto.LoginDto;
import com.capstone.loanapp.dto.UserDto;
import com.capstone.loanapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loan/api/auth")
public class UserAuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider1;


    @PostMapping("/register")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);

    }

    @GetMapping("/users")
    public String getUsers() {
        return "Harsha";
    }


    @PostMapping("/login")
    public ResponseEntity<JWTAuthResponse> loginUser(@RequestBody LoginDto loginDto) {
        System.out.println("error");


        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getEmail(), loginDto.getPassword()));
        System.out.println("error");


        SecurityContextHolder.getContext().setAuthentication(authentication);

        System.out.println("error");


            String token = jwtTokenProvider1.generateToken(authentication);
            System.out.println(token);


        System.out.println("error");

        return ResponseEntity.ok(new JWTAuthResponse(token));
    }

}
