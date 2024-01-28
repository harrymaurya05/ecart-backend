package github.io.iamhariommaurya.ecart.authService.model;

import github.io.iamhariommaurya.ecart.authService.entity.User;
import github.io.iamhariommaurya.ecart.utility.models.ServiceResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@AllArgsConstructor
public class LoginResponse extends ServiceResponse {
    private User user;
}
