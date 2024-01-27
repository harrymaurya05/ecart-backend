package github.io.iamhariommaurya.ecart.authService.model;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {
    private String username;
    private String email;
    private String password;

}
