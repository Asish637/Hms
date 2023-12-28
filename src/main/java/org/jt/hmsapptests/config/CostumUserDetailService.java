package org.jt.hmsapptests.config;

import java.util.Optional;

import org.jt.hmsapptests.entity.UserInfo;
import org.jt.hmsapptests.repository.UserInfoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Component
public class CostumUserDetailService implements UserDetailsService {
    
    private final UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<UserInfo> userName = userInfoRepository.findByName(username);
       return userName.map(CostumUserDetails:: new).orElseThrow(()->new UsernameNotFoundException("User Not Found"+username));
    }
}
