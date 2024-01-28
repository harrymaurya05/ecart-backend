package github.io.iamhariommaurya.ecart.authService.service;

import github.io.iamhariommaurya.ecart.authService.model.LoginRequest;
import github.io.iamhariommaurya.ecart.authService.model.LoginResponse;

public interface ILoginService {
    LoginResponse validateLogin(LoginRequest loginRequest);
}
