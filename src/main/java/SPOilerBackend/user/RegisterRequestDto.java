package SPOilerBackend.user;

public record RegisterRequestDto(
        String email,
        String password
) {
}
