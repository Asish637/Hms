package org.jt.hmsapptests.service;

import org.jt.hmsapptests.entity.UserInfo;
import org.jt.hmsapptests.repository.UserInfoRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserInfoService {

    private final UserInfoRepository userInfoRepository;
    private final PasswordEncoder passwordEncoder;
    
    public String saveUser(UserInfo userInfo){
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfoRepository.save(userInfo);
        return "User save Successfully";
    }
    
}
