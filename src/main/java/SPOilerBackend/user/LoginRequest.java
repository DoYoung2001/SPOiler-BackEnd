package SPOilerBackend.user;

import jakarta.validation.constraints.NotNull;

public record LoginRequest(
        String email,
        @NotNull String password
) {

}
