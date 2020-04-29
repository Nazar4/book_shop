package com.test.mvc.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service(value = "testUserDetailsService")
public class TestUserDetailsService implements UserDetailsService {

    
    public UserDetails loadUserByUsername(final String arg0) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

}
