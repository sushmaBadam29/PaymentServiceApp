package com.project.paymentapp.UserService.manager;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.paymentapp.UserService.Entities.User;
import com.project.paymentapp.UserService.Entities.UserCreatedResponse;
import com.project.paymentapp.UserService.Entities.UserResponse;
import com.project.paymentapp.UserService.Entities.UserServiceRequest;
import com.project.paymentapp.UserService.MyPassWordEncoder;
import com.project.paymentapp.UserService.repo.UserRepo;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@Qualifier("service1")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    @Autowired
    private MyPassWordEncoder myPassWordEncoder;

    private ObjectMapper objectMapper=new ObjectMapper();
    @SneakyThrows
    @Override
    public void create(UserServiceRequest userServiceRequest) {
        User user = User.builder()
                .password(myPassWordEncoder.getPasswordEncoder().encode(userServiceRequest.getPassword()))
                .username(userServiceRequest.getUsername())
                .email(userServiceRequest.getEmail())
                .build();
        UserCreatedResponse userCreatedResponse = UserCreatedResponse.builder()
                .email(user.getEmail())
                .username(user.getUsername())
                .build();
        userRepo.save(user);
        kafkaTemplate.send("userTopic", objectMapper.writeValueAsString(userCreatedResponse));

    }

    @Override
    public UserResponse get(String username) {
       User user = userRepo.findByUsername(username).orElseThrow(()->
                new UsernameNotFoundException("username not found") );

        UserResponse userResponse = UserResponse.builder()
                .email(user.getEmail())
                .username(user.getUsername())
                .password(user.getPassword())
                .build();

        return userResponse;
    }
}
