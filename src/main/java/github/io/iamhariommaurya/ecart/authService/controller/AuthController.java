package github.io.iamhariommaurya.ecart.authService.controller;

import github.io.iamhariommaurya.ecart.authService.model.LoginRequest;
import github.io.iamhariommaurya.ecart.authService.model.SignUpRequest;
import github.io.iamhariommaurya.ecart.authService.model.SignupResponse;
import github.io.iamhariommaurya.ecart.authService.service.ISignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/")
public class AuthController {
    @Autowired
    private  ISignupService signupService;
    @PostMapping(value = "login")
    public String login(@RequestBody LoginRequest loginRequest){
        System.out.println(loginRequest.toString());
        return "Login Successfully!!";
    }

    @PostMapping(value = "singup")
    public ResponseEntity<SignupResponse> singUp(@RequestBody SignUpRequest signUpRequest){

        System.out.println("store data in databases : "+signUpRequest);
        return ResponseEntity.ok(signupService.addUser(signUpRequest));
    }

}
