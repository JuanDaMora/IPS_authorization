package jdmorantesv.ips_authorization.contoller;


import jdmorantesv.ips_authorization.request.AuthResponse;
import jdmorantesv.ips_authorization.request.LoginRequest;
import jdmorantesv.ips_authorization.request.RegisterRequest;
import jdmorantesv.ips_authorization.service.impl.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private final AuthService authService;
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value="login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value="register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }
}
