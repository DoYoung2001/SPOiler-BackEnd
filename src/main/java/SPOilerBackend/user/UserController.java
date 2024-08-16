package SPOilerBackend.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/users")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 회원 가입
    @PostMapping("/join")
    public RegisterResponseDto register(@RequestBody RegisterRequestDto request) {

        return userService.register(request);

    }

    // 로그인
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request){
        return userService.login(request);
    }

    //로그아웃
    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        // 로그아웃 처리 로직 추가
        userService.logout();
        return ResponseEntity.ok("로그아웃 성공");
    }


}
