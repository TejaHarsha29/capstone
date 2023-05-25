package com.capstone.loanapp.Security;

import com.capstone.loanapp.exception.UserNotFound;
import com.capstone.loanapp.model.Users;
import com.capstone.loanapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepository.findByEmail(username).orElseThrow(
                ()->new UserNotFound("User not found")
        );
        Set<String> roles = new HashSet<>();
        roles.add("ROLE_ADMIN");
        return new User(users.getEmail(),users.getPassword(),userAuthorities(roles));
    }


    private Collection<? extends GrantedAuthority> userAuthorities(Set<String> roles){
        return roles.stream().map(
                role -> new SimpleGrantedAuthority(role)
        ).collect(Collectors.toList());
    }


}
