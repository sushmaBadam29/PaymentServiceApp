package com.project.paymentapp.UserService.Entities;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserCreatedResponse {
    private String username;
    private String email;
}
