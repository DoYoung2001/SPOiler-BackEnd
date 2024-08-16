package SPOilerBackend.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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
}
