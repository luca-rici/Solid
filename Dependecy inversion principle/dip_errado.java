public interface AuthService {
    User authenticate(String username, String password);
}

public class LoginService {

    private AuthService authService;
    public LoginService(AuthService authService) {
        this.authService = authService;
    }

    public User login(String username, String password) {
        User user = authService.authenticate(username, password);
        return user;
    }
}
