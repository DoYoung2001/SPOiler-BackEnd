package SPOilerBackend.user;

public record LoginRequest(
        String email,
        String password
) {

}
