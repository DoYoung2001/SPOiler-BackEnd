package SPOilerBackend.user;

import SPOilerBackend.Login.SecurityUtils;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;


    //getter
    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    protected User() {
    }

    public boolean compare(String password) {
        String hashedPassword = SecurityUtils.sha256Encrypt(password);
        return this.password.equals(hashedPassword);
    }
}
