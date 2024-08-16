package SPOilerBackend.user;

import SPOilerBackend.Login.JwtProvider;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    public UserService(UserRepository userRepository, JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.jwtProvider = jwtProvider;
    }

    // 회원가입
    public RegisterResponseDto register(RegisterRequestDto request) {

        User user = new User(request.email(), request.password());

        User userSave = userRepository.save(user);

        return new RegisterResponseDto(
                userSave.getEmail(),
                userSave.getPassword()
        );
    }

    // 로그인
    public LoginResponse login(LoginRequest request) {
        User user = checkEmailPassword(request);
        String token = generateToken(user);
        return new LoginResponse(token);
    }

    //email password 체크
    private User checkEmailPassword(LoginRequest request) {
        // email 검증
        User user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new IllegalArgumentException("ID 또는 PW가 틀립니다"));
        //password 비교
        if (!user.compare(request.password())) {
            throw new IllegalArgumentException("ID 또는 PW가 틀립니다");
        }
        return user;
    }

    // 토큰 발급
    public String generateToken(User user) {
        return jwtProvider.createToken(user.getEmail());
    }

    public void logout() {

    }
}

