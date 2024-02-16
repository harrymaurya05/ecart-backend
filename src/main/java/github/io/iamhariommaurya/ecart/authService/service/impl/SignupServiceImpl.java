package github.io.iamhariommaurya.ecart.authService.service.impl;

import github.io.iamhariommaurya.ecart.authService.entity.User;
import github.io.iamhariommaurya.ecart.authService.model.SignUpRequest;
import github.io.iamhariommaurya.ecart.authService.model.SignupResponse;
import github.io.iamhariommaurya.ecart.authService.repository.UserRepository;
import github.io.iamhariommaurya.ecart.authService.service.ISignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignupServiceImpl implements ISignupService {
    @Autowired
    UserRepository signupRepository;
    @Override
    public SignupResponse addUser(SignUpRequest signUpRequest) {
        return null;
    }
}
