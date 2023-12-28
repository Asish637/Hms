package org.jt.hmsapptests.repository;

import java.util.Optional;

import org.jt.hmsapptests.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserInfoRepository  extends JpaRepository<UserInfo, Integer>{

    Optional<UserInfo> findByName(String name);
    
}