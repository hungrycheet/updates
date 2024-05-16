package com.example.TaskManagement.service;

import com.example.TaskManagement.Repository.UserInfoRepository;
import com.example.TaskManagement.entity.UserInfo;
import com.example.TaskManagement.entity.UserInfoUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserInfoRepository userrepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userinfo = userrepo.findByUsername(username);

        return  userinfo.map(UserInfoUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("not found"));
    }
}
