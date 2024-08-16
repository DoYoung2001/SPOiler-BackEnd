package SPOilerBackend.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/users")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 회원 가입
    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegisterRequestDto request) {
        try {
            userService.register(request);
            return ResponseEntity.status(HttpStatus.CREATED).build(); // 성공 시 201 Created 반환
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); // 클라이언트 오류 시 400 Bad Request 반환
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 서버 오류 시 500 Internal Server Error 반환
        }
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
