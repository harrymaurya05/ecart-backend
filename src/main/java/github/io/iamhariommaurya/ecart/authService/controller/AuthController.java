package github.io.iamhariommaurya.ecart.authService.controller;

import github.io.iamhariommaurya.ecart.authService.model.LoginRequest;
import github.io.iamhariommaurya.ecart.authService.model.LoginResponse;
import github.io.iamhariommaurya.ecart.authService.model.SignUpRequest;
import github.io.iamhariommaurya.ecart.authService.model.SignupResponse;
import github.io.iamhariommaurya.ecart.authService.service.ILoginService;
import github.io.iamhariommaurya.ecart.authService.service.ISignupService;
import github.io.iamhariommaurya.ecart.utility.models.ServiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/")
public class AuthController {
    @Autowired
    private  ISignupService signupService;
    @Autowired
    private ILoginService loginService;

    @GetMapping(value = "/test")
    public ResponseEntity<ServiceResponse> testing(){
        return ResponseEntity.ok(ServiceResponse.builder().code("200").message("Hello world!!").build());
    }
    @PostMapping(value = "login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        System.out.println(loginRequest.toString());
        return ResponseEntity.ok(loginService.validateLogin(loginRequest));
    }

    @PostMapping(value = "singin")
    public ResponseEntity<SignupResponse> singUp(@RequestBody SignUpRequest signUpRequest){

        System.out.println("storing database in DB : "+signUpRequest);
        return ResponseEntity.ok(signupService.addUser(signUpRequest));
    }

}
