package org.jt.hmsapptests.config;

import java.util.Collection;

import org.jt.hmsapptests.entity.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CostumUserDetails implements UserDetails{

    private String name;
    private String password;
    public CostumUserDetails(UserInfo userInfo){
        name=userInfo.getName();
        password=userInfo.getPassword();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
       return true;
    }

    @Override
    public boolean isAccountNonLocked() {
       return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
