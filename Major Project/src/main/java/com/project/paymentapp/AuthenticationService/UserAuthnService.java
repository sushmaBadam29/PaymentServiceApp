package com.project.paymentapp.AuthenticationService;

import com.project.paymentapp.UserService.Entities.User;
import com.project.paymentapp.UserService.Entities.UserResponse;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class UserAuthnService implements UserDetailsService {
    @Autowired
    RestTemplate restTemplate ;
    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserResponse userResponse = restTemplate.getForObject(new URI("http://localhost:8080/user/"+username)
        ,UserResponse.class);
        User user = User.builder()
                .username(userResponse.getUsername())
                .password(userResponse.getPassword())
                .email(userResponse.getEmail())
                .build();
        return user;
    }
}
