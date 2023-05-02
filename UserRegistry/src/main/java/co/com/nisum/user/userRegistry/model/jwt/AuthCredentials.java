package co.com.nisum.user.userRegistry.model.jwt;

import lombok.Data;

@Data
public class AuthCredentials {
    private String email;
    private String password;
}
