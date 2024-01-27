package github.io.iamhariommaurya.ecart.authService.service;

import github.io.iamhariommaurya.ecart.authService.model.SignUpRequest;
import github.io.iamhariommaurya.ecart.authService.model.SignupResponse;

public interface ISignupService {
    SignupResponse addUser(SignUpRequest signUpRequest);
}
