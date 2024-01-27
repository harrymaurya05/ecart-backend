package github.io.iamhariommaurya.ecart.authService.model;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    private String username;
    private String password;

}
