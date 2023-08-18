package com.mechanics_store.auth;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class RegisterRequest {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String role;
}
