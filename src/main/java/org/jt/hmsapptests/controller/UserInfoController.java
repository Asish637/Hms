package org.jt.hmsapptests.controller;

import org.jt.hmsapptests.entity.UserInfo;
import org.jt.hmsapptests.request.AuthRequest;
import org.jt.hmsapptests.service.JwtService;
import org.jt.hmsapptests.service.UserInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserInfoController {

    private final UserInfoService userInfoService;
    private final JwtService jwtService;

    @PostMapping("/signup")
    public ResponseEntity<String>saveUser(@RequestBody UserInfo userInfo){
        String saveUser = userInfoService.saveUser(userInfo);
        return new ResponseEntity<>(saveUser,HttpStatus.CREATED);
    }

    public String authentcationgetToken(@RequestBody AuthRequest authRequest){
        return jwtService.generateToken(authRequest.getUsername());
    }
}
