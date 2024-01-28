package github.io.iamhariommaurya.ecart.authService.service.impl;

import github.io.iamhariommaurya.ecart.authService.entity.User;
import github.io.iamhariommaurya.ecart.authService.model.LoginRequest;
import github.io.iamhariommaurya.ecart.authService.model.LoginResponse;
import github.io.iamhariommaurya.ecart.authService.repository.UserRepository;
import github.io.iamhariommaurya.ecart.authService.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    UserRepository userRepository;

    @Override
    public LoginResponse validateLogin(LoginRequest loginRequest) {
        Optional<User> optionalUser = userRepository
                .findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return LoginResponse.builder().user(user).code("200").message("Valid user!!!").build();
        } else {
            return LoginResponse.builder().code("403").message("Not Valid user!!!").build();
        }
    }
}
